package cn.BiochemistryCraft.Item;

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
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cn.BiochemistryCraft.Register.BCCRegisterItem;



public class ItemTnc extends BCCItemBase{
	
	public World world;
	
	public ItemTnc(){
		super();
		this.setItem("EmptyNeedle", true);
		this.setMaxStackSize(1);
		this.setMaxDamage(1);
	}
	
    public boolean itemInteractionForEntity(ItemStack i, EntityPlayer e, EntityLivingBase el)
    {
    	//EntityDiable entity=new EntityDiable(e.worldObj,e.posX,e.posY,e.posZ);
    	//e.worldObj.spawnEntityInWorld(entity);
    	el.attackEntityFrom(DamageSource.cactus, 2F);
    	ItemStack stack = null;
    	if(!el.worldObj.isRemote){
    		if(el instanceof EntityCow){	
    			stack = new ItemStack(BCCRegisterItem.bloodgr[0], 1, 0);
	    		--i.stackSize;
    		}else if(el instanceof EntityPig){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[1], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntityChicken){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[2], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntityWolf){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[3], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntityPlayer){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[4], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntityBat){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[5], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntityHorse){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[6], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntityMooshroom){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[7], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntityOcelot){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[8], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntitySheep){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[9], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntitySquid){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[10], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntityCaveSpider){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[11], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntityCreeper){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[12], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntityEnderman){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[13], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntityGhast){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[14], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntityMagmaCube){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[15], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntityPigZombie){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[16], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntitySilverfish){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[17], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntitySlime){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[18], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntitySpider){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[19], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntityWitch){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[20], 1, 0);
	    		--i.stackSize;
	    	}else if(el instanceof EntityZombie){
	    		stack = new ItemStack(BCCRegisterItem.bloodgr[21], 1, 0);
	    		--i.stackSize;
	    	}
    		if(stack != null){
    	            EntityItem entityitem = e.dropPlayerItemWithRandomChoice(stack, false);
    	            entityitem.delayBeforeCanPickup = 0;
    	            entityitem.func_145797_a(e.getCommandSenderName());
    	            return true;
    		}
    	}
    	return false;
    	
    }
    
    public boolean getBlood(EntityPlayer player,ItemStack itemUse,ItemStack itemGive){
    	  //ItemStack itemstack = player.inventory.getCurrentItem();

          if (itemUse != null)
          {
              //if (itemstack.stackSize-- == 1)
              //{
                  player.inventory.setInventorySlotContents(player.inventory.currentItem, itemGive);
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
