package cn.BiochemistryCraft.Register;

import cpw.mods.fml.common.registry.GameRegistry;
import cn.BiochemistryCraft.Block.BlockBioDirt;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BCCRegisterBlock {
	
	public static Block biodirt;
	
	public BCCRegisterBlock()
	{
		biodirt = new BlockBioDirt(Material.grass);
	}
	
	
	
	
	public void blockRegisterInit(){
		
		//this.example=new exampleBlock();
		GameRegistry.registerBlock(biodirt, "BioDirt");
		
		
	}

}
