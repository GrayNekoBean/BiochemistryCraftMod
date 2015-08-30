package cn.BiochemistryCraft.Entity;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityLavaZombieBroken extends EntityLavaZombie{

	public EntityLavaZombieBroken(World w) {
		super(w);
		this.setSize(0.8F, 2.0F);
		this.isImmuneToFire = false;
	}
	public EntityLavaZombieBroken(World w,Entity e) {
		this(w);
		this.setLocationAndAngles(e.posX, e.posY, e.posZ,e.rotationYaw,e.rotationPitch);
		this.setVelocity(e.motionX, e.motionY, e.motionZ);
		this.isImmuneToFire = false;
	}

	protected void applyEntityAttributes()
	{
	    super.applyEntityAttributes();
//	    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(26.0D);
	}
	    public void onKillEntity(EntityLivingBase p_70074_1_)
	    {
		super.onKillEntity(p_70074_1_);
	    }
	public void onLivingUpdate()
	{
	    super.skipMeLivingUpdate();
		if(this.getHealth() >= 14){
//			this.dataWatcher.updateObject(29,Byte.valueOf((byte)1));
		    if(!this.worldObj.isRemote){
		    this.addShleid();
		    }
		}
		if(isNotLazy()){
		    this.handleWaterMovement();
		}
		else{
		    super.handleLavaMovement();
		}
		if(this.getHealth()<=2){
			this.setFire(100);
		}
	}
	private void addShleid(){
		EntityLavaZombie entity=new EntityLavaZombie(this.worldObj,this);
		this.worldObj.removeEntity(this);
		this.worldObj.spawnEntityInWorld(entity);
		entity.setHealth(14f);
	}
	@Override
	public boolean attackEntityFrom(DamageSource source,float f){
		if(source.getEntity() instanceof EntityPlayer||source.getEntity() instanceof EntityArrow){
			if(this.getHealth()<=2){
				this.setFire(100);
				return true;
			}
		}
		return super.attackEntityFrom(source, f);
	}
}
