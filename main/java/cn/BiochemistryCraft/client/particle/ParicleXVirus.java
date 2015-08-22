package cn.BiochemistryCraft.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ParicleXVirus extends EntityFX{

	public float maxage=16.0f/(this.worldObj.rand.nextFloat()*0.8f)+2.0f;
	
	protected ParicleXVirus(World p_i1218_1_, double p_i1218_2_,double p_i1218_4_, double p_i1218_6_,float age) {
		super(p_i1218_1_, p_i1218_2_, p_i1218_4_, p_i1218_6_);
		this.maxage=age=this.particleAge;
		this.setRBGColorF(148, 0, 211);
		this.setSize(2.0f,1.75f);
		this.particleAlpha = 0.2f;
		// TODO �Զ����ɵĹ��캯�����
	}
	@Override
	public void onCollideWithPlayer(EntityPlayer player){
		super.onCollideWithPlayer(player);
	}

	public void applyEntityCollision(Entity entity){
		super.applyEntityCollision(entity);
	}
}
