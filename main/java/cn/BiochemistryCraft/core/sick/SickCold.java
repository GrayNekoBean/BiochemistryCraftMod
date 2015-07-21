package cn.BiochemistryCraft.core.sick;

import net.minecraft.potion.Potion;

public class SickCold extends Potion{

	public SickCold() {
		super("cold",3,entity);
		this.RegisterSick(this);
		this.RegAttribute(SharedMonsterAttributes.maxHealth, (UUID.randomUUID()), 15.0d, 0);
	}
	
	public void displayEffect(EntityLivingBase e){
		super.displayEffect(e);
		this.SetAttribute(SharedMonsterAttributes.maxHealth, 15.0d);
	}

}
