package cn.BiochemistryCraft.event;

import cn.BiochemistryCraft.Block.BlockHerbsCorps;
import cn.BiochemistryCraft.Register.BCCAchievementRegister;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import cn.BiochemistryCraft.Register.BCCRegisterItem;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
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
	for (int i = 0; i < BCCRegisterItem.herbsArray.length; i++) {
	if(((event.world.getBlock(event.x, event.y, event.z) == BCCRegisterBlock.biodirt)
		||(event.world.getBlock(event.x, event.y, event.z) == Blocks.dirt) || (event.world.getBlock(event.x, event.y, event.z) == Blocks.grass))
		&& event.face == 1 && event.entityPlayer.getCurrentEquippedItem().getItem() == BCCRegisterItem.herbsArray[i]){
	    event.entityPlayer.triggerAchievement(BCCAchievementRegister.herbfac);
	}
    }
    }
}
