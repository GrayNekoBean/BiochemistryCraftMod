package cn.BiochemistryCraft.Block.Herb;

import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class BCCHerbBase extends BlockBush{

	public BCCHerbBase() {
		super();
		float f=0.2F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
		// TODO 自动生成的构造函数存根
	}
	
	public boolean canPlaceBlockOn(Block b)
	{
		return b == Blocks.grass || b==Blocks.dirt || b==Blocks.farmland || b==BCCRegisterBlock.biodirt;
	}

}
