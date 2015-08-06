package cn.BiochemistryCraft.Register;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Block.BCCBlockBase;
import cn.BiochemistryCraft.Block.BlockAcid;
import cn.BiochemistryCraft.Block.BlockBioDirt;
import cn.BiochemistryCraft.Block.BlockBioExtracter;
import cn.BiochemistryCraft.Block.BlockGoldenVine;
import cn.BiochemistryCraft.Block.BlockGracilariaCorp;
import cn.BiochemistryCraft.Block.BlockHerbsCorps;
import cn.BiochemistryCraft.Block.BlockTreeFruit;
import cn.BiochemistryCraft.Block.BlockTreeFruitLeave;
import cn.BiochemistryCraft.Block.BlockTreeFruitSapling;
import cpw.mods.fml.common.registry.GameRegistry;

public class BCCRegisterBlock {
	public static Block biodirt;
	public static Block bioextracter;
	public static Block acid;
	public static Block corrodedStone;
	public static Block acidicDirt;
	
	public static Block treeFruitBlock;
	public static Block treeFruitLeave;
	public static Block treeFruitSaplingBlock;
	public static Block goldenVine;
	public static Block gracilariaCorp;
	
	public static BlockHerbsCorps fireGrassCorp;
	public static BlockHerbsCorps coolGrassCorp;
	public static BlockHerbsCorps plasmaBerryCorp;
	
	public static Fluid facid;
	public static Block acid2;
	
	public static BlockHerbsCorps[] herbsCorpArray = {fireGrassCorp, coolGrassCorp, plasmaBerryCorp};
	
	public BCCRegisterBlock()
	{
		biodirt = new BlockBioDirt(Material.grass);
		bioextracter=new BlockBioExtracter(Material.wood);
		acid=new BlockAcid(Material.clay);
		corrodedStone = new BCCBlockBase(Material.rock).setBlockName("CStone").setBlockTextureName(BiochemistryCraft.MODID + ":CStone").setCreativeTab(BiochemistryCraft.biocreativetab);
		acidicDirt = new BCCBlockBase(Material.ground).setBlockName("ADirt").setBlockTextureName(BiochemistryCraft.MODID + ":ADirt").setCreativeTab(BiochemistryCraft.biocreativetab);
		treeFruitBlock=new BlockTreeFruit();
		treeFruitLeave=new BlockTreeFruitLeave();
		treeFruitSaplingBlock=new BlockTreeFruitSapling();
		goldenVine=new BlockGoldenVine();
		gracilariaCorp=new BlockGracilariaCorp();
		
		for(int i = 0; i <= 2; i++){
			herbsCorpArray[i] = new BlockHerbsCorps(i);
		}

		facid = new Fluid("Acid").setViscosity(1200);
		FluidRegistry.registerFluid(facid);
		acid2 = new BlockAcid.FluidAcid(facid,Material.water);
		((BlockAcid.FluidAcid) acid2).setQuantaPerBlock(8);
		acid2.setBlockName("Acid");
		facid.setBlock(acid2);
	}
	
	
	
	
	public void blockRegisterInit(){
		
		//this.example=new exampleBlock();
		GameRegistry.registerBlock(biodirt, "BioDirt");
		GameRegistry.registerBlock(bioextracter, "BioExtracter");
		GameRegistry.registerBlock(acid, "Acid");
		GameRegistry.registerBlock(corrodedStone, "corroded_stone");
		GameRegistry.registerBlock(acidicDirt, "acidic_dirt");
		GameRegistry.registerBlock(treeFruitBlock, "treeFruitBlock");
		GameRegistry.registerBlock(treeFruitLeave, "treeFruitLeave");
		GameRegistry.registerBlock(treeFruitSaplingBlock, "treeFruitSaplingBlock");
		GameRegistry.registerBlock(goldenVine, "goldenVine");
		GameRegistry.registerBlock(gracilariaCorp, "gracilariaCorp");
		
		for(int i = 0; i <= 1; i++){
			GameRegistry.registerBlock(herbsCorpArray[i], BlockHerbsCorps.getName(i));
		}
		
		GameRegistry.registerBlock(acid2, "AcidStill");
	}
}
