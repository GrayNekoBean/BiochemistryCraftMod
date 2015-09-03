package cn.BiochemistryCraft.Entity;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;

public class EntityLavaZombie extends BCCEntityMob{

	public float[] size1=new float[]{0.6f,0.8f};
	public float[] size2=new float[]{1.8f,2.0f};
	int sizes=1;
	boolean movement;
	
	public EntityLavaZombie(World p_i1738_1_) {
		super(p_i1738_1_);
		this.useNormalMobAI(true);
		this.setSize(this.size1[sizes],this.size2[sizes]);
		this.isImmuneToFire=true;
	}
	public EntityLavaZombie(World p_i1738_1_,Entity e) {
		super(p_i1738_1_);
		this.useNormalMobAI(true);
		this.setSize(this.size1[sizes],this.size2[sizes]);
		this.setLocationAndAngles(e.posX, e.posY, e.posZ, e.rotationYaw, e.rotationPitch);
		this.motionX = e.motionX;this.motionY = e.motionY;this.motionZ = e.motionZ;
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
	public void onMutate() {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source,float f){
		if(source.getEntity() instanceof EntityPlayer||source.getEntity() instanceof EntityArrow){
			if(this.getHealth()<=12){
				this.worldObj.spawnParticle("lava", this.posX, this.posY, this.posZ, this.worldObj.rand.nextDouble(), this.worldObj.rand.nextDouble(), this.worldObj.rand.nextDouble());
				if(!this.worldObj.isRemote)
				{
					EntityLavaZombieBroken entity=new EntityLavaZombieBroken(this.worldObj,this);
					this.worldObj.removeEntity(this);
					this.worldObj.spawnEntityInWorld(entity);
				}
//				this.worldObj.removeEntity(this);
				return true;
			}
		}
		return super.attackEntityFrom(source, f);
	}
	
  
	
	@SubscribeEvent
	public void onTargetEntity(LivingSetAttackTargetEvent event){
		if(event.entityLiving instanceof EntityLavaZombie&&event.target instanceof EntityPlayer){
			this.movement=true;
		}
		else{
			this.movement=false;
		}
	}
	
	@Override
	public boolean handleLavaMovement(){
		if(movement&&this.worldObj.getClosestPlayerToEntity(this, 6d) != null){
			super.handleWaterMovement();
		}
		else{
			super.handleLavaMovement();
		}
		return super.handleLavaMovement();
		
	}
	public void beLazy(boolean b) {
		this.movement = !b;
	}
	

}
