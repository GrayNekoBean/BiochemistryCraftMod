package cn.BiochemistryCraft.Item;

import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.item.Item;

public class ItemSulfur extends Item {
	public ItemSulfur(){
		setTextureName(BiochemistryCraft.MODID + ":Sulfur");
		setCreativeTab(BiochemistryCraft.biocreativetab);
		setUnlocalizedName("Sulfur");
	}
}
