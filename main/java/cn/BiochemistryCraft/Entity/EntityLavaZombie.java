package cn.BiochemistryCraft.Entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import cn.BiochemistryCraft.Entity.EntityAI.LavaZombieBeNLazyAI;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntityLavaZombie extends BCCEntityMob{

	public float[] size1=new float[]{0.6f,0.8f};
	public float[] size2=new float[]{1.8f,2.0f};
	int sizes=1;
	boolean movement;
	//public byte protecting=this.dataWatcher.getWatchableObjectByte(29);
	
	public EntityLavaZombie(World p_i1738_1_) {
		super(p_i1738_1_);
		this.useNormalMobAI(true);
	        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityZombie.class, 1.0D, true));
	        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLavaZombie.class, 1.0D, false));
		this.targetTasks.removeTask(new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new LavaZombieBeNLazyAI(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new LavaZombieBeNLazyAI(this, EntityZombie.class, 0, false));
		this.targetTasks.addTask(2, new LavaZombieBeNLazyAI(this, EntityLavaZombie.class, 0, true));
		this.setSize(this.size1[sizes],this.size2[sizes]);
		this.isImmuneToFire=true;
	}
	public EntityLavaZombie(World p_i1738_1_,Entity e) {
		super(p_i1738_1_);
		this.useNormalMobAI(true);
	        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityZombie.class, 1.0D, true));
	        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLavaZombie.class, 1.0D, false));
		this.targetTasks.removeTask(new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new LavaZombieBeNLazyAI(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new LavaZombieBeNLazyAI(this, EntityZombie.class, 0, false));
		this.targetTasks.addTask(2, new LavaZombieBeNLazyAI(this, EntityLavaZombie.class, 0, true));
		this.setSize(this.size1[sizes],this.size2[sizes]);
		this.setLocationAndAngles(e.posX, e.posY, e.posZ,e.rotationYaw,e.rotationPitch);
		this.setVelocity(e.motionX, e.motionY, e.motionZ);
		this.isImmuneToFire=true;
		
		
		// TODO 鑷姩鐢熸垚鐨勬瀯閫犲嚱鏁板瓨鏍�
	}
	protected void applyEntityAttributes()
	{
	    super.applyEntityAttributes();
	    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
	    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2300000041723251D);
	    getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
	    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(26.0D);
	}
	@Override
	public boolean isAIEnabled(){
		return true;
		
	}

	@Override
	public void onMutate() {}
	public boolean attackEntityAsMob(Entity p_70652_1_)
	{
	    boolean flag = super.attackEntityAsMob(p_70652_1_);
	    
	    if (flag)
	    {
		int i = this.worldObj.difficultySetting.getDifficultyId();
		
		if (this.getHeldItem() == null && this.rand.nextFloat() < (float)i * 0.3F)
		{
		    p_70652_1_.setFire(2 * i);
		}
	    }
	    
	    return flag;
	}
	public void onLivingUpdate()
	{
	    super.onLivingUpdate();
		if(this.getHealth() <= 12){
//			this.dataWatcher.updateObject(29,Byte.valueOf((byte)0));
		    if(!this.worldObj.isRemote){
		    this.breakShleid();
		    }
		}
		if(isNotLazy()){
		    this.handleWaterMovement();
		}
		else{
		    super.handleLavaMovement();
		}
	}
	protected void skipMeLivingUpdate(){
	    super.onLivingUpdate();
	}
	    public void onKillEntity(EntityLivingBase p_70074_1_)
	    {
	        super.onKillEntity(p_70074_1_);

	        if (p_70074_1_ instanceof EntityZombie || p_70074_1_ instanceof EntityPlayer)
	        {
	            if (this.rand.nextBoolean())
	            {
	                return;
	            }

	            EntityLavaZombie entityzombie = new EntityLavaZombie(this.worldObj);
	            entityzombie.copyLocationAndAnglesFrom(p_70074_1_);
	            this.worldObj.removeEntity(p_70074_1_);
	            entityzombie.onSpawnWithEgg((IEntityLivingData)null);
	            this.worldObj.spawnEntityInWorld(entityzombie);
	            this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1016, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
	        }
	    }
	@Override
	public boolean attackEntityFrom(DamageSource source,float f){
		if(!super.attackEntityFrom(source, f)){
		    return false;
		}
		if(source.getEntity() instanceof EntityPlayer||source.getEntity() instanceof EntityArrow){
			if(this.getHealth() <= 12){
				this.worldObj.spawnParticle("lava", this.posX, this.posY, this.posZ, this.worldObj.rand.nextDouble(), this.worldObj.rand.nextDouble(), this.worldObj.rand.nextDouble());
				if(!this.worldObj.isRemote)
				{
					EntityLavaZombieBroken entity=new EntityLavaZombieBroken(this.worldObj,this);
					this.worldObj.spawnEntityInWorld(entity);
					this.worldObj.removeEntity(this);
					
				}
				return true;
			}
		}
		return true;
	}
	private void breakShleid(){
		EntityLavaZombieBroken entity = new EntityLavaZombieBroken(this.worldObj,this);
		this.worldObj.removeEntity(this);
		this.worldObj.spawnEntityInWorld(entity);
		entity.setHealth(12f);
	}
/*	@SubscribeEvent
	public void onTargetEntity(LivingSetAttackTargetEvent event){
		if(event.entityLiving instanceof EntityLavaZombie&&event.target instanceof EntityPlayer){
			this.movement=true;
		}
		else{
			this.movement=false;
		}
	}*/
	
	@Override
	public boolean handleLavaMovement(){
		if(movement&& this.worldObj.getClosestPlayerToEntity(this, 6d) != null){
			super.handleWaterMovement();
		}
		else{
			super.handleLavaMovement();
		}
		return super.handleLavaMovement();
		
	}
	
	public boolean isNotLazy() {
	    return movement;
	}

	public void beLazy(boolean movement) {
	    this.movement = !movement;
	}
}
