package cn.BiochemistryCraft.Register;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.common.MinecraftForge;
import cn.BiochemistryCraft.core.BCCConfig;
import cn.BiochemistryCraft.event.BCCGeneralEvent;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.event.EventBonemeal;
import cn.BiochemistryCraft.event.EventPlayer;
import cn.BiochemistryCraft.event.FluidBottleHandler;
import cpw.mods.fml.common.FMLCommonHandler;

public class BCCRegisterEvent {
	public static SimpleNetworkWrapper networkHandler;
	
	public void eventRegisterInit(){
		networkHandler = NetworkRegistry.INSTANCE.newSimpleChannel(BiochemistryCraft.MODID);
		
		MinecraftForge.EVENT_BUS.register(new EventBonemeal());
		MinecraftForge.EVENT_BUS.register(new EventPlayer());
		
		FluidBottleHandler.INSTANCE.buckets.put(BCCRegisterBlock.acid2, BCCRegisterItem.bucketAcid);
		MinecraftForge.EVENT_BUS.register(FluidBottleHandler.INSTANCE);
		FMLCommonHandler.instance().bus().register(new BCCConfig());
		MinecraftForge.EVENT_BUS.register(new BCCGeneralEvent());
		FMLCommonHandler.instance().bus().register(new BCCGeneralEvent());
	}
}
