package cn.BiochemistryCraft.Entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityLavaZombieBroken extends BCCEntityMob{

	public EntityLavaZombieBroken(World w) {
		super(w);
		this.setSize(0.8F, 2.0F);
		this.isImmuneToFire=false;
		this.useNormalMobAI(true);
		// TODO Auto-generated constructor stub
	}
	public EntityLavaZombieBroken(World w,Entity e) {
		this(w);
		this.setLocationAndAngles(e.posX, e.posY, e.posZ, e.rotationYaw, e.rotationPitch);
		this.motionX = e.motionX;this.motionY = e.motionY;this.motionZ = e.motionZ;
	}
	@Override
	public boolean isAIEnabled(){
		return true;
		
	}
	protected void applyEntityAttributes()
	{
	    super.applyEntityAttributes();
	    getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
	    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2300000041723251D);
	    getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
	    getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(14.0D);
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
	@Override
	public void onMutate() {
		// TODO Auto-generated method stub
		
	}
}
