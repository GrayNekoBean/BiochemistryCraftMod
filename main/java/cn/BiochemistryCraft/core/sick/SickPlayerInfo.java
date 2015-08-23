package cn.BiochemistryCraft.core.sick;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import cn.BiochemistryCraft.network.PacketMain;
import cn.BiochemistryCraft.network.packet.PacketSickInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.world.World;

public class SickPlayerInfo {
	public static final String NBT_ROOT = "SickPlayerInfo";
	public static final String NBT_SICK = "Sick";
	public static final String NBT_IMMUNE = "ImmuneValue";
	public static final String NBT_INFECT = "InfectValue";
	public static int immuneValue = 50;
	public static int infectValue = 0;
	private static List<EntityPlayer> playerList = new ArrayList();
	private static List<List<SSick>> playerSickList = new ArrayList();
	
	public static List<SSick> read(EntityPlayer player){
		NBTTagCompound persisted = getPersistedFromPlayer(player);
        if (persisted.hasKey(NBT_ROOT)){
        	return read(persisted);
        }
        return null;
    }
	
	public static List<SSick> read(NBTTagCompound tagCompound){
		List<SSick> result = new ArrayList();
        NBTTagCompound root = tagCompound.getCompoundTag(NBT_ROOT);
        int[] sick = root.getIntArray(NBT_SICK);
        for(int a: sick){
        	result.add(SickRegistry.getSickFromID(a));
        }
        immuneValue = root.getInteger("immuneValue");
        infectValue = root.getInteger("InfectValue");
        return result;
    }
	
	public static void write(EntityPlayer player, List<SSick> a){
        NBTTagCompound persisted = getPersistedFromPlayer(player);
        write(persisted, a);
    }

    public static void write(NBTTagCompound tagCompound, List<SSick> sick){
        if (!tagCompound.hasKey(NBT_ROOT)){
        	tagCompound.setTag(NBT_ROOT, new NBTTagCompound());
        }
        NBTTagCompound root = tagCompound.getCompoundTag(NBT_ROOT);
        int[] a = new int[sick.size()];
        for(int i = 0; i < sick.size(); i++){
        	a[i] = sick.get(i).sickID;
        }
        root.setInteger(NBT_IMMUNE, immuneValue);
        root.setInteger(NBT_INFECT, infectValue);
        root.setIntArray(NBT_SICK, a);
    }
    
    public static List<SSick> getSickListFromArray(int[] array){
		List<SSick> result = new ArrayList();
        for(int a: array){
        	result.add(SickRegistry.getSickFromID(a));
        }
        return result;
    }
    
    public static boolean playerHasSick(EntityPlayer player, SSick sick){
    	List<SSick> a = read(player);
    	for(SSick i: a){
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
	
	public List getPlayerList() throws InstantiationException, IllegalAccessException{
		try {
			Field fild= ServerConfigurationManager.class.getDeclaredField("PlayerEntityList");
			fild.setAccessible(true);
			System.out.println("sick!");
			return ServerConfigurationManager.class.newInstance().playerEntityList;
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void addPlayer(EntityPlayer player, List<SSick> sick) {
		playerList.add(player);
		playerSickList.add(sick);
	}
	
	public static void removePlayer(EntityPlayer player){
		int a = playerList.indexOf(player);
		playerList.remove(a);
		playerSickList.remove(a);
	}
	
	public static void addSick(EntityPlayer player, SSick add){
		List<SSick> input = new ArrayList();
		int a = playerList.indexOf(player);
		if(a != -1){
			input = playerSickList.get(a);
			input.add(add);
			playerSickList.add(a, input);
			update(player.worldObj, player);
		}
	}
	
	public static void removeSick(EntityPlayer player, SSick remove){
		int a = playerList.indexOf(player);
		List<SSick> result = new ArrayList();
		if(a == -1){
			return;
		}else{
			result = playerSickList.get(a);
			result.remove(remove);
			playerSickList.add(a, result);
			update(player.worldObj, player);
		}
		
	}
	
	public static List<SSick> getSickListFromPlayer(EntityPlayer player){
		int a = playerList.indexOf(player);
		if(a != -1){
			return playerSickList.get(a);
		}else{
			return null;
		}
	}
	
	private static void update(World worldObj, EntityPlayer player) {
		// put update
	}
}
