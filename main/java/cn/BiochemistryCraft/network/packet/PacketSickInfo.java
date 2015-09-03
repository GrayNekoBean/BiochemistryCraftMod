package cn.BiochemistryCraft.network.packet;

import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.PacketBuffer;
import cn.BiochemistryCraft.core.BCCLogger;
import cn.BiochemistryCraft.core.sick.SSick;
import cn.BiochemistryCraft.core.sick.SickPlayerInfo;
import cn.BiochemistryCraft.core.sick.SickRegistry;
import cn.BiochemistryCraft.network.AbstractPacket;
import cn.BiochemistryCraft.network.ICallClient;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class PacketSickInfo extends AbstractPacket implements ICallClient {
	private NBTTagCompound tagCompound;
	private static final String NBT_ROOT = SickPlayerInfo.NBT_ROOT;
	private static final String NBT_SICK = SickPlayerInfo.NBT_SICK;
	private static final String NBT_IMMUNE = SickPlayerInfo.NBT_IMMUNE;
	private static final String NBT_INFECT = SickPlayerInfo.NBT_INFECT;
	
	public PacketSickInfo(){
		
	}
	
	@SuppressWarnings("static-access")
	public PacketSickInfo(List<SSick> sick, int immune, int infect){
		int[] a = new int[sick.size()];
		tagCompound = new NBTTagCompound();
/*        for(int i = 0; i < sick.size(); i++){
        	a[i] = sick.get(i).sickID;
        }*/
        if (!tagCompound.hasKey(NBT_ROOT)){
        	tagCompound.setTag(NBT_ROOT, new NBTTagCompound());
        }
        if(!sick.isEmpty()){
        	NBTTagList list = new NBTTagList();
        	Iterator it = sick.iterator();
        	while (it.hasNext()) {
				SSick sickonly = (SSick) it.next();
				list.appendTag(SickRegistry.writeSicknessToNBT(sickonly, new NBTTagCompound()));
			}
        	tagCompound.getCompoundTag(NBT_ROOT).setTag(NBT_SICK, list);
        }
//        tagCompound.getCompoundTag(NBT_ROOT).setIntArray(NBT_SICK, a);
        tagCompound.getCompoundTag(NBT_ROOT).setInteger(NBT_IMMUNE, immune);
        tagCompound.getCompoundTag(NBT_ROOT).setInteger(NBT_INFECT, infect);
	}
	
	@Override
	public IMessage handleClientSide(EntityPlayer player) {
		NBTTagCompound root = SickPlayerInfo.getPersistedFromPlayer(player);
		if (!root.hasKey(NBT_ROOT)){
			root.setTag(NBT_ROOT, new NBTTagCompound());
        }else{
        	root.setTag(NBT_SICK, root.getCompoundTag(NBT_ROOT).getTagList(NBT_SICK, 10));
//        	root.setIntArray(NBT_SICK, root.getCompoundTag(NBT_ROOT).getIntArray(NBT_SICK));
        	root.setInteger(NBT_IMMUNE, root.getCompoundTag(NBT_ROOT).getInteger(NBT_IMMUNE));
        	root.setInteger(NBT_INFECT, root.getCompoundTag(NBT_ROOT).getInteger(NBT_INFECT));
        }
		return null;
	}

	@Override
	public void encodeInto(ByteBuf buffer) {
		PacketBuffer packet = new PacketBuffer(buffer);
        try{
            packet.writeNBTTagCompoundToBuffer(tagCompound);
        }
        catch (IOException e){
            BCCLogger.warn("Warning: Failed to send NBT tag.");
        }
	}

	@Override
	public void decodeInto(ByteBuf buffer) {
		PacketBuffer packet = new PacketBuffer(buffer);
        try{
        	tagCompound = packet.readNBTTagCompoundFromBuffer();
        }
        catch (IOException e){
            BCCLogger.warn("Warning: Failed to receive NBT tag.");
        }
	}
}
