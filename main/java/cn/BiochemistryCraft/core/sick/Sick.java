package cn.BiochemistryCraft.core.sick;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import cn.BiochemistryCraft.core.BCCLogger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.world.World;
/**
 * Sick.java is useless certainly
 * Sick.java 现在没有用
 * @deprecated
 */
@Deprecated
public class Sick {
	private static List<EntityPlayer> playerList = new ArrayList<EntityPlayer>();
	private static List<List<SSick>> playerSickList = new ArrayList<List<SSick>>();
	//public static List<Sick> sickList=new ArrayList();
			
	public static void addPlayer(EntityPlayer player){
		playerList.add(player);
		playerSickList.add(null);
	}
	
	public List<?> getPlayerList() throws InstantiationException, IllegalAccessException{
		try {
			Field fild= ServerConfigurationManager.class.getDeclaredField("PlayerEntityList");
			fild.setAccessible(true);
			BCCLogger.debug("sick!");
			return ServerConfigurationManager.class.newInstance().playerEntityList;
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void addPlayer(EntityPlayer player, SSick[] sick){
		List<SSick> input = new ArrayList<SSick>();
		for(SSick a: sick){
			input.add(a);
		}
		playerList.add(player);
		playerSickList.add(input);
	}
	
	public static void addPlayer(EntityPlayer player, List<SSick> sick) {
		playerList.add(player);
		playerSickList.add(sick);
	}
	
	public static void removePlayer(EntityPlayer player){
		int a = find(player);
		playerList.remove(a);
		playerSickList.remove(a);
	}
	
	public static void addSick(EntityPlayer player, SSick add){
		List<SSick> input = new ArrayList<SSick>();
		int a = find(player);
		if(a != -1){
			input = playerSickList.get(a);
			input.add(add);
			playerSickList.add(a, input);
			update(player.worldObj, player);
		}
		
	}
	
	public static void removeSick(EntityPlayer player, SSick remove){
		int a = find(player);
		List<SSick> result = new ArrayList<SSick>();
		if(a == -1){
			return;
		}else{
			result = playerSickList.get(a);
			result.remove(remove);
			playerSickList.add(a, result);
			update(player.worldObj, player);
		}
		
	}
	
	public static int setSick(EntityPlayer player, SSick[] sick){
		int a = find(player);
		List<SSick> input = new ArrayList<SSick>();
		if(a != -1){
			for(SSick b: sick){
				input.add(b);
			}
			playerSickList.add(a, input);
			update(player.worldObj, player);
		}
		return a;
	}
	
	private static void update(World worldObj, EntityPlayer player) {
		// put update
		
	}

	public static SSick[] getSickFromPlayer(EntityPlayer player){
		int a = find(player);
		List<SSick> input = new ArrayList<SSick>();
		SSick[] result;
		if(a != -1){
			input = playerSickList.get(a);
			result = new SSick[input.size()];
			for(int i = 0; i < input.size(); i++){
				result[i] = input.get(i);
			}
			return result;
		}else{
			return null;
		}
	}
	
	public static List<SSick> getSickListFromPlayer(EntityPlayer player){
		int a = find(player);
		if(a != -1){
			return playerSickList.get(a);
		}else{
			return null;
		}
	}
	
	public static boolean playerHasSick(EntityPlayer player, SSick sick){
		int a = playerSickList.get(find(player)).indexOf(sick);
		if(a >= 0){
			return true;
		}else{
			return false;
		}
	}
	
	private static int find(EntityPlayer player){
		return playerList.indexOf(player);
	}
}
