package cn.BiochemistryCraft.Register;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.common.MinecraftForge;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.event.EventBonemeal;
import cn.BiochemistryCraft.event.EventPlayer;
import cn.BiochemistryCraft.event.FluidBottleHandler;

public class BCCRegisterEvent {
	public static SimpleNetworkWrapper networkHandler;
	
	public void eventRegisterInit(){
		networkHandler = NetworkRegistry.INSTANCE.newSimpleChannel(BiochemistryCraft.MODID);
		
		MinecraftForge.EVENT_BUS.register(new EventBonemeal());
		MinecraftForge.EVENT_BUS.register(new EventPlayer());
		
		FluidBottleHandler.INSTANCE.buckets.put(BCCRegisterBlock.acid2, BCCRegisterItem.bucketAcid);
		MinecraftForge.EVENT_BUS.register(FluidBottleHandler.INSTANCE);
	}
}
