package cn.BiochemistryCraft.core.sick;

import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import cn.BiochemistryCraft.Entity.IBiology;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Sick {

	private static List<EntityPlayer> playerList = new ArrayList();
	private static List<List<SSick>> playerSickList = new ArrayList();
	
	public static void addPlayer(EntityPlayer player){
		playerList.add(player);
		playerSickList.add(null);
	}
	
	public static void addPlayer(EntityPlayer player, SSick[] sick){
		List<SSick> input = new ArrayList();
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
		List<SSick> input = new ArrayList();
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
	
	public static int setSick(EntityPlayer player, SSick[] sick){
		int a = find(player);
		List<SSick> input = new ArrayList();
		if(a != -1){
			for(SSick b: sick){
				input.add(b);
			}
			playerSickList.add(a, input);
			update(player.worldObj, player);
		}
		return a;
	}
	
	public static SSick[] getSickFromPlayer(EntityPlayer player){
		int a = find(player);
		List<SSick> input = new ArrayList();
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
	
	public static void update(World world, EntityPlayer player){
		//put update
		SickPlayerInfo.onUpdate(player, playerSickList.get(find(player)));
	}
}
