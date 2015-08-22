package cn.BiochemistryCraft.Block;

import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockPyrite extends Block {
	public BlockPyrite(){
		super(Material.rock);
		setCreativeTab(BiochemistryCraft.biocreativetab);
		setBlockName("pyrite");
		setBlockTextureName(BiochemistryCraft.MODID+":pyrite");
		setHardness(3.0F);
		setStepSound(soundTypeStone);
	}
}
