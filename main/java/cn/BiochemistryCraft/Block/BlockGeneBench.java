package cn.BiochemistryCraft.Block;

import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGeneBench extends BlockContainer{

	protected BlockGeneBench(Material m) {
		super(m);
		// TODO 自动生成的构造函数存根
		this.setBlockName("BioGeneBench");
		this.setBlockTextureName("biomod:BioGeneBench");
		this.setCreativeTab(BiochemistryCraft.biocreativetab);
		this.setHarvestLevel("shavel", 3);
		this.setStepSound(Block.soundTypeWood);
		this.setHardness(2F);
		//this.setBlockBounds(0.25F, 0.25F,0.25F, 0.75F, 0.75F,0.75F);
	}

	@Override
	public TileEntity createNewTileEntity(World w, int n) {
		// TODO 自动生成的方法存根
		return null;
	}

}
