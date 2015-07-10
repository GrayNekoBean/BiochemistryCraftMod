package cn.BiochemistryCraft.proxy;

import cn.BiochemistryCraft.Block.BlockBioDirt;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BCCBlockProxy {
	public static Block biodirt;
	
	public BCCBlockProxy()
	{
		biodirt=new BlockBioDirt(Material.grass);
	}
	
	public void init()
	{
		GameRegistry.registerBlock(biodirt, "BioDirt");
	}
}
