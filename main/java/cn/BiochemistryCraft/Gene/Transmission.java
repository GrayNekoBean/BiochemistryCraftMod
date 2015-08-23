package cn.BiochemistryCraft.Gene;

import java.util.List;

import net.minecraft.util.AxisAlignedBB;
import cn.BiochemistryCraft.Entity.BCCGeneAnimal;
import cn.BiochemistryCraft.Entity.BCCGeneMonster;
import cn.BiochemistryCraft.Entity.IBiology;

public class Transmission {

	public BCCGeneMonster mob;
	public BCCGeneAnimal animal;
	public InfectSource infect;
	public IBiology ibiology;
	
	public Transmission(){
		
		
	}
	
	
	
	public boolean mobTansmission(InfectSource source){
		double x=mob.posX;
		double y=mob.posY;
		double z=mob.posZ;
		float distance=ibiology.getContaminateValue()/2.0f;
	    AxisAlignedBB aabb=AxisAlignedBB.getBoundingBox(x-(double)distance, y-(double)distance/2, z-(double)distance, x+(double)distance, y+(double)distance/2, z+(double)distance);
		List mobs=mob.worldObj.getEntitiesWithinAABB(mob.getClass(), aabb);
		 for(int i=0;i<mobs.size();i++){
			 if(ibiology.getContaminateValue()/mob.getDistanceToEntity(mob)>ibiology.getImmuneValue()){
				 if(mob.worldObj.rand.nextFloat()*ibiology.getImmuneValue()*10>ibiology.getImmuneValue()*9.5f){
					
					 ibiology.getInfect(source,mob);
					 return true;
				 }
				 
			 }
			 
		 }
		 return false;
	}
	
	public boolean animalTransmission(InfectSource source){
		double x=animal.posX;
		double y=animal.posY;
		double z=animal.posZ;
		float distance=ibiology.getContaminateValue()/2.0f;
	    AxisAlignedBB aabb=AxisAlignedBB.getBoundingBox(x-(double)distance, y-(double)distance/2, z-(double)distance, x+(double)distance, y+(double)distance/2, z+(double)distance);
		List mobs=mob.worldObj.getEntitiesWithinAABB(animal.getClass(), aabb);
		 for(int i=0;i<mobs.size();i++){
			 if(ibiology.getContaminateValue()/animal.getDistanceToEntity(animal)>ibiology.getImmuneValue()){
				 if(mob.worldObj.rand.nextFloat()*ibiology.getImmuneValue()*10>ibiology.getImmuneValue()*9){
					
					 ibiology.getInfect(source,mob);
					 return true;
				 }
				 
			 }
			 
		 }
		 return false;
		
	}
	
}
