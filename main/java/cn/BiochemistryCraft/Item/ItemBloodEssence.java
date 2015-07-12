package cn.BiochemistryCraft.Item;

import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.item.Item;

public class ItemBloodEssence extends Item{
	public static int xz;
	public ItemBloodEssence(int xzs)
	{
		this.xz=xzs;
		this.setCreativeTab(BiochemistryCraft.biocreativetab);
		this.setMaxStackSize(16);
		this.setMaxDamage(1);
	}
	
	public static String getxzsmean(int xz){
		switch(xz){
			case 0: return "CowBloodEssence"; 
			case 1: return "PigBloodEssence"; 
			case 2: return "ChickenBloodEssence"; 
			case 3: return "WolfBloodEssence";
			case 4: return "HumanBloodEssence";
			case 5: return "BatBloodEssence";
			case 6: return "HorseBloodEssence";
			case 7: return "MushroomBloodEssence";
			case 8: return "CatBloodEssence";
			case 9: return "SheepBloodEssence";
			case 10: return "SquidBloodEssence";
			case 11: return "CavespiderBloodEssence";
			case 12: return "CreeperBloodEssence";
			case 13: return "EndermanBloodEssence";
			case 14: return "GhostBloodEssence";
			case 15: return "MagmacubeBloodEssence";
			case 16: return "PigzombieBloodEssence";
			case 17: return "SilverfishBloodEssence";
			case 18: return "SlimeBloodEssence";
			case 19: return "SpiderBloodEssence";
			case 20: return "WitchBloodEssence";
			case 21: return "ZombieBloodEssence";
			default: return "CowBloodEssence";
		}
	}
}
