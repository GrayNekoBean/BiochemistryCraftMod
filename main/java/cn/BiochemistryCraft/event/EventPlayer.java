package cn.BiochemistryCraft.event;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import cn.BiochemistryCraft.core.sick.SSick;
import cn.BiochemistryCraft.core.sick.SickPlayerInfo;
import cn.BiochemistryCraft.core.sick.SickTrigger;
import cn.BiochemistryCraft.core.sick.TriggerType;
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
    @SubscribeEvent
    public void living(LivingEvent event){
    	if(event.entityLiving instanceof EntityPlayer){
        	SickTrigger.trigger(TriggerType.REACH_POSISION, new int[]{(int) event.entityLiving.posX,(int) event.entityLiving.posY,(int) event.entityLiving.posZ}, (EntityLivingBase)event.entityLiving);
    	}
    }
    
    public void onEaten(PlayerUseItemEvent.Finish event){
    	for (SSick sick : SickPlayerInfo.read(event.entityPlayer)) {
			if(sick.curetiveList.contains(event.item)){
				SickPlayerInfo.removeSick(event.entityPlayer, sick);
			}
		}
    }
}
