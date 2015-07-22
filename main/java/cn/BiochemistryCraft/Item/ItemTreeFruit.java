package cn.BiochemistryCraft.Item;

import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Register.BCCRegisterItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTreeFruit extends ItemFood{

	public ItemTreeFruit() {
		super(2, 1.4F, false);
		setTextureName(BiochemistryCraft.MODID+":treeFruit");
		setCreativeTab(BiochemistryCraft.biocreativetab);
		setUnlocalizedName("treeFruit");
	}
	
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player){
	    if (!world.isRemote){
	    	player.dropItem(BCCRegisterItem.treeFruitSapling, 1);
	    }
	}
}
