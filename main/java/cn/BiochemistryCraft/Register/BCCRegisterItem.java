package cn.BiochemistryCraft.Register;

import cn.BiochemistryCraft.Item.ItemBs;
import cn.BiochemistryCraft.Item.ItemTnc;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;

public class BCCRegisterItem {
	
	public static Item emptyneedle;
	
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
	public static Item[] bloodgr = {cowblood, pigblood, chickenblood, wolfblood, playerblood, batblood, horseblood, mushroomblood, ocelotblood, sheepblood, squidblood,
		cavespiderblood, creeperblood, endermanblood, ghostblood, magmacubeblood, pigzombieblood, silverfishblood, slimeblood, spiderblood, witchblood, zombieblood};
	
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
		}
		emptyneedle = new ItemTnc();
	}
	
	public void ItemRegisterInit(){
		
		
		GameRegistry.registerItem(emptyneedle, "EmptyNeedle");
		
		for(int i=0;i<22;i++)
		{
			GameRegistry.registerItem(bloodgr[i], ItemBs.getxzsmean(i)+"Needle");
		}
		
	}
		
	}


