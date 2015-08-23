package cn.BiochemistryCraft.Gene;

import cn.BiochemistryCraft.Entity.IBiology;
import net.minecraft.entity.EntityLiving;

public class Infect {
    public void InfectEntity(IBiology ibiology,InfectSource source){
	
	ibiology.getInfect(source,ibiology.getEntity());
	
    }

    public void doEffect(InfectSource source,EntityLiving e){
	if(e instanceof IBiology){	
	    if(source == InfectSource.Xvirus){
	    	switch (e.worldObj.rand.nextInt(10)) {
	    	case 0:
	    		break;
	    	case 1:case 2:case 3:
	    		((IBiology) e).getSick(null);
	    		break;
	    	case 4:case 5:
	    		break;
	    	case 6:case 7: case 8:
	    		break;
	    	case 9:
	    		break;
	    	default:
	    		break;
		}
	    }
	    else if(source == InfectSource.furorVirus){
					
	    }
				
	    else if(source == InfectSource.parasiticer){
					
	    }
	}
	else if(!(e instanceof IBiology)){
				
	}
}
}
