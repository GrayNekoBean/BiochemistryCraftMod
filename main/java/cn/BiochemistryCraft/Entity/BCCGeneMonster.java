package cn.BiochemistryCraft.Entity;

import cn.BiochemistryCraft.Gene.InfectSource;
import cn.BiochemistryCraft.core.sick.Sick;
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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
 
public class BCCGeneMonster extends EntityMob implements IBiology{

	private static final boolean mutated_ = false;
	public boolean whether;
	public Entity attacker;
	public double attackDamage=2.0d;
	public double followRange=30.0d;
	public int health=20;
	public double moveSpeed=0.26f;
	public float mutateProbly;
	public float Infectivity;
	public float contaminateValue;
	public float immuneValue;
	public boolean mutated;
	
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
	public void useNormalMobAI(boolean par1){
		if(par1){
		 this.tasks.addTask(0, new EntityAISwimming(this));
	        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
	        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
	        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
	        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	        this.tasks.addTask(8, new EntityAILookIdle(this));
	        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		}
		
		else
		{
			
		}
	}
	
	@Override
	public boolean isAIEnabled(){
		return true;
		
	}
	
	public boolean isMutate(){
		return whether;
		
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
	public void SetMutationProbly(float par1) {
		// TODO �Զ����ɵķ������
		mutateProbly=par1;
		
	}
	public void setInfectivity(float par1) {//设置感染值
		// TODO �Զ����ɵķ������
		Infectivity=par1;
		
	}
	
	public void setContaminateValue(float par1){//设置传染值
		this.contaminateValue=par1;
		
	}
	
	public void setImmuneValue(float par1){//设置免疫值
		this.immuneValue=par1;
	}
	
	
	
	public float getMutationProbly(){
		return mutateProbly;
		
	}
	
	public float getInfectivityValue(){     
		return Infectivity;
	}
	
	public float getContaminateValue(){
		return contaminateValue;
	}
	
	public float getImmuneValue(){
		return this.immuneValue;
	}
	
	public void writeEntityToNBT(NBTTagCompound tag){//读写nbt
		super.writeEntityToNBT(tag);
		tag.setFloat("Infectivity", Infectivity);
		tag.setFloat("contaminateValue", contaminateValue);
		tag.setFloat("immuneValue", immuneValue);
		tag.setBoolean("mutated", mutated_);
		
	}
	
	public void readEntityFromNBT(NBTTagCompound nbttag){
		super.readEntityFromNBT(nbttag);
		this.setImmuneValue(nbttag.getFloat("immuneValue"));
		this.setContaminateValue(nbttag.getFloat("contaminateValue"));
		this.setInfectivity(nbttag.getFloat("Infectivity"));
		
		
		
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
	public boolean getSick(Sick sick) {
		// TODO 自动生成的方法存根
		return false;
	}



}
