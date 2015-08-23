package cn.BiochemistryCraft.event;

import java.util.ArrayList;
import java.util.List;

import cn.BiochemistryCraft.core.sick.SSick;
import cn.BiochemistryCraft.core.sick.SickPlayerInfo;
import cn.BiochemistryCraft.network.PacketMain;
import cn.BiochemistryCraft.network.packet.PacketSickInfo;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class EventPlayer {
	@SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event){
		List<SSick> a = SickPlayerInfo.read(event.player);
		if(a == null){
			a = new ArrayList<SSick>();
		}
		PacketMain.sendToPlayer(new PacketSickInfo(a, SickPlayerInfo.immuneValue, SickPlayerInfo.infectValue), event.player);
    }

    @SubscribeEvent
    public void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event){
    	List<SSick> a = SickPlayerInfo.read(event.player);
		if(a == null){
			a = new ArrayList<SSick>();
		}
		PacketMain.sendToPlayer(new PacketSickInfo(a, SickPlayerInfo.immuneValue, SickPlayerInfo.infectValue), event.player);
    }
}
