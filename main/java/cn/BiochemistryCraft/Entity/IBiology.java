package cn.BiochemistryCraft.Entity;

import cn.BiochemistryCraft.Gene.InfectSource;
import net.minecraft.entity.Entity;
import cn.BiochemistryCraft.core.sick.*;

public interface IBiology {
	public Entity getEntity() ;
	
	public boolean isSick();
	
	@Deprecated
	public boolean getSick(Sick sick);
	
	public void beSick(IIllness illness);
	
	public IIllness getDisease();
	
	public float getImmuneValue();
	 
	public boolean canMutate();
	
	public float getMutationProbly();
	
	public float getInfectivityValue();
	
	public float getContaminateValue();
	
	public boolean getInfect(InfectSource source,Entity entity);

}
