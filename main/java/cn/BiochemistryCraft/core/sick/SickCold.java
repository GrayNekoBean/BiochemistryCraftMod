package cn.BiochemistryCraft.core.sick;

import java.util.UUID;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;

public class SickCold extends Sick{

	protected SickCold() {
		super("cold",3,entity);
		this.RegisterSick(this);
		this.RegAttribute(SharedMonsterAttributes.maxHealth, (UUID.randomUUID()), 15.0d, 0);
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public void displayEffect(EntityLivingBase e){
		super.displayEffect(e);
		this.SetAttribute(SharedMonsterAttributes.maxHealth, 15.0d);
	}

}
