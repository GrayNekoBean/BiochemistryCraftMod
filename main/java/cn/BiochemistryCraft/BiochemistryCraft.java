package cn.BiochemistryCraft;

import net.minecraft.creativetab.CreativeTabs;
import cn.BiochemistryCraft.CreativeTab.BCCCreativeTab;
import cn.BiochemistryCraft.GUI.BioGuiHandler;
import cn.BiochemistryCraft.Register.BCCRegisterEvent;
import cn.BiochemistryCraft.core.BCCConfig;
import cn.BiochemistryCraft.core.sick.SickCold;
import cn.BiochemistryCraft.core.sick.SickRegistry;
import cn.BiochemistryCraft.proxy.BCCcommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;



@Mod(modid=BiochemistryCraft.MODID,name=BiochemistryCraft.NAME,version=BiochemistryCraft.Version, guiFactory="cn.BiochemistryCraft.core.BCCGuiFactory")

public class BiochemistryCraft{
	
	@Instance(BiochemistryCraft.MODID)
	public static BiochemistryCraft instance;
	
	@SidedProxy(clientSide="cn.BiochemistryCraft.proxy.BCCclientProxy",serverSide="cn.BiochemistryCraft.proxy.BCCcommonProxy")
		public static BCCcommonProxy proxy;
	
	
	public static final String MODID="biomod";
	public static final String NAME="BioChemistryCraft";
	public static final String Version="1.0.0";
	
	
//	public static BCCRegisterBlock blockregister;
//	public static BCCRegisterItem itemregister;
//	public static BCCEntityRegister entityregister;
//	public static BCCEntityRendererRegister entityrendererregister;
	public static BCCRegisterEvent eventRegister = new BCCRegisterEvent();
	//public static IGuiHandler guihandler;
	
	public static final CreativeTabs biocreativetab=new BCCCreativeTab("BiochemistryCraft");
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event){
		//guihandler=(IGuiHandler) new BioGUIHandler();
		BCCConfig.startConfig(event);
//		blockregister=new BCCRegisterBlock();
//		itemregister=new BCCRegisterItem();
//		entityregister=new BCCEntityRegister();
//		entityrendererregister=new BCCEntityRendererRegister();
		
//		blockregister.blockRegisterInit();
//		itemregister.ItemRegisterInit();
//		entityregister.EntityRegisterInit();
		proxy.preInit(event);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new BioGuiHandler());
		
		SickRegistry.registerSick(new SickCold());
	}

	@EventHandler
	public void load(FMLInitializationEvent event){
	    proxy.load(event);
		eventRegister.eventRegisterInit();
//		GameRegistry.registerWorldGenerator(new A(), 1);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.postLoad(event);
	}

	
}
