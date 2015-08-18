package cn.BiochemistryCraft.core.sick;

import java.util.TimerTask;

import cn.BiochemistryCraft.core.BCCLogger;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public abstract class SSick extends TimerTask{
	private String SickName;
	private int SickID;
	public EntityLivingBase entity;
	
	public SSick()
	{
	}

	@Override
	public void run() {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		BCCLogger.debug("鐢熺梾涓�");
		this.SickUpdate();
		this.displayEffect();
	}
	
	public void SickUpdate()
	{
		
	}
	
	
	public abstract void displayEffect();
	
	public void EndSick()
	{
		this.cancel();
		if(this.entity instanceof EntityPlayer){
			Sick.removeSick((EntityPlayer)this.entity, this);
		}
	}
	
	public void SetEntity(EntityLivingBase entity)
	{
		this.entity=entity;
		if(entity instanceof EntityPlayer){
			Sick.addSick((EntityPlayer)entity, this);
		}
	}
}
