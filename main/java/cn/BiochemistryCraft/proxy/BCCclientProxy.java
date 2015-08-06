package cn.BiochemistryCraft.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Register.BCCEntityRegister;
import cn.BiochemistryCraft.Register.BCCEntityRendererRegister;

public class BCCclientProxy extends BCCcommonProxy{
    public static BCCEntityRendererRegister entityrendererregister;
	
	public void preInit(FMLPreInitializationEvent event){
		super.preInit(event);
	}
	
	public void load(FMLInitializationEvent event){
		super.load(event);
		entityrendererregister=new BCCEntityRendererRegister();
		entityrendererregister.EntityRenderRegisterInit();
	}
	
	public void postLoad(FMLPostInitializationEvent event){
		super.postLoad(event);
	}
	
	public void registerRenderThings(){
		super.registerRenderThings();
//		BiochemistryCraft.entityrendererregister.EntityRenderRegisterInit();
	}
	
	public void registerSound(){
		super.registerSound();
	}
	
	public void registerNormalThings(){
		super.registerNormalThings();
	}
}
