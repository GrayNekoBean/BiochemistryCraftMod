package cn.BiochemistryCraft.Register;

import net.minecraftforge.common.MinecraftForge;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.core.BCCConfig;
import cn.BiochemistryCraft.event.BCCGeneralEvent;
import cn.BiochemistryCraft.event.EventBonemeal;
import cn.BiochemistryCraft.event.EventPlayer;
import cn.BiochemistryCraft.event.FluidBottleHandler;
import cn.BiochemistryCraft.network.PacketMain;
import cn.BiochemistryCraft.network.packet.PacketSickInfo;
import cn.BiochemistryCraft.world.gen.OreGenerator;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;

public class BCCRegisterEvent {
	public static SimpleNetworkWrapper networkHandler;
	public static EventPlayer eplayer = new EventPlayer();
	
	public void eventRegisterPreLoad(){
		GameRegistry.registerWorldGenerator(new OreGenerator(), 0);
		MinecraftForge.EVENT_BUS.register(eplayer);
	}
	
	public void eventRegisterInit(){
		networkHandler = NetworkRegistry.INSTANCE.newSimpleChannel(BiochemistryCraft.MODID);
		PacketMain.registerPacket(PacketSickInfo.class);
		
		MinecraftForge.EVENT_BUS.register(new EventBonemeal());
		FMLCommonHandler.instance().bus().register(eplayer);
		
		FluidBottleHandler.INSTANCE.buckets.put(BCCRegisterBlock.acid2, BCCRegisterItem.bucketAcid);
		MinecraftForge.EVENT_BUS.register(FluidBottleHandler.INSTANCE);
		FMLCommonHandler.instance().bus().register(new BCCConfig());
		MinecraftForge.EVENT_BUS.register(new BCCGeneralEvent());
		FMLCommonHandler.instance().bus().register(new BCCGeneralEvent());
	}
}
