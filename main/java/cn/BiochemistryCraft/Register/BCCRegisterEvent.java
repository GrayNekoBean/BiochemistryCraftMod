package cn.BiochemistryCraft.Register;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.event.EventBonemeal;
import cn.BiochemistryCraft.event.EventPlayer;
import cn.BiochemistryCraft.event.FluidBottleHandler;
import cn.BiochemistryCraft.network.PacketMain;
import cn.BiochemistryCraft.network.packet.PacketSickInfo;
import cn.BiochemistryCraft.world.gen.OreGenerator;

public class BCCRegisterEvent {
	public static SimpleNetworkWrapper networkHandler;
	
	public void eventRegisterPreLoad(){
		GameRegistry.registerWorldGenerator(new OreGenerator(), 0);
	}
	
	public void eventRegisterInit(){
		networkHandler = NetworkRegistry.INSTANCE.newSimpleChannel(BiochemistryCraft.MODID);
		PacketMain.registerPacket(PacketSickInfo.class);
		
		MinecraftForge.EVENT_BUS.register(new EventBonemeal());
		FMLCommonHandler.instance().bus().register(new EventPlayer());
		
		FluidBottleHandler.INSTANCE.buckets.put(BCCRegisterBlock.acid2, BCCRegisterItem.bucketAcid);
		MinecraftForge.EVENT_BUS.register(FluidBottleHandler.INSTANCE);
	}
}
