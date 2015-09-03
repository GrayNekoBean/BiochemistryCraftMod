package cn.BiochemistryCraft.Item;

import net.minecraft.item.ItemFood;
import cn.BiochemistryCraft.BiochemistryCraft;

public class ItemGoldenVineFruit extends ItemCure{

	public ItemGoldenVineFruit(){
		super(2, 0.8F);
		setTextureName(BiochemistryCraft.MODID+":goldenVineFruit");
	    setCreativeTab(BiochemistryCraft.biocreativetab);
		setUnlocalizedName("goldenVineFruit");
	}
	
}
