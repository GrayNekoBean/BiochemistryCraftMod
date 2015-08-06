package cn.BiochemistryCraft.core.sick;

import java.util.TimerTask;

import org.apache.logging.log4j.Level;

import cn.BiochemistryCraft.BiochemistryCraft;
import cpw.mods.fml.common.FMLLog;
import net.minecraft.entity.EntityLivingBase;

public abstract class SSick extends TimerTask{
	private String SickName;
	private int SickID;
	public EntityLivingBase entity;
	
	public SSick()
	{
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
//		System.out.println("生病中");
		FMLLog.log(BiochemistryCraft.NAME, Level.DEBUG, "刃父划土");
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
	}
	
	public void SetEntity(EntityLivingBase entity)
	{
		this.entity=entity;
	}
}
