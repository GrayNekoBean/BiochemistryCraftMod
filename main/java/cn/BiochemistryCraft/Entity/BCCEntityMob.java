package cn.BiochemistryCraft.Entity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
	
	@SideOnly(Side.CLIENT)
	public static EntityPlayer getClientPlayerEntity() {
		return FMLClientHandler.instance().getClientPlayerEntity();
	}
	
	@SideOnly(Side.SERVER)
	public static EntityPlayer getServerPlayerEntity() {
		return ((NetHandlerPlayServer)FMLCommonHandler.instance().getClientToServerNetworkManager().channel().attr(NetworkRegistry.NET_HANDLER).get()).playerEntity;
	}
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
	}
}
