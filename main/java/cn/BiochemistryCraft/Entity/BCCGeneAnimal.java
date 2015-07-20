package cn.BiochemistryCraft.Entity;

import cn.BiochemistryCraft.Gene.InfectSource;
import cn.BiochemistryCraft.core.sick.IIllness;
import cn.BiochemistryCraft.core.sick.Sick;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class BCCGeneAnimal extends EntityAnimal implements IBiology{
    	private IIllness disease;
	public BCCGeneAnimal(World p_i1681_1_) {
		super(p_i1681_1_);
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public boolean canMutate() {
		// TODO �Զ����ɵķ������
		return false;
	}

	public void SetMutationProbly(float par1) {
		// TODO �Զ����ɵķ������
		
	}

	public void setInfectivity(float par1) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public Entity getEntity() {
		// TODO 自动生成的方法存根
		return this;
	}

	@Override
	public boolean getInfect(InfectSource source, Entity entity) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public float getContaminateValue() {
		// TODO 自动生成的方法存根
		return 0.8f;
	}

	@Override
	public float getMutationProbly() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public float getInfectivityValue() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public float getImmuneValue() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public boolean getSick(Sick sick) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean isSick() {
	    // TODO Auto-generated method stub
	    return this.disease != null;
	}

	@Override
	public void beSick(IIllness illness) {
	    this.disease = illness;
	    
	}

	@Override
	public IIllness getDisease() {
	    // TODO Auto-generated method stub
	    return this.disease;
	}

}
