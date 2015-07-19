package cn.BiochemistryCraft.Gene;

import cn.BiochemistryCraft.Entity.IBiology;
import net.minecraft.entity.EntityLiving;

public class Infect {
public void InfectEntity(IBiology ibiology,InfectSource source){
	
	ibiology.getInfect(source,ibiology.getEntity());
	
}

public void doEffect(InfectSource source,EntityLiving e){
	
	
		
			if(e instanceof IBiology){	
				if(source==source.Xvirus){
				if(e.worldObj.rand.nextInt(10)==(1|2|3)){
				((IBiology) e).getSick(null);
				
			}
				else if(e.worldObj.rand.nextInt(10)==(4|5)){
					
				}
				else if(e.worldObj.rand.nextInt(10)==(6|7|8)){
					
				}
				else if(e.worldObj.rand.nextInt(10)==9){
					
				}
				else if(e.worldObj.rand.nextInt(10)==0){
					
				}
		}
				else if(source==source.furorVirus){
					
				}
				
				else if(source==source.parasiticer){
					
				}
	}
			else if(!(e instanceof IBiology)){
				
			}
}
}
