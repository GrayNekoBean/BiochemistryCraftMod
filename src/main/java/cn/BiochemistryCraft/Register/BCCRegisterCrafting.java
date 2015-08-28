package cn.BiochemistryCraft.Register;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class BCCRegisterCrafting {
	public static void init()
	{
		GameRegistry.addRecipe(new ItemStack(BCCRegisterBlock.bioextracter,1),
				new Object[] {"ABA", "BCB", "ABA", 'A', Items.iron_ingot,'B',Items.redstone,'C',BCCRegisterItem.biobrain});
		GameRegistry.addRecipe(new ItemStack(BCCRegisterItem.biobrain,1),
				new Object[] {" A ","ABA"," A ",'A',BCCRegisterBlock.biodirt,'B',Items.redstone});
		
		GameRegistry.addSmelting(BCCRegisterBlock.pyrite, new ItemStack(BCCRegisterItem.sulfurDust, 1, 0), 1F);
		
		OreDictionary.registerOre("pyrite", new ItemStack(BCCRegisterBlock.pyrite));
	}
}
