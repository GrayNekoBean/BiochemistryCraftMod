package cn.BiochemistryCraft.core.sick;

import java.util.ArrayList;
import java.util.List;

import cn.BiochemistryCraft.network.PacketMain;
import cn.BiochemistryCraft.network.packet.PacketSickInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class SickPlayerInfo {
	public static final String NBT_ROOT = "SickPlayerInfo";
	public static final String NBT_SICK = "Sick";
	
	public static int[] read(EntityPlayer player){
		NBTTagCompound persisted = getPersistedFromPlayer(player);
        if (persisted.hasKey(NBT_ROOT)){
        	return read(persisted);
        }
        return null;
    }
	
	public static int[] read(NBTTagCompound tagCompound){
		List<SSick> result = new ArrayList();
        NBTTagCompound root = tagCompound.getCompoundTag(NBT_ROOT);
        return root.getIntArray(NBT_SICK);
    }
	
	public static void write(EntityPlayer player, int[] sick){
        NBTTagCompound persisted = getPersistedFromPlayer(player);
        write(persisted, sick);
    }

    public static void write(NBTTagCompound tagCompound, int[] sick){
        if (!tagCompound.hasKey(NBT_ROOT)){
        	tagCompound.setTag(NBT_ROOT, new NBTTagCompound());
        }
        NBTTagCompound root = tagCompound.getCompoundTag(NBT_ROOT);
        root.setIntArray(NBT_SICK, sick);
    }
    
    public static List<SSick> getSickListFromArray(int[] array){
		List<SSick> result = new ArrayList();
        for(int a: array){
        	result.add(SickRegistry.getSickFromID(a));
        }
        return result;
    }
    
    public static boolean playerHasSick(EntityPlayer player, int sick){
    	int[] a = read(player);
    	for(int i: a){
        	if(i == sick){
        		return true;
        	}
        }
    	return false;
    }
    
    public static NBTTagCompound getPersistedFromPlayer(EntityPlayer player){
    	NBTTagCompound tagCompound = player.getEntityData();
    	if (!tagCompound.hasKey(EntityPlayer.PERSISTED_NBT_TAG)){
			tagCompound.setTag(EntityPlayer.PERSISTED_NBT_TAG, new NBTTagCompound());
        }
		return tagCompound.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
    }
}
