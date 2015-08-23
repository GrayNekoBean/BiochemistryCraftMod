package cn.BiochemistryCraft.Entity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class BCCEntityMob extends EntityMob{

	public boolean gotAHit=false;
	Block bl;
	float fl;
	public boolean isMutate=false;
	
	public BCCEntityMob(World p_i1738_1_) {
		super(p_i1738_1_);
	}
	
	@Override
	public void entityInit(){
		super.entityInit();
		this.dataWatcher.addObject(30, Byte.valueOf((byte) 0));
		
	}
	
	public boolean isActiveAttack(){
		return gotAHit;
		
	}

	@Override
	public boolean attackEntityFrom(DamageSource damage,float f){
		super.attackEntityFrom(damage, f);
		if(isActiveAttack()==true){}
		else if(damage.getEntity() instanceof EntityLivingBase){
	this.gotAHit=true;
		}
		return super.attackEntityFrom(damage,f);
	}
	
	@SuppressWarnings("unused")
	public void InterestedInBlock(Block b,float f){
		Block block=bl;
		float f1=fl;
	}
	
	@Override
	public float getBlockPathWeight(int x,int y,int z){
		if(this.worldObj.getBlock(x, y, z) == bl){
			return fl;
		}
		return super.getBlockPathWeight(x, y, z);
		
	}
	
	@SuppressWarnings({ "rawtypes" , "unchecked" })
	public List<Entity> foundEntityInDistance(double distance,Entity target){
		
		 List entityList = this.worldObj.getLoadedEntityList();
		 List targetList = new ArrayList();
		 
		 for(int i=0;i<entityList.size();i++){
			 if((Entity)entityList.get(i) == target){
				 if(this.getDistanceToEntity(target)<=distance){
				 targetList.add((Entity)entityList.get(i));
				 return targetList;
			 }
			 }
		 }
		
		return null;
	}
	
	public boolean mutate(byte type){
		
		this.dataWatcher.updateObject(30,Byte.valueOf(type));
		this.onMutate();
		this.isMutate=true;
		return true;
		
	}
	
	public abstract void onMutate();
	
}
