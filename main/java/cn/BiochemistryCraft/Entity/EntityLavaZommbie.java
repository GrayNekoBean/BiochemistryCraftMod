package cn.BiochemistryCraft.Entity;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;

public class EntityLavaZommbie extends BCCEntityMob{

	public float[] size1=new float[]{0.6f,0.8f};
	public float[] size2=new float[]{1.8f,2.0f};
	int sizes=1;
	boolean movement;
	public byte protecting=this.dataWatcher.getWatchableObjectByte(29);
	
	public EntityLavaZommbie(World p_i1738_1_) {
		super(p_i1738_1_);
		this.useNormalMobAI(true);
		this.setSize(this.size1[sizes],this.size2[sizes]);
		this.setHealth(26);
		if(this.dataWatcher.getWatchableObjectByte(29)==1){
			this.isImmuneToFire=true;
		}
		else{
			this.isImmuneToFire=false;
		}
		
		
		// TODO 自动生成的构造函数存根
	}
	
	@Override
	public boolean isAIEnabled(){
		return true;
		
	}
	
	@Override
	public void entityInit(){
		super.entityInit();
		this.dataWatcher.addObject(29,Byte.valueOf((byte) 1));
	}

	@Override
	public void onMutate() {
		// TODO 自动生成的方法存根
		
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source,float f){
		super.attackEntityFrom(source, f);
		if(source.getEntity() instanceof EntityPlayer||source.getEntity() instanceof EntityArrow){
			if(this.getHealth()<=12){
				this.dataWatcher.updateObject(29,Byte.valueOf((byte)0));
				this.worldObj.spawnParticle("lava", this.posX, this.posY, this.posZ, this.worldObj.rand.nextDouble(), this.worldObj.rand.nextDouble(), this.worldObj.rand.nextDouble());
				return true;
			}
		}
		return super.attackEntityFrom(source, f);
	}
	
	public void onUpdate(){
		super.onUpdate();
		if(this.getHealth()<=2){
			this.setFire(100);
		}
	}
  
	
	@SubscribeEvent
	public void onTargetEntity(LivingSetAttackTargetEvent event){
		if(event.entityLiving instanceof EntityLavaZommbie&&event.target instanceof EntityPlayer){
			this.movement=true;
		}
		else{
			this.movement=false;
		}
	}
	
	@Override
	public boolean handleLavaMovement(){
		if(movement&&this.getDistanceToEntity(this.getServerPlayerEntity())<6.0D){
		super.handleWaterMovement();
		}
		else{
			super.handleLavaMovement();
		}
		return super.handleLavaMovement();
		
	}

}
