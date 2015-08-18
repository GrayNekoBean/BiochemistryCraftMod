package cn.BiochemistryCraft.network.packet;

import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.util.List;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import cn.BiochemistryCraft.core.BCCLogger;
import cn.BiochemistryCraft.core.sick.SSick;
import cn.BiochemistryCraft.core.sick.SickPlayerInfo;
import cn.BiochemistryCraft.core.sick.SickRegistry;
import cn.BiochemistryCraft.network.AbstractPacket;
import cn.BiochemistryCraft.network.ICallClient;

public class PacketSickInfo extends AbstractPacket implements ICallClient {
	private NBTTagCompound tagCompound;
	private static final String NBT_ROOT = SickPlayerInfo.NBT_ROOT;
	private static final String NBT_SICK = SickPlayerInfo.NBT_SICK;
	
	public PacketSickInfo(){
		
	}
	
	public PacketSickInfo(int[] a){
		tagCompound = new NBTTagCompound();
        if (!tagCompound.hasKey(NBT_ROOT)){
        	tagCompound.setTag(NBT_ROOT, new NBTTagCompound());
        }
        tagCompound.getCompoundTag(NBT_ROOT).setIntArray(NBT_SICK, a);
	}
	
	@Override
	public IMessage handleClientSide(EntityPlayer player) {
		NBTTagCompound root = SickPlayerInfo.getPersistedFromPlayer(player);
		if (!root.hasKey(NBT_ROOT)){
			root.setTag(NBT_ROOT, new NBTTagCompound());
        }else{
        	root.setIntArray(NBT_SICK, root.getCompoundTag(NBT_ROOT).getIntArray(NBT_SICK));
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
