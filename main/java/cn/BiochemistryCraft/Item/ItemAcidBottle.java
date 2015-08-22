package cn.BiochemistryCraft.Item;

import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public class ItemAcidBottle extends ItemBucket{

	public ItemAcidBottle(Block block, Item container) {
		super(block);
		setContainerItem(container);
		setCreativeTab(BiochemistryCraft.biocreativetab);
	}

}
