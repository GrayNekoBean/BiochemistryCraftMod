package cn.BiochemistryCraft.network;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public interface ICallServer {
	public IMessage handleServerSide(EntityPlayer player);
}
