package cn.BiochemistryCraft.core.sick;

import java.util.Timer;

import cn.BiochemistryCraft.Register.BCCRegisterItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
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
//				this.curetiveList.add(new ItemStack(BCCRegisterItem.goldenVineFruit));
//				this.addEffectToEntity(new PotionBio(Potion.hunger), 1, curetiveList);
//				this.addEffectToEntity(new PotionBio(Potion.moveSlowdown), 1, curetiveList);
				this.affectEntityAttribute(SharedMonsterAttributes.movementSpeed, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15000000596046448D, 2);
//				this.addEffectToEntity(new PotionBio(Potion.confusion), 1, curetiveList);
//				this.addEffectToEntity(new PotionBio(Potion.digSlowdown), 1, curetiveList);
//				this.addEffectToEntity(new PotionBio(Potion.weakness), 1, curetiveList);
				this.affectEntityAttribute(SharedMonsterAttributes.attackDamage, "22653B89-116E-49DC-9B6B-9971489B5BE5", 2.0D, 0);
//				this.addEffectToEntity((PotionBio) Potion.hunger, 1, curetiveList);
			}
		}
		
	}
}
