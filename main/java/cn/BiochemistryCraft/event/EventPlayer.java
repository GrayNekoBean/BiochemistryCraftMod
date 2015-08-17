package cn.BiochemistryCraft.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cn.BiochemistryCraft.core.sick.Sick;
import cn.BiochemistryCraft.core.sick.SickPlayerInfo;
import cn.BiochemistryCraft.core.sick.SickRegistry;
import cn.BiochemistryCraft.network.PacketMain;
import cn.BiochemistryCraft.network.packet.PacketSickInfo;

public class EventPlayer {
	@SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event){
		int[] a = SickPlayerInfo.read(event.player);
		if(a == null){
			a = new int[1];
		}
		PacketMain.sendToPlayer(new PacketSickInfo(a), event.player);
    }

    @SubscribeEvent
    public void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event){
    	int[] a = SickPlayerInfo.read(event.player);
		if(a == null){
			a = new int[1];
		}
		PacketMain.sendToPlayer(new PacketSickInfo(a), event.player);
    }
}
