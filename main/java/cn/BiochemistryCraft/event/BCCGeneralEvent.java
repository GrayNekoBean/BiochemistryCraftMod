package cn.BiochemistryCraft.event;

import net.minecraft.item.Item;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cn.BiochemistryCraft.Item.ItemHerbs;
import cn.BiochemistryCraft.Register.BCCAchievementRegister;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import cn.BiochemistryCraft.Register.BCCRegisterItem;
import cn.BiochemistryCraft.core.BCCLogger;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class BCCGeneralEvent {

    public BCCGeneralEvent() {
	// TODO Auto-generated constructor stub
    }
    @SubscribeEvent
    public void onItemPickup(PlayerEvent.ItemPickupEvent event){
	Item item = event.pickedUp.getEntityItem().getItem();
	if(item == Item.getItemFromBlock(BCCRegisterBlock.biodirt)){
	    event.player.triggerAchievement(BCCAchievementRegister.beginner);
	}
	if(item == BCCRegisterItem.treeFruit){
	    event.player.triggerAchievement(BCCAchievementRegister.treef);
	}
	for (int i = 0; i < BCCRegisterItem.herbsArray.length; i++) {
	    if(item == BCCRegisterItem.herbsArray[i]){
//		event.player.triggerAchievement(BCCAchievementRegister.herbfac);
	    }
	}
    }
    @SubscribeEvent
    public void onInteract(PlayerInteractEvent event){
    	try{
    		if(ItemHerbs.canPlaceOn(event.world.getBlock(event.x, event.y, event.z)) && event.face == 1){
    			for (int i = 0; i < BCCRegisterItem.herbsArray.length; i++) {
    				if(event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == BCCRegisterItem.herbsArray[i]){
    					event.entityPlayer.triggerAchievement(BCCAchievementRegister.herbfac);
    				}
    			}
    		}
    	}
    	catch(Exception e){
    		BCCLogger.warn("***********************************");
    		BCCLogger.warn("Something here went wrong:");
    		e.printStackTrace();
    		BCCLogger.warn("***********************************");
    		event.setCanceled(true);
    	}
    }
}
