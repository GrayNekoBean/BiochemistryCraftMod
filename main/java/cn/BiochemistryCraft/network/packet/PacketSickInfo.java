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
import cn.BiochemistryCraft.network.AbstractPacket;
import cn.BiochemistryCraft.network.ICallClient;

public class PacketSickInfo extends AbstractPacket implements ICallClient {
private NBTTagCompound tagCompound;
	
	public PacketSickInfo(){
		
	}
	
	public PacketSickInfo(List<SSick> a){
		tagCompound = new NBTTagCompound();
		SickPlayerInfo.write(tagCompound, a);
	}
	
	@Override
	public IMessage handleClientSide(EntityPlayer player) {
		SickPlayerInfo.write(player, SickPlayerInfo.read(player));
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
