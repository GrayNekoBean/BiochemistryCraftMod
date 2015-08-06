package cn.BiochemistryCraft.proxy;

import cn.BiochemistryCraft.Register.BCCAchievementRegister;
import cn.BiochemistryCraft.Register.BCCBiomeRegister;
import cn.BiochemistryCraft.Register.BCCEntityRegister;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import cn.BiochemistryCraft.Register.BCCRegisterItem;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class BCCcommonProxy {
    
	public static BCCRegisterBlock blockregister;
	public static BCCRegisterItem itemregister;
	public static BCCEntityRegister entityregister;
	public static BCCBiomeRegister biomeregister;
	public static BCCAchievementRegister achievementregister;
	
	public void preInit(FMLPreInitializationEvent event){
		blockregister=new BCCRegisterBlock();
		itemregister=new BCCRegisterItem();
		entityregister=new BCCEntityRegister();
		
		blockregister.blockRegisterInit();
		itemregister.ItemRegisterInit();
		entityregister.EntityRegisterInit();
		
	}
	
	public void load(FMLInitializationEvent event){
		biomeregister=new BCCBiomeRegister();
		achievementregister=new BCCAchievementRegister();
		
		biomeregister.registerBiome();
		achievementregister.achievementsInit();
	}
	
	public void postLoad(FMLPostInitializationEvent event){
		
	}
	
	public void registerRenderThings(){
	
	}
	
	public void registerSound(){
		
	}
	
	public void registerNormalThings(){
		
	}
}
