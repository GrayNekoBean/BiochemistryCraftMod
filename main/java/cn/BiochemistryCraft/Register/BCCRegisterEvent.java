package cn.BiochemistryCraft.Register;

import net.minecraftforge.common.MinecraftForge;
import cn.BiochemistryCraft.event.EventBonemeal;
import cn.BiochemistryCraft.event.FluidBottleHandler;

public class BCCRegisterEvent {
	public void eventRegisterInit(){
		MinecraftForge.EVENT_BUS.register(new EventBonemeal());
		
		FluidBottleHandler.INSTANCE.buckets.put(BCCRegisterBlock.acid2, BCCRegisterItem.bucketAcid);
		MinecraftForge.EVENT_BUS.register(FluidBottleHandler.INSTANCE);
	}
}
