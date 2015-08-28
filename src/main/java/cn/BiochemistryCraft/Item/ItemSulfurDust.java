package cn.BiochemistryCraft.Item;

import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.item.Item;

public class ItemSulfurDust extends Item{
	public ItemSulfurDust(){
		setTextureName(BiochemistryCraft.MODID + ":sulfurDust");
		setCreativeTab(BiochemistryCraft.biocreativetab);
		setUnlocalizedName("sulfurDust");
	}
}
