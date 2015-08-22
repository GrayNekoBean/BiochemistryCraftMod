package cn.BiochemistryCraft.Entity.Throwable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockPotato;
import net.minecraft.block.BlockStem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;

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
	        if (!this.worldObj.isRemote)
	        {
			int x = (int) posX;
			int y = (int) posY;
			int z = (int) posZ;
			Block acid = BCCRegisterBlock.acid;
			for(int x1 = -1; x1 <= 1; x1++){
				for(int y1 = -1; y1 <= 1; y1++){
					for(int z1 = -1; z1 <= 1; z1++){
					    int x2 = x + x1, y2 = y + y1 - 1, z2 = z + z1;
					    if (worldObj.getBlock(x2, y2, z2) == Blocks.air){
						if(worldObj.getBlock(x2, y2 - 1, z2).getMaterial().isSolid() && worldObj.getBlock(x2, y2 - 1, z2) != BCCRegisterBlock.acid){
							worldObj.setBlock(x2, y2, z2, acid);
						}
						else if (isPlants(worldObj.getBlock(x2, y2 - 1, z2))) {
							worldObj.setBlock(x2, y2 - 1, z2, acid);
						}
					    }
					}
				}
			}
		this.setDead();
	        }
	}
	protected float func_70182_d()
    {
        return 2.0F;
    }
    
    
    protected float getGravityVelocity()
    {
        return this.gravity; 
    }
    
        private boolean isPlants(Block block){
	boolean flag = block instanceof BlockFlower;
	boolean flag1 = block instanceof BlockDoublePlant;
	boolean flag2 = block instanceof BlockDeadBush;
	boolean flag3 = block instanceof BlockCarrot;
	boolean flag4 = block instanceof BlockPotato;
	boolean flag5 = block instanceof BlockBush;
	boolean flag6 = block instanceof BlockStem;
	return flag || flag1 || flag2 || flag3 || flag4 || flag5 || flag6;
    }
}
