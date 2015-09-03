package cn.BiochemistryCraft.core.sick;

import java.util.Timer;

import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import cn.BiochemistryCraft.core.BCCLogger;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.common.BiomeDictionary;

public class SickTrigger {
	public static SSick trigger(TriggerType type, Object data, EntityLivingBase entity){
		switch(type){
			case COLLIDE_BLOCK:
				return tryCollibeBlock(data, entity);
			case REACH_POSISION:
				return tryPos(data, entity);
			case INTERACT_ENTITY:
				return tryTouchMob(data, entity);
			default:
				return null;
		}
	}
	private static SSick tryCollibeBlock(Object data, EntityLivingBase entity){
		if(data instanceof Block){
			Block block = (Block)data;
			SSick s;
			Timer t = new Timer();
			int i = entity.worldObj.rand.nextInt(25);
			if(block == BCCRegisterBlock.acid && i == 0){
				s = new SickCold(entity, t);
				return s;
			}
		}
		return null;
	}
	private static SSick tryPos(Object data, EntityLivingBase entity){
		if(data instanceof int[]){
			int[] pos = (int[])data;
			SSick s;
			Timer t = new Timer();
			int i = entity.worldObj.rand.nextInt(25);
			if(pos[1] >= 200 && i == 0){
				s = new SickCold(entity, t);
				return s;
			}
			if(BiomeDictionary.isBiomeOfType(entity.worldObj.getBiomeGenForCoords(pos[0], pos[2]),BiomeDictionary.Type.COLD)){
				if(i == 0){
					s = new SickCold(entity, t);
					return s;
				}
			}
			if(BiomeDictionary.isBiomeOfType(entity.worldObj.getBiomeGenForCoords(pos[0], pos[2]),BiomeDictionary.Type.HOT)){
				if(i == 0){
					s = new SickHeatIllness.HeatExhaustion(entity, t);
					return s;
				}
			}
		}
		return null;
	}
	private static SSick tryTouchMob(Object data, EntityLivingBase entity){
		return null;
	}
}
