package cn.BiochemistryCraft.core.sick;

import java.util.Timer;
import java.util.UUID;

import cn.BiochemistryCraft.BCCDamageSource;
import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;

public class SickCold extends SSick{
	
	public SickCold(EntityLivingBase entity, Timer timer) {
		super(entity, timer, 2000);
		// TODO 自动生成的构造函数存根
	}
	
	public SickCold() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void displayEffect() {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		if(this.entity!=null)
		{
			entity.attackEntityFrom(BCCDamageSource.acid, 1F);
		}
	}

}
