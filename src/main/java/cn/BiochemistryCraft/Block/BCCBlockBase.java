package cn.BiochemistryCraft.Block;

import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BCCBlockBase extends Block{
	public static final CreativeTabs creativetab=CreativeTabs.tabTransport;
	
	public BCCBlockBase(Material m) {
		super(m);
		// TODO 方块数据
	}
	
	protected void setBlock(String str,boolean hasCreativeTab)
	{
		this.setUnlocalizedName(str);
		if(hasCreativeTab)
			this.setCreativeTab(BiochemistryCraft.biocreativetab);
	}
}
