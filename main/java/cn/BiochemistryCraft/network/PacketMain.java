package cn.BiochemistryCraft.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import cn.BiochemistryCraft.Register.BCCRegisterEvent;
import cn.BiochemistryCraft.core.BCCLogger;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketMain {
	private static final SimpleNetworkWrapper networkHandler = BCCRegisterEvent.networkHandler;
	private static int id = 0;
	
	public static void sendToServer(AbstractPacket packet){
        networkHandler.sendToServer(packet);
    }

    public static void sendToPlayer(AbstractPacket packet, EntityPlayer player){
        networkHandler.sendTo(packet, (EntityPlayerMP)player);
    }

    public static void sendToPlayer(AbstractPacket packet, EntityPlayerMP player){
        networkHandler.sendTo(packet, player);
    }

    public static void sendToAllInDimension(AbstractPacket packet, int dimId){
        networkHandler.sendToDimension(packet, dimId);
    }

    public static void sendToAllAround(AbstractPacket packet, double X, double Y, double Z, int range, int dimensionId){
        NetworkRegistry.TargetPoint targetPoint = new NetworkRegistry.TargetPoint(dimensionId, X, Y, Z, range);
        networkHandler.sendToAllAround(packet, targetPoint);
    }
    
    public static void sendPacketToAllPlayers(AbstractPacket packet){
        networkHandler.sendToAll(packet);
    }
    
    public static void registerPacket(Class<? extends AbstractPacket> packetClass){
        Class<AbstractPacket> message = (Class<AbstractPacket>)packetClass;
        if (ICallServer.class.isAssignableFrom(packetClass)){
            networkHandler.registerMessage(packetClass, message, id, Side.SERVER);
            BCCLogger.info("Registered Packet: %s at ID %d", packetClass.getName(), id);
            id++;
        }

        if (ICallClient.class.isAssignableFrom(packetClass)){
            networkHandler.registerMessage(packetClass, message, id, Side.CLIENT);
            BCCLogger.info("Registered Packet: %s at ID %d", packetClass.getName(), id);
            id++;
        }
    }
}
