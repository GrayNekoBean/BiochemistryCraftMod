package cn.BiochemistryCraft;

import cn.BiochemistryCraft.Register.BCCEntityRegister;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import cn.BiochemistryCraft.Register.BCCRegisterItem;
import cn.BiochemistryCraft.proxy.BCCcommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;



@Mod(modid=BiochemistryCraft.MODID,name=BiochemistryCraft.NAME,version=BiochemistryCraft.Version)

public class BiochemistryCraft {
	
	@Instance(BiochemistryCraft.MODID)
	public static BiochemistryCraft instance;
	
	@SidedProxy(clientSide="cn.BiochemistryCraft.proxy.BCCclientProxy",serverSide="cn.BiochemistryCraft.proxy.BCCcommonProxy")
		public static BCCcommonProxy proxy;
	
	
	public static final String MODID="biomod";
	public static final String NAME="BioChemistryCraft";
	public static final String Version="1.0.0";
	
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event){
		
		BCCRegisterBlock.blockRegisterInit();
		BCCRegisterItem.ItemRegisterInit();
		BCCEntityRegister.EntityRegisterInit();
		
	}

	@EventHandler
	public void load(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
}
