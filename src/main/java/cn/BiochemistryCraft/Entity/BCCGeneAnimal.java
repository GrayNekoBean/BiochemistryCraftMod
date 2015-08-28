package cn.BiochemistryCraft.Entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;
import cn.BiochemistryCraft.Gene.InfectSource;
import cn.BiochemistryCraft.core.sick.SSick;

public class BCCGeneAnimal extends EntityAnimal implements IBiology{

	public BCCGeneAnimal(World p_i1681_1_) {
		super(p_i1681_1_);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		return null;
	}

	@Override
	public boolean canMutate() {
		return false;
	}

	public void SetMutationProbly(float par1) {

	}

	public void setInfectivity(float par1) {
		
	}

	@Override
	public Entity getEntity() {
		return this;
	}

	@Override
	public boolean getInfect(InfectSource source, Entity entity) {
		return false;
	}

	@Override
	public float getContaminateValue() {
		return 0.8f;
	}

	@Override
	public float getMutationProbly() {
		return 0;
	}

	@Override
	public float getInfectivityValue() {
		return 0;
	}

	@Override
	public float getImmuneValue() {
		return 0;
	}

	@Override
	public boolean getSick(SSick sick) {
		return false;
	}

}
