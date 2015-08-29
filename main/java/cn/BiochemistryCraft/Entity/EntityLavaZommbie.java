package cn.BiochemistryCraft.Entity;

import cn.BiochemistryCraft.Entity.EntityAI.LavaZombieBeNLazyAI;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;

public class EntityLavaZommbie extends BCCEntityMob{

	public float[] size1=new float[]{0.6f,0.8f};
	public float[] size2=new float[]{1.8f,2.0f};
	int sizes=1;
	private boolean movement;
	public byte protecting=this.dataWatcher.getWatchableObjectByte(29);
	
	public EntityLavaZommbie(World p_i1738_1_) {
		super(p_i1738_1_);
		this.useNormalMobAI(true);
	        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityZombie.class, 1.0D, true));
	        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLavaZommbie.class, 1.0D, false));
		this.targetTasks.removeTask(new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new LavaZombieBeNLazyAI(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new LavaZombieBeNLazyAI(this, EntityZombie.class, 0, false));
		this.targetTasks.addTask(2, new LavaZombieBeNLazyAI(this, EntityLavaZommbie.class, 0, true));
		this.setSize(this.size1[sizes],this.size2[sizes]);
		this.setHealth(26);
	}
	    protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(12.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
	        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
	    }
	@Override
	public boolean isAIEnabled(){
		return true;
	}
	public boolean shouldBreakShield(){
	    return this.dataWatcher.getWatchableObjectByte(29) == 0;
	}
	@Override
	public void entityInit(){
		super.entityInit();
		this.dataWatcher.addObject(29,Byte.valueOf((byte) 1));
	}

	@Override
	public void onMutate() {}
	
	@Override
	public boolean attackEntityFrom(DamageSource source,float f){
		if(!super.attackEntityFrom(source, f)){
		    return false;
		}
		if(source.getEntity() instanceof EntityPlayer||source.getEntity() instanceof EntityArrow){
			if(this.getHealth() <= 12){
				this.dataWatcher.updateObject(29,Byte.valueOf((byte)0));
				this.worldObj.spawnParticle("lava", this.posX, this.posY, this.posZ, this.worldObj.rand.nextDouble(), this.worldObj.rand.nextDouble(), this.worldObj.rand.nextDouble());
				return true;
			}
		}
		return true;
	}
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
			this.dataWatcher.updateObject(29,Byte.valueOf((byte)0));
		}
		if(this.dataWatcher.getWatchableObjectByte(29)==1){
			this.isImmuneToFire=true;
		}
		else{
			this.isImmuneToFire=false;
		}
		if(isNotLazy()){
		    this.handleWaterMovement();
		}
		else{
		    super.handleLavaMovement();
		}
		if(this.getHealth()<=2){
			this.setFire(8);
		}
	}
	public void onUpdate(){
		super.onUpdate();
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

	            EntityLavaZommbie entityzombie = new EntityLavaZommbie(this.worldObj);
	            entityzombie.copyLocationAndAnglesFrom(p_70074_1_);
//	            this.worldObj.removeEntity(p_70074_1_);
	            entityzombie.onSpawnWithEgg((IEntityLivingData)null);
	            this.worldObj.spawnEntityInWorld(entityzombie);
	            this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1016, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
	        }
	    }
	@SubscribeEvent
	public void onTargetEntity(LivingSetAttackTargetEvent event){
		if(event.entityLiving instanceof EntityLavaZommbie && event.target instanceof EntityPlayer){
			this.beLazy(false);
		}
		else{
			this.beLazy(true);
		}
	}
	
	@Override
	public boolean handleLavaMovement(){
		if(isNotLazy() && this.worldObj.getClosestPlayerToEntity(this, 6d) != null){
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
