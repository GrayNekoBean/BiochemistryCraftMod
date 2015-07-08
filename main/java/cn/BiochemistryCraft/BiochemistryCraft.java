package cn.BiochemistryCraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;



@Mod(modid=BiochemistryCraft.MODID,name=BiochemistryCraft.NAME,version=BiochemistryCraft.Version)

public class BiochemistryCraft {
	@SidedProxy(clientSide="cn.BiochemistryCraft.proxy.BCCclientProxy",
			serverSide="cn.BiochemistryCraft.proxy.BCCcommonProxy")
	
	
	public static final String MODID="biomod";
	public static final String NAME="BioChemistryCraft";
	public static final String Version="1.0.0";
	@Instance(BiochemistryCraft.NAME)
	public static BiochemistryCraft instance;
	
	
	
	@EventHandler
	public void preLoad(){
		
		
	}

	@EventHandler
	public void load(){
		
	}
	
	@EventHandler
	public void postInit(){
		
	}
	
}
