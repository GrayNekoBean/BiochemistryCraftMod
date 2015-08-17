package cn.BiochemistryCraft.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cn.BiochemistryCraft.core.sick.Sick;
import cn.BiochemistryCraft.core.sick.SickPlayerInfo;

public class EventPlayer {
	@SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event){
		Sick.addPlayer(event.player, SickPlayerInfo.read(event.player));
		SickPlayerInfo.onLogin(event.player);
    }

    @SubscribeEvent
    public void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event){
    	SickPlayerInfo.onLogout(event.player, Sick.getSickListFromPlayer(event.player));
    	Sick.removePlayer(event.player);
    }
}
