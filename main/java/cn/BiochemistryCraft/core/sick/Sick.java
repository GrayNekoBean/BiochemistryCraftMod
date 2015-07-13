package cn.BiochemistryCraft.core.sick;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class Sick extends TimerTask{

	public Random rnd;
	public float probly=0.8f;
	public EntityLiving entity;
	public int strong=1;
	public Potion theEffect;
	
	public Sick(){
		
	}
	
	public void setTimer(){
		Timer sickTimer=new Timer();
		sickTimer.schedule(new Sick(), 1000);
	}
	
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		this.sickUpdate();
		
		
	}
	public void sickUpdate(){
		
		if(this.rnd.nextInt((int)(60*60*3/probly))==10){
			//player.addPotionEffect(new PotionEffect(Potion.poison.id,strong*this.rnd.nextInt(250)*62,0));
			this.sickEffect(this.entity);
			
		}
		
	}
	
	public void sickEffect(EntityLiving living){
		
		
	}
	
	public void setProbly(float par1){
		
		this.probly=par1;
	}
	
	public float getProbly(){
		return 1.0F;
	}
	
	
	
	
	

}
