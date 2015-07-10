package cn.BiochemistryCraft.Block;

import cn.BiochemistryCraft.BiochemistryCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BCCBlockBase extends Block{

	public BCCBlockBase(Material m) {
		super(m);
		// TODO 方块的数据
	}
	
	
	public void setBlock(String str){
		this.setBlockName(str);
		this.setBlockTextureName(BiochemistryCraft.MODID +":" + str);
	}

	public void setBlock(String str,CreativeTabs c){
		this.setBlockName(str);
		this.setBlockTextureName(BiochemistryCraft.MODID +":" + str);
		this.setCreativeTab(c);
	}
	
}
