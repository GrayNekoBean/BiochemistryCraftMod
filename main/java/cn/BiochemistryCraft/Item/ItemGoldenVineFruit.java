package cn.BiochemistryCraft.Item;

import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemGoldenVineFruit extends ItemFood{

	public ItemGoldenVineFruit(){
		super(2, 0.8F, false);
		setTextureName(BiochemistryCraft.MODID+":goldenVineFruit");
	    setCreativeTab(BiochemistryCraft.biocreativetab);
		setUnlocalizedName("goldenVineFruit");
	}
	
}
