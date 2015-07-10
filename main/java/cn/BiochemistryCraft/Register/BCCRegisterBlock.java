package cn.BiochemistryCraft.Register;

import cpw.mods.fml.common.registry.GameRegistry;
import cn.BiochemistryCraft.Block.BlockBioDirt;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BCCRegisterBlock {
	//静态变量置放区
public static Block biodirt= new BlockBioDirt(Material.gourd);
	
	
	
	
	
	//方块注册区
	public static void blockRegisterInit(){
		
		//this.example=new exampleBlock();
		GameRegistry.registerBlock(biodirt, "生化泥土");
		
		
	}

}
