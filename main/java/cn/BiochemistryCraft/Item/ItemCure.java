package cn.BiochemistryCraft.Item;

import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.core.sick.SSick;
import cn.BiochemistryCraft.core.sick.SickPlayerInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCure extends Item {
    /** Number of ticks to run while 'EnumAction'ing until result. */
    public final int itemUseDuration;
    /** The amount this food item heals the player. */
    private final int healAmount;
    private final float saturationModifier;
    public ItemCure(int p_i45339_1_, float p_i45339_2_)
    {
    	this.itemUseDuration = 32;
    	this.healAmount = p_i45339_1_;
    	this.saturationModifier = p_i45339_2_;
        this.setCreativeTab(BiochemistryCraft.biocreativetab);
    }

    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        if (!p_77654_3_.capabilities.isCreativeMode)
        {
            --p_77654_1_.stackSize;
        }
        p_77654_3_.getFoodStats().addStats(getHeal(p_77654_1_), getModifier(p_77654_1_));
        p_77654_2_.playSoundAtEntity(p_77654_3_, "random.burp", 0.5F, p_77654_2_.rand.nextFloat() * 0.1F + 0.9F);
        this.onCureTaken(p_77654_1_, p_77654_2_, p_77654_3_);
        return p_77654_1_;
    }
    protected void onCureTaken(ItemStack itemStack, World world, EntityPlayer player) {
    	if(SickPlayerInfo.getSickListFromPlayer(player) != null){
    	for (SSick sick : SickPlayerInfo.read(player)) {
			if(sick.curetiveList != null && sick.curetiveList.contains(itemStack)){
				sick.endSick();
//				SickPlayerInfo.removeSick(player, sick);

			}
		}
    	}
		player.curePotionEffects(itemStack);
	}
    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.eat;
    }
    
    public int getHeal(ItemStack p_150905_1_)
    {
        return this.healAmount;
    }

    public float getModifier(ItemStack p_150906_1_)
    {
        return this.saturationModifier;
    }
    
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
        return p_77659_1_;
    }
}
