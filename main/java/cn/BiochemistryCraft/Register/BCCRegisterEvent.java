package cn.BiochemistryCraft.Register;

import net.minecraftforge.common.MinecraftForge;
import cn.BiochemistryCraft.core.BCCConfig;
import cn.BiochemistryCraft.event.EventBonemeal;
import cn.BiochemistryCraft.event.FluidBottleHandler;
import cpw.mods.fml.common.FMLCommonHandler;

public class BCCRegisterEvent {
	public void eventRegisterInit(){
		MinecraftForge.EVENT_BUS.register(new EventBonemeal());
		
		FluidBottleHandler.INSTANCE.buckets.put(BCCRegisterBlock.acid2, BCCRegisterItem.bucketAcid);
		MinecraftForge.EVENT_BUS.register(FluidBottleHandler.INSTANCE);
		FMLCommonHandler.instance().bus().register(new BCCConfig());
	}
}
