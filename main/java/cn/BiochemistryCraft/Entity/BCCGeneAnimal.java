package cn.BiochemistryCraft.Entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class BCCGeneAnimal extends EntityAnimal implements IBiology{

	public BCCGeneAnimal(World p_i1681_1_) {
		super(p_i1681_1_);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean canMutate() {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public void SetMutationProbly(float par1) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void setInfectivity(float par1) {
		// TODO 自动生成的方法存根
		
	}

}
