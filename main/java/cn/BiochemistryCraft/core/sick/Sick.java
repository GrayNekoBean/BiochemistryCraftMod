package cn.BiochemistryCraft.core.sick;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import cn.BiochemistryCraft.Entity.IBiology;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class Sick extends TimerTask{

	public Random rnd;
	public float probly=0.8f;
	public EntityLiving entity;
	public int strong=1;
	public Potion theEffect;
	public boolean gotSick;
	//=========================================================================================//
	public static Sick sickCold=new Sick("cold",1);
	public Sick(String name,int strong){
		
	}
	
	public void setTimer(){
		Timer sickTimer=new Timer();
		sickTimer.schedule(new Sick(null, strong), 1000);
	}
	
	@Override
	public void run() {
		this.sickUpdate();
	}
	public void sickUpdate(){
		if(((IBiology)entity).isSick()){
			this.sickEffect(entity);
		}
		if(this.rnd.nextInt((int)(60 * 60 * 3 / probly)) == 10){
			//player.addPotionEffect(new PotionEffect(Potion.poison.id,strong*this.rnd.nextInt(250)*62,0));
			this.gotSick = true;
			
		}
		if(gotSick == true){
			this.sickEffect(entity);
		}
		
	}
	
	public void sickEffect(EntityLiving living){
		if(EntityPlayer.class.equals(living)){
		    ((IBiology)living).getDisease().effectOnPlayer(EntityPlayer.class.cast(living));
		}
		else{
		    ((IBiology)living).getDisease().effectOnMob(living);
		}
	}
	
	public void setProbly(float par1){
		
		this.probly=par1;
	}
	
	public float getProbly(){
		return 1.0F;
	}
	
}
