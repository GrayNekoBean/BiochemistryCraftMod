package cn.BiochemistryCraft.Register;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Item.ItemAcidBottle;
import cn.BiochemistryCraft.Item.ItemAcidWand;
import cn.BiochemistryCraft.Item.ItemBioBrain;
import cn.BiochemistryCraft.Item.ItemBloodEssence;
import cn.BiochemistryCraft.Item.ItemBs;
import cn.BiochemistryCraft.Item.ItemGracilaria;
import cn.BiochemistryCraft.Item.ItemHerbs;
import cn.BiochemistryCraft.Item.ItemTnc;
import cn.BiochemistryCraft.Item.ItemTreeFruit;
import cn.BiochemistryCraft.Item.ItemTreeFruitSapling;
import cpw.mods.fml.common.registry.GameRegistry;

public class BCCRegisterItem {
	
	public static Item emptyneedle;
	public static Item biobrain;
	public static Item acidwand;
	
	public static Item cowblood;
	public static Item pigblood;
	public static Item chickenblood;
	public static Item wolfblood;
	public static Item playerblood;
	public static Item batblood;
	public static Item horseblood;
	public static Item mushroomblood;
	public static Item ocelotblood;
	public static Item sheepblood;
	public static Item squidblood;
	public static Item cavespiderblood;
	public static Item creeperblood;
	public static Item endermanblood;
	public static Item ghostblood;
	public static Item magmacubeblood;
	public static Item pigzombieblood;
	public static Item silverfishblood;
	public static Item slimeblood;
	public static Item spiderblood;
	public static Item witchblood;
	public static Item zombieblood;
	
	public static Item cowbloodessence;
	public static Item pigbloodessence;
	public static Item chickenbloodessence;
	public static Item wolfbloodessence;
	public static Item playerbloodessence;
	public static Item batbloodessence;
	public static Item horsebloodessence;
	public static Item mushroombloodessence;
	public static Item ocelotbloodessence;
	public static Item sheepbloodessence;
	public static Item squidbloodessence;
	public static Item cavespiderbloodessence;
	public static Item creeperbloodessence;
	public static Item endermanbloodessence;
	public static Item ghostbloodessence;
	public static Item magmacubebloodessence;
	public static Item pigzombiebloodessence;
	public static Item silverfishbloodessence;
	public static Item slimebloodessence;
	public static Item spiderbloodessence;
	public static Item witchbloodessence;
	public static Item zombiebloodessence;
	
	public static ItemHerbs fireGrass;
	public static ItemHerbs coolGrass;
	public static ItemHerbs plasmaBerry;
	
	public static Item treeFruit;
	public static Item treeFruitSapling;
	public static Item goldenVineFruit;
	public static Item gracilaria;
	
	public static ItemAcidBottle bucketAcid;
	
	public static Item[] bloodgr = {cowblood, pigblood, chickenblood, wolfblood, playerblood, batblood, horseblood, mushroomblood, ocelotblood, sheepblood, squidblood,
		cavespiderblood, creeperblood, endermanblood, ghostblood, magmacubeblood, pigzombieblood, silverfishblood, slimeblood, spiderblood, witchblood, zombieblood};
	public static Item[] bloodes = {cowbloodessence, pigbloodessence, chickenbloodessence, wolfbloodessence, playerbloodessence,
		batbloodessence, horsebloodessence, mushroombloodessence, ocelotbloodessence, sheepbloodessence, squidbloodessence,
		cavespiderbloodessence, creeperbloodessence, endermanbloodessence, ghostbloodessence, magmacubebloodessence,
		pigzombiebloodessence, silverfishbloodessence, slimebloodessence, spiderbloodessence, witchbloodessence, zombiebloodessence};
	
	public static Item[] herbsArray = {fireGrass, coolGrass, plasmaBerry};
	
	public BCCRegisterItem()
	{
		for (int i=0;i<22;i++)
		{
			bloodgr[i]=new ItemBs(i);
			bloodgr[i].setUnlocalizedName(ItemBs.getxzsmean(i)+"Needle");
			if(i<11)
				bloodgr[i].setTextureName("biomod:AnimalNeedle");
			else
				bloodgr[i].setTextureName("biomod:MonsterNeedle");
			
			bloodes[i]=new ItemBloodEssence(i);
			bloodes[i].setUnlocalizedName(ItemBloodEssence.getxzsmean(i));
			if(i<11)
				bloodes[i].setTextureName("biomod:AnimalEssence");
			else
				bloodes[i].setTextureName("biomod:MonsterEssence");
		}
		
		for(int i = 0; i <= 2; i++){
			herbsArray[i] = new ItemHerbs(BCCRegisterBlock.herbsCorpArray[i], i);
			herbsArray[i].setCreativeTab(BiochemistryCraft.biocreativetab);
			herbsArray[i].setUnlocalizedName(ItemHerbs.getName(i));
			herbsArray[i].setTextureName(BiochemistryCraft.MODID+":"+ItemHerbs.getName(i));
		}
		
		emptyneedle = new ItemTnc();
		biobrain = new ItemBioBrain();
		acidwand = new ItemAcidWand();
		
		treeFruit = new ItemTreeFruit();
		treeFruitSapling = new ItemTreeFruitSapling();
		//goldenVineFruit = new ItemGoldenVineFruit();
		gracilaria = new ItemGracilaria();
		
				bucketAcid = (ItemAcidBottle) new ItemAcidBottle(BCCRegisterBlock.acid2, Items.glass_bottle).setUnlocalizedName("acidBottle").setTextureName(BiochemistryCraft.MODID + ":acid_bottle");
	}
	
	public void ItemRegisterInit(){
		
		
		GameRegistry.registerItem(emptyneedle, "EmptyNeedle");
		GameRegistry.registerItem(biobrain, "BioBrain");
		GameRegistry.registerItem(acidwand, "AcidWand");
		
		GameRegistry.registerItem(treeFruit, "treeFruit");
		GameRegistry.registerItem(treeFruitSapling, "treeFruitSapling");
		//GameRegistry.registerItem(goldenVineFruit, "goldenVineFruit");
		GameRegistry.registerItem(gracilaria, "gracilaria");
		
		for(int i=0;i<22;i++)
		{
			GameRegistry.registerItem(bloodgr[i], ItemBs.getxzsmean(i)+"Needle");
			GameRegistry.registerItem(bloodes[i], ItemBloodEssence.getxzsmean(i));
		}
		
		for(int i = 0; i <= 1; i++){
			GameRegistry.registerItem(herbsArray[i], ItemHerbs.getName(i));
		}

		GameRegistry.registerItem(bucketAcid, "acid_bottle");
		FluidContainerRegistry.registerFluidContainer(BCCRegisterBlock.facid, new ItemStack(bucketAcid), new ItemStack(Items.bucket));
		
		GameRegistry.registerItem(bucketAcid, "acid_bottle");
		FluidContainerRegistry.registerFluidContainer(BCCRegisterBlock.facid, new ItemStack(bucketAcid), new ItemStack(Items.bucket));
	}
		
	}


