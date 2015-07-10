package cn.BiochemistryCraft.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import cn.BiochemistryCraft.Register.BCCRegisterItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;



public class ItemTnc extends BCCItemBase{
	
	public World world;
	
	public ItemTnc(){
		super();
		//this.setTextureName("biomod:EmptyNeedle");
		//this.setCreativeTab(CreativeTabs.tabTools);
		//this.setUnlocalizedName("EmptyNeedle");
		this.setItem("EmptyNeedle", true);
		this.setMaxStackSize(1);
		this.setMaxDamage(1);
		//GameRegistry.registerItem(this, "空针筒");
	}
	
    public boolean itemInteractionForEntity(ItemStack i, EntityPlayer e, EntityLivingBase el)
    {
    	if(!el.worldObj.isRemote){
    		if(el instanceof EntityCow){		
    			this.getBlood(e,i, BCCRegisterItem.cowblood);
    			return true;
    		}else if(el instanceof EntityPig){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.pigblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntityChicken){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.chickenblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntityWolf){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.wolfblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntityPlayer){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.playerblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntityBat){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.batblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntityHorse){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.horseblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntityMooshroom){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.mushroomblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntityOcelot){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.ocelotblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntitySheep){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.sheepblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntitySquid){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.squidblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntityCaveSpider){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.cavespiderblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntityCreeper){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.creeperblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntityEnderman){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.endermanblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntityGhast){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.ghostblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntityMagmaCube){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.magmacubeblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntityPigZombie){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.pigzombieblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntitySilverfish){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.silverfishblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntitySlime){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.slimeblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntitySpider){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.spiderblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntityWitch){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.witchblood, 1, 0), 1.0F);
	    	}else if(el instanceof EntityZombie){
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.zombieblood, 1, 0), 1.0F);
	    	}else{
	    		el.entityDropItem( new ItemStack(BCCRegisterItem.cowblood, 1, 0), 1.0F);
    	}
}
    	
        return true;
    }
    
    public boolean getBlood(EntityPlayer player,ItemStack itemstack,Item item){
    	  //ItemStack itemstack = player.inventory.getCurrentItem();

          if (itemstack != null)
          {
              //if (itemstack.stackSize-- == 1)
              //{
        	  itemstack.stackSize=0;
                  player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(item));
              //}
              //else if (!player.inventory.addItemStackToInventory(new ItemStack(item)))
              //{
              //   player.dropPlayerItemWithRandomChoice(new ItemStack(item, 1, 0), false);
              //}

              return true;
          }
          else
          {
              return false;
          }
    	
    	
    	
    	
    	
    	
    }
    		
    		
    		
    		
}
