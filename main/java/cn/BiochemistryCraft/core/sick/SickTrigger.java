package cn.BiochemistryCraft.core.sick;

import java.util.Timer;

import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;

public class SickTrigger {
	public static SSick triggerFromBlock(TriggerType type, Object data, EntityLivingBase entity){
		switch(type){
			case COLLIDE_BLOCK:
				if(data instanceof Block){
					Block block = (Block)data;
					SSick s;
					Timer t = new Timer();
					if(block == BCCRegisterBlock.acid && entity.worldObj.rand.nextInt(25) == 0){
						s = new SickCold(entity, t);
						return s;
					}
				}
				break;
			case REACH_POSISION:
				if(data instanceof int[]){
					int[] posision = (int[])data;
					SSick s;
					Timer t = new Timer();
					if(posision[1] >= 200 && entity.worldObj.rand.nextInt(25) == 0){
						s = new SickCold(entity, t);
						return s;
					}
				}
				break;
		}
		return null;
	}
}
