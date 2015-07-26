package cn.BiochemistryCraft.core.sick;

import java.util.UUID;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;

public class SickCold extends Sick{

	protected SickCold(EntityLivingBase SickEntity) {
		super(null, 1, SickEntity);
	}
	
	public SickCold(String name, int power, EntityLivingBase patient){
		super(name, power, patient);
	}

	@Override
	public void displayEffect(EntityLivingBase entity2) {
		// TODO 自动生成的方法存根
		
	}

}
