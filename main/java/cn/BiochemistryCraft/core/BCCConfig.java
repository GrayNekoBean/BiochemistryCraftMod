package cn.BiochemistryCraft.core;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cn.BiochemistryCraft.BiochemistryCraft;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BCCConfig {
    private static boolean useNewStyleGui = false;
	public static Configuration config;
	
	public static void startConfig(FMLPreInitializationEvent event) {
		setConfigLocation(event.getSuggestedConfigurationFile());
		init();
	}
	public static void setConfigLocation(File configFile) {
		if (config == null)
			config = new Configuration(configFile);
	}
	public static void init() {
		config.load();
		try {
			useNewStyleGui = config.getBoolean("enable new style gui", Reference.CATEGORY_GLOBEL, false, "enable new style gui");
		}
		catch (Exception e) {} 
		finally {
			if (config.hasChanged()) {
				config.save();
				System.out.println("Config saved");
			}
		}
	}

	@SubscribeEvent
	public void onConfigChanged(
			ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (eventArgs.modID.equalsIgnoreCase(BiochemistryCraft.MODID)) {
			config.save();
			init();
		}
	}
	public boolean isUseNewStyleGui() {
	    return useNewStyleGui;
	}
	public static  String getGuiPath(){
	    return useNewStyleGui ? "textures/gui/ns/" : "textures/gui/";
	}
	protected class Reference {
	    public static final String CATEGORY_GLOBEL = "globelsettings";
	}
}
