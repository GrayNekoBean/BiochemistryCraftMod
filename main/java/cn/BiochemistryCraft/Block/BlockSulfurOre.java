package cn.BiochemistryCraft.Block;

import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSulfurOre extends Block {

	public BlockSulfurOre() {
		super(Material.rock);
		setCreativeTab(BiochemistryCraft.biocreativetab);
		setBlockName("SulfurOre");
		setBlockTextureName(BiochemistryCraft.MODID+":SulfurOre");
		setHardness(2.0F);
		setStepSound(soundTypeStone);
		// TODO 自动生成的构造函数存根
	}

}
