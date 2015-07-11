package cn.BiochemistryCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cn.BiochemistryCraft.CreativeTab.BCCCreativeTab;
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

public class BiochemistryCraft implements IGuiHandler{
	
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
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, this);
	}

	@EventHandler
	public void load(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO 自动生成的方法存根
		 switch(ID){
		 case 2027:
			return new ContainerBioExtracter(player.inventory, (TileentityBioExtracter)player.worldObj.getTileEntity(x, y, z));
		 }
		 return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch(ID){
		 case 2027:
			return new GUIBioExtracter(player.inventory, (TileentityBioExtracter)player.worldObj.getTileEntity(x, y, z));
		 }
		// TODO 自动生成的方法存根
		return null;
	}
}
