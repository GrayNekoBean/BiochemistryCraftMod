package cn.BiochemistryCraft.Enity.EntityAI;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

public class BCCAIbase extends EntityAIBase{

	public EntityLiving entity;
	public EntityPlayer player;
	public double dist=16.0D;
	public int posX;
	public int posY;
	public int posZ;
	
	
			@Override
	public boolean shouldExecute() {
		// TODO 自动生成的方法存根
		return false;
		
	}
	
	public boolean IstargetableEntity_withPlayer(){
		
		return this.entity.isEntityAlive()&&this.entity.getDistanceSqToEntity(this.player)<(double)this.dist;
		
	}
	
	public boolean foundBlock(EntityLiving living,Block targetBlock,double speed,double dis,int posx,int posy,int posz){
		
		posX=posx;
		posY=posy;
		posZ=posz;
		
		
		for(int i=1;i<dis;i++){
			
			for(int j=1;j<dis;j++){
				
				for(int k = 1;k<dis;k++){
					
					posx=MathHelper.floor_double(i);
					posy=MathHelper.floor_double(j);
					posz=MathHelper.floor_double(k);
					
					Block TargetBlock=new BlockStone();
					Block block=living.worldObj.getBlock(posx, posy, posz);
					
					if(block == TargetBlock){
						if(living.getDistance(posx,posy,posz)<dis){
							return true;
						}
						
						
					}
					}
			}
			
			
		}
		return false;
	}
	
	public boolean findingBlock(EntityLiving living,double speed){
		
		
		 speed=1.0D;
		
		living.getNavigator().tryMoveToXYZ(posX, posY, posZ, speed);
		
		if(this.entity.isCollidedHorizontally){
			
			if(this.entity.getDistance(posX, posY, posZ)<=0.5d){
				
				return true;
				
			}
		}
		return false;
		
	}
}


