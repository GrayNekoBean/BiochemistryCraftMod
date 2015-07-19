package cn.BiochemistryCraft.Register;

import cpw.mods.fml.common.registry.GameRegistry;
import cn.BiochemistryCraft.Block.BlockAcid;
import cn.BiochemistryCraft.Block.BlockBioDirt;
import cn.BiochemistryCraft.Block.BlockBioExtracter;
import cn.BiochemistryCraft.Block.BlockHerbsCorps;
import cn.BiochemistryCraft.Item.ItemHerbs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BCCRegisterBlock {
	
	public static Block biodirt;
	public static Block bioextracter;
	public static Block acid;
	
	public static BlockHerbsCorps fireGrassCorp;
	public static BlockHerbsCorps coolGrassCorp;
	
	public static BlockHerbsCorps[] herbsCorpArray = {fireGrassCorp, coolGrassCorp};
	
	public BCCRegisterBlock()
	{
		biodirt = new BlockBioDirt(Material.grass);
		bioextracter=new BlockBioExtracter(Material.wood);
		acid=new BlockAcid(Material.clay);
		
		for(int i = 0; i <= 1; i++){
			herbsCorpArray[i] = new BlockHerbsCorps(i, BCCRegisterBlock.biodirt);
		}
	}
	
	
	
	
	public void blockRegisterInit(){
		
		//this.example=new exampleBlock();
		GameRegistry.registerBlock(biodirt, "BioDirt");
		GameRegistry.registerBlock(bioextracter, "BioExtracter");
		GameRegistry.registerBlock(acid, "Acid");
		
		for(int i = 0; i <= 1; i++){
			GameRegistry.registerBlock(herbsCorpArray[i], BlockHerbsCorps.getName(i));
		}
	}
}
