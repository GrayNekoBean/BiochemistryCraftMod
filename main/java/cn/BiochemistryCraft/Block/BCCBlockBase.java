package cn.BiochemistryCraft.Block;

import cn.BiochemistryCraft.BiochemistryCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BCCBlockBase extends Block{

	protected BCCBlockBase(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO 自动生成的构造函数存根
	}
	
	public void setBlock(String str){
		this.setBlockName(str);
		this.setBlockTextureName(BiochemistryCraft.NAME + this.getUnlocalizedName() );
		GameRegistry.registerBlock(this,this.getUnlocalizedName());
		
	}

}
