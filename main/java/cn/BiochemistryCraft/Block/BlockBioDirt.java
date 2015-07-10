package cn.BiochemistryCraft.Block;

import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBioDirt extends BCCBlockBase{

	public BlockBioDirt(Material p_i45394_1_) {
		super(p_i45394_1_);
		
		
		// TODO Auto-generated constructor stub
		this.setBlock("BioDirt",true);
		//this.setBlockName("BioDirt");
		//this.setBlockTextureName("biomod:BioDirt");
		this.setHardness(0.5f);
		this.setResistance(10.0f);
		this.setLightLevel(6.0f);
		this.setHarvestLevel("shavel", 0);
		this.setStepSound(Block.soundTypeGrass);
		//this.setCreativeTab(CreativeTabs.tabTransport);
	}
	
}
