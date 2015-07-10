package cn.BiochemistryCraft.Register;

import cn.BiochemistryCraft.Item.ItemBs;
import cn.BiochemistryCraft.Item.ItemTnc;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;

public class BCCRegisterItem {
	
public static Item Theneedlecylinder;
	
	public static Item cowblood;
	public static Item pigblood;
	public static Item chickenblood;
	public static Item wolfblood;
	public static Item playerblood;
	public static Item batblood;
	public static Item horseblood;
	public static Item mooshroomblood;
	public static Item ocelotblood;
	public static Item sheepblood;
	public static Item squidblood;
	public static Item cavespiderblood;
	public static Item creeperblood;
	public static Item endermanblood;
	public static Item ghastblood;
	public static Item magmacubeblood;
	public static Item pigzombieblood;
	public static Item silverfishblood;
	public static Item slimeblood;
	public static Item spiderblood;
	public static Item witchblood;
	public static Item zombieblood;
	public static Item[] bloodgr = {cowblood, pigblood, chickenblood, wolfblood, playerblood, batblood, horseblood, mooshroomblood, ocelotblood, sheepblood, squidblood,
		cavespiderblood, creeperblood, endermanblood, ghastblood, magmacubeblood, pigzombieblood, silverfishblood, slimeblood, spiderblood, witchblood, zombieblood};
	
	public static void ItemRegisterInit(){
		
		Theneedlecylinder = new ItemTnc();
		LanguageRegistry.addName(Theneedlecylinder, "空针筒");
		
		int i = 0;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs(i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");	i++;
		bloodgr[i] = new ItemBs( i);
		LanguageRegistry.addName(bloodgr[i], ItemBs.getxzsmean(i) + "针筒");
	}
		
	}


