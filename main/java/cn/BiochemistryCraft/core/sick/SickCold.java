package cn.BiochemistryCraft.core.sick;

import cn.BiochemistryCraft.BCCDamageSource;

public class SickCold extends SSick{

	public SickCold() 
	{
	}

	@Override
	public void displayEffect() {
		if(this.entity!=null)
		{
			entity.attackEntityFrom(BCCDamageSource.acid, 1F);
		}
	}

}
