package cn.BiochemistryCraft.core.sick;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class SickLoop extends TimerTask{

	public Random rnd;
	public float probly=0.8f;
	public EntityPlayer player;
	public int strong=1;
	public Potion theEffect;
	
	public SickLoop(){
		
	}
	
	public void setTimer(){
		Timer sickTimer=new Timer();
		sickTimer.schedule(new SickLoop(), 1000);
	}
	
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		this.sickUpdate();
		
		
	}
	public void sickUpdate(){
		
		if(this.rnd.nextInt((int)(60*60*3/probly))==10){
			//player.addPotionEffect(new PotionEffect(Potion.poison.id,strong*this.rnd.nextInt(250)*62,0));
			this.sickEffect(this.player);
			
		}
		
	}
	
	public void sickEffect(EntityPlayer player){
		
		
	}
	
	public void setProbly(float par1){
		
		this.probly=par1;
	}
	
	public float getProbly(){
		return 1.0F;
	}
	
	
	
	
	

}
