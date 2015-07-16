package cn.BiochemistryCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cn.BiochemistryCraft.CreativeTab.BCCCreativeTab;
import cn.BiochemistryCraft.GUI.BioGuiHandler;
import cn.BiochemistryCraft.GUI.ContainerBioExtracter;
import cn.BiochemistryCraft.GUI.GUIBioExtracter;
import cn.BiochemistryCraft.Register.BCCEntityRegister;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import cn.BiochemistryCraft.Register.BCCRegisterItem;
import cn.BiochemistryCraft.TileEntity.TileentityBioExtracter;
import cn.BiochemistryCraft.proxy.BCCcommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;



@Mod(modid=BiochemistryCraft.MODID,name=BiochemistryCraft.NAME,version=BiochemistryCraft.Version)

public class BiochemistryCraft{
	
	@Instance(BiochemistryCraft.MODID)
	public static BiochemistryCraft instance;
	
	@SidedProxy(clientSide="cn.BiochemistryCraft.proxy.BCCclientProxy",serverSide="cn.BiochemistryCraft.proxy.BCCcommonProxy")
		public static BCCcommonProxy proxy;
	
	
	public static final String MODID="biomod";
	public static final String NAME="BioChemistryCraft";
	public static final String Version="1.0.0";
	
	
	public static BCCRegisterBlock blockregister;
	public static BCCRegisterItem itemregister;
	public static BCCEntityRegister entityregister;
	//public static IGuiHandler guihandler;
	
	public static final CreativeTabs biocreativetab=new BCCCreativeTab("BiochemistryCraft");
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event){
		//guihandler=(IGuiHandler) new BioGUIHandler();
		
		blockregister=new BCCRegisterBlock();
		itemregister=new BCCRegisterItem();
		entityregister=new BCCEntityRegister();
		
		blockregister.blockRegisterInit();
		itemregister.ItemRegisterInit();
		entityregister.EntityRegisterInit();
		entityregister.EntityRenderRegisterInit();
		
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new BioGuiHandler());
	}

	@EventHandler
	public void load(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}

	
}
