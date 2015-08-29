package cn.BiochemistryCraft.core.sick;

import java.util.Timer;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import cn.BiochemistryCraft.BCCDamageSource;
import cn.BiochemistryCraft.Register.BCCRegisterItem;

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
			this.curetiveList.add(new ItemStack(BCCRegisterItem.goldenVineFruit));
			this.addEffectToPlayer((PotionBio) Potion.hunger, 1, curetiveList);
		}
	}
	@Override
	public InfectType setInfectType(InfectType type) {
		return null;
	}
}
