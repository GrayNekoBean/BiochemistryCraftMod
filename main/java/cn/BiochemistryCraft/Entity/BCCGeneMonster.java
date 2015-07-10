package cn.BiochemistryCraft.Entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
 
public class BCCGeneMonster extends EntityMob implements IBiology{

	public boolean whether;
	public Entity attacker;
	public double attackDamage=2.0d;
	public double followRange=30.0d;
	public int health=20;
	public double moveSpeed=0.26f;
	public float mutateProbly;
	public float Infectivity;
	
	
	public BCCGeneMonster(World p_i1738_1_) {
		super(p_i1738_1_);
		
		
		// TODO �Զ����ɵĹ��캯�����
	}
	//�����Ƿ����������
	public boolean isActiveAttack(boolean yes){
		return this.whether = yes;
		
	}
	@Override
	public boolean attackEntityFrom(DamageSource damage,float f){
		
		this.attacker=damage.getEntity();
		return hasAttacked;
		
	}
	@Override
	 protected Entity findPlayerToAttack()
	    {
		
	        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
	        
	        return entityplayer != null && this.canEntityBeSeen(entityplayer)&& isActiveAttack(true) ? entityplayer :
	        	
	        	attacker!=null&&this.canEntityBeSeen(attacker)&&isActiveAttack(false)?attacker:null;
	    }
	
	@Override
	public void applyEntityAttributes(){
		super.applyEntityAttributes();
		
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(this.attackDamage);
		
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(this.followRange);
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.health);
		
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(moveSpeed);
		
	}
	
	//��ݷ�����ʹ��һ�����AI
	public void useNormalMobAI(){
		 this.tasks.addTask(0, new EntityAISwimming(this));
	        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
	        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
	        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
	        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	        this.tasks.addTask(8, new EntityAILookIdle(this));
	        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	      
	}
	

	
	public void setHealth(int healthy){
		this.health=healthy;
	}
	
	public void setFollow(double follow){
		this.followRange=follow;
	}
	
	public void setAttack(double damage){
		this.attackDamage=damage;
		
	}
	
	public void setSpeed(double speed){
		this.moveSpeed=speed;
	}
	@Override
	public boolean canMutate() {
		// TODO �Զ����ɵķ������
		return true;
	}
	@Override
	public void SetMutationProbly(float par1) {
		// TODO �Զ����ɵķ������
		mutateProbly=par1;
		
	}
	@Override
	public void setInfectivity(float par1) {
		// TODO �Զ����ɵķ������
		Infectivity=par1;
		
	}
	
	public float getMutationProbly(){
		return mutateProbly;
		
	}
	
public float getInfectivity(){
	return Infectivity;
}
}
