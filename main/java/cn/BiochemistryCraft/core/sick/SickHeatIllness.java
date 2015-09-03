package cn.BiochemistryCraft.core.sick;

import java.util.Timer;

import cn.BiochemistryCraft.Register.BCCRegisterItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;

public class SickHeatIllness {
	public static class HeatExhaustion extends SSick{
		public HeatExhaustion(){}
		public HeatExhaustion(EntityLivingBase entity, Timer timer) {
			super(entity, timer, 3000);
		}
		@Override
		public InfectType setInfectType(InfectType type) {
			return null;
		}

		@Override
		public void displayEffect() {
			if(this.entity!=null)
			{
				this.curetiveList.add(new ItemStack(BCCRegisterItem.goldenVineFruit));
				this.addEffectToEntity(new PotionBio(Potion.hunger), 1, curetiveList);
				this.addEffectToEntity(new PotionBio(Potion.moveSlowdown), 1, curetiveList);
				this.addEffectToEntity(new PotionBio(Potion.confusion), 1, curetiveList);
				this.addEffectToEntity(new PotionBio(Potion.digSlowdown), 1, curetiveList);
				this.addEffectToEntity(new PotionBio(Potion.weakness), 1, curetiveList);
//				this.addEffectToEntity((PotionBio) Potion.hunger, 1, curetiveList);
			}
		}
		
	}
}
