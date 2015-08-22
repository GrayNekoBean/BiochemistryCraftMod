package cn.BiochemistryCraft.core.sick;

import java.util.UUID;

import cn.BiochemistryCraft.BCCDamageSource;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;

public class SickCold extends SSick{

	public SickCold() 
	{
	}

	@Override
	public void displayEffect() {
		// TODO 自动生成的方法存根
		if(this.entity!=null)
		{
			entity.attackEntityFrom(BCCDamageSource.acid, 1F);
		}
	}

}
