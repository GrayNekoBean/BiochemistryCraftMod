package cn.BiochemistryCraft.core.sick;

import java.util.ArrayList;
import java.util.List;

import cn.BiochemistryCraft.network.PacketMain;
import cn.BiochemistryCraft.network.packet.PacketSickInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class SickPlayerInfo {
	private static final String NBT_ROOT = "SickPlayerInfo";
	private static final String NBT_SICK = "Sick";
	
	public static List<SSick> read(EntityPlayer player){
		NBTTagCompound persisted = getPersistedFromPlayer(player);
        if (persisted.hasKey(NBT_ROOT)){
        	return read(persisted);
        }
        return null;
    }
	
	public static List<SSick> read(NBTTagCompound tagCompound){
		int[] sick;
		List<SSick> result = new ArrayList();
        NBTTagCompound root = tagCompound.getCompoundTag(NBT_ROOT);
        sick = root.getIntArray(NBT_SICK);
        for(int a: sick){
        	result.add(SickRegistry.getSickFromID(a));
        }
        return result;
    }
	
	public static void write(EntityPlayer player, List<SSick> sick){
        NBTTagCompound persisted = getPersistedFromPlayer(player);
        write(persisted, sick);
    }

    public static void write(NBTTagCompound tagCompound, List<SSick> sick){
    	int[] a = new int[sick.size()];
        if (!tagCompound.hasKey(NBT_ROOT)){
        	tagCompound.setTag(NBT_ROOT, new NBTTagCompound());
        }
        NBTTagCompound root = tagCompound.getCompoundTag(NBT_ROOT);
        for(int i = 0; i < sick.size(); i++){
        	a[i] = SickRegistry.getIDFromSick(sick.get(i));
        }
        root.setIntArray(NBT_SICK, a);
    }
    
    private static NBTTagCompound getPersistedFromPlayer(EntityPlayer player){
    	NBTTagCompound tagCompound = player.getEntityData();
    	if (!tagCompound.hasKey(EntityPlayer.PERSISTED_NBT_TAG)){
			tagCompound.setTag(EntityPlayer.PERSISTED_NBT_TAG, new NBTTagCompound());
        }
		return tagCompound.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
    }
    
    public static void onLogin(EntityPlayer player){
    	PacketMain.sendToPlayer(new PacketSickInfo(read(player)), player);
    	Sick.update(player.worldObj, player);
    }
    
    public static void onLogout(EntityPlayer player, List<SSick> sick){
    	write(player, sick);
    	PacketMain.sendToPlayer(new PacketSickInfo(Sick.getSickListFromPlayer(player)), player);
    }
    
    public static void onUpdate(EntityPlayer player, List<SSick> sick){
    	onLogout(player, sick);
    }
}
