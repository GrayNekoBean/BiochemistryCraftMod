package cn.BiochemistryCraft.Register;

import cpw.mods.fml.common.registry.GameRegistry;
import cn.BiochemistryCraft.Block.BlockAcid;
import cn.BiochemistryCraft.Block.BlockBioDirt;
import cn.BiochemistryCraft.Block.BlockBioExtracter;
import cn.BiochemistryCraft.Block.BlockHerbsCorps;
import cn.BiochemistryCraft.Block.BlockTreeFruit;
import cn.BiochemistryCraft.Block.BlockTreeFruitLeave;
import cn.BiochemistryCraft.Block.BlockTreeFruitSapling;
import cn.BiochemistryCraft.Item.ItemHerbs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BCCRegisterBlock {
	
	public static Block biodirt;
	public static Block bioextracter;
	public static Block acid;
	
	public static Block treeFruitBlock;
	public static Block treeFruitLeave;
	public static Block treeFruitSaplingBlock;
	
	public static BlockHerbsCorps fireGrassCorp;
	public static BlockHerbsCorps coolGrassCorp;
	public static BlockHerbsCorps plasmaBerryCorp;
	
	public static BlockHerbsCorps[] herbsCorpArray = {fireGrassCorp, coolGrassCorp, plasmaBerryCorp};
	
	public BCCRegisterBlock()
	{
		biodirt = new BlockBioDirt(Material.grass);
		bioextracter=new BlockBioExtracter(Material.wood);
		acid=new BlockAcid(Material.clay);
		treeFruitBlock=new BlockTreeFruit();
		treeFruitLeave=new BlockTreeFruitLeave();
		treeFruitSaplingBlock=new BlockTreeFruitSapling();
		
		for(int i = 0; i <= 2; i++){
			herbsCorpArray[i] = new BlockHerbsCorps(i);
		}
	}
	
	
	
	
	public void blockRegisterInit(){
		
		//this.example=new exampleBlock();
		GameRegistry.registerBlock(biodirt, "BioDirt");
		GameRegistry.registerBlock(bioextracter, "BioExtracter");
		GameRegistry.registerBlock(acid, "Acid");
		GameRegistry.registerBlock(treeFruitBlock, "treeFruitBlock");
		GameRegistry.registerBlock(treeFruitLeave, "treeFruitLeave");
		GameRegistry.registerBlock(treeFruitSaplingBlock, "treeFruitSaplingBlock");
		
		for(int i = 0; i <= 1; i++){
			GameRegistry.registerBlock(herbsCorpArray[i], BlockHerbsCorps.getName(i));
		}
	}
}
