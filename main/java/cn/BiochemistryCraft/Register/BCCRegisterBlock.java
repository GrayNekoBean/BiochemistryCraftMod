package cn.BiochemistryCraft.Register;

import cpw.mods.fml.common.registry.GameRegistry;
import cn.BiochemistryCraft.Block.BlockBioDirt;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BCCRegisterBlock {
	//��̬�����÷���
public static Block biodirt= new BlockBioDirt(Material.gourd);
	
	
	
	
	
	//����ע����
	public static void blockRegisterInit(){
		
		//this.example=new exampleBlock();
		GameRegistry.registerBlock(biodirt, "��������");
		
		
	}

}
