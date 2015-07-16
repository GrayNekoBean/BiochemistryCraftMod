package cn.BiochemistryCraft.Register;

import cpw.mods.fml.common.registry.GameRegistry;
import cn.BiochemistryCraft.Block.BlockAcid;
import cn.BiochemistryCraft.Block.BlockBioDirt;
import cn.BiochemistryCraft.Block.BlockBioExtracter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BCCRegisterBlock {
	
	public static Block biodirt;
	public static Block bioextracter;
	public static Block acid;
	
	public BCCRegisterBlock()
	{
		biodirt = new BlockBioDirt(Material.grass);
		bioextracter=new BlockBioExtracter(Material.wood);
		acid=new BlockAcid(Material.clay);
	}
	
	
	
	
	public void blockRegisterInit(){
		
		//this.example=new exampleBlock();
		GameRegistry.registerBlock(biodirt, "BioDirt");
		GameRegistry.registerBlock(bioextracter, "BioExtracter");
		GameRegistry.registerBlock(acid, "Acid");
	}

}
