package cn.BiochemistryCraft.network;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public interface ICallClient {
	public IMessage handleClientSide(EntityPlayer player);
}
