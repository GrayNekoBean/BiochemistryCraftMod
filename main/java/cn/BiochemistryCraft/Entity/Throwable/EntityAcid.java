package cn.BiochemistryCraft.Entity.Throwable;

import net.minecraft.block.Block;

import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class EntityAcid extends EntityThrowable{
	int damage = 4;
	float gravity=0.001F;
	public EntityAcid(World w)
	{
		super(w);
	}
	public EntityAcid(World w, EntityLivingBase elb,int dmg,float s1,float s2) {
		super(w, elb);
		this.damage=dmg;
		this.setSize(s1,s2);
		// TODO Auto-generated constructor stub
	}
	public EntityAcid(World w, EntityLivingBase elb,double d1,double d2,double d3,int dmg,float s1,float s2){
		super(w,d1,d2,d3);
		this.setSize(s1,s2);
		this.damage=dmg;
		float angle = (elb.rotationYaw/ 180F) * 3.141593F; //水平方向的角度
		 float angle2 = (-elb.rotationPitch/ 180F) * 3.141593F; //垂直方向的仰角
		 final float speed = 2f; 
		 this.motionY = speed * MathHelper.sin(angle2); //算出三个方向上的速度,为了方便阅读我先计算的Y轴分速度
		 this.motionX = speed * MathHelper.cos(angle2) * -MathHelper.sin(angle); //根据仰角算出速度在XZ平面上的投影,再正交分解投影
		 this.motionZ = speed * MathHelper.cos(angle2) * MathHelper.cos(angle);
		 
		 
	}
	@Override
	protected void onImpact(MovingObjectPosition mop) {
		// TODO 自动生成的方法存根
		World world=this.worldObj;
		if(mop.typeOfHit==MovingObjectType.ENTITY)
		{
			int x=MathHelper.floor_double(mop.entityHit.posX);
			int y=MathHelper.floor_double(mop.entityHit.posY);
			int z=MathHelper.floor_double(mop.entityHit.posZ);
			Block acid=BCCRegisterBlock.acid;
			world.setBlock(x, y, z, acid);
			world.setBlock(x-1, y, z, acid);
			world.setBlock(x+1, y, z, acid);
			world.setBlock(x-1, y, z+1, acid);
			world.setBlock(x+1, y, z+1, acid);
			world.setBlock(x, y, z+1, acid);
			world.setBlock(x-1, y, z-1, acid);
			world.setBlock(x+1, y, z-1, acid);
			world.setBlock(x, y, z-1, acid);
		}
		this.setDead();
	}
	protected float func_70182_d()
    {
        return 2.0F;
    }
    
    
    protected float getGravityVelocity()
    {
        return this.gravity; 
    }
}
