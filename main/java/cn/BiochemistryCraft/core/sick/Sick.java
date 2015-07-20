package cn.BiochemistryCraft.core.sick;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import cn.BiochemistryCraft.Entity.IBiology;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;

public class Sick extends TimerTask implements Isick{

	
	public Random rnd;
	public float probly=0.8f;
	public static EntityLiving entity;
	public Potion theEffect;
	public boolean gotSick;
	public int prevStrong;
	public String Name;
	public int maxStrong;
	public float worsenProbly;
	public Map attrs= Maps.newHashMap();
	public List<Sick> sicks = new ArrayList();
	//=========================================================================================
	public static Sick sickCold=new Sick("cold",1, entity);
	public Sick(String name,int strong,EntityLiving e){
		this.maxStrong=strong;
		this.Name=name;
		this.entity=e;
	}
	
	public void setTimer(){
		Timer sickTimer=new Timer();
		sickTimer.schedule(new Sick(Name, maxStrong,entity), 1000);
	}
	
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		this.sickUpdate();
		
		
	}
	public void sickUpdate(){
		if(((IBiology)entity).getSick(this)==true){
			this.displayEffect(entity);
		}
		if(this.rnd.nextInt((int)(60*60*3/probly))==10){
			//player.addPotionEffect(new PotionEffect(Potion.poison.id,strong*this.rnd.nextInt(250)*62,0));
			this.gotSick=true;
			
		}
		if(gotSick==true){
			this.displayEffect(entity);
		}
		
		if(this.prevStrong<this.maxStrong){
			if(this.rnd.nextInt(MathHelper.floor_float(2000/this.WorsenProbly()))==62){
				this.prevStrong++;
			}
		}
		
	}
	
	
	
	public void setProbly(float par1){
		
		this.probly=par1;
	}
	
	public float getProbly(){
		return this.probly;
	}

	public void displayEffect(EntityLiving livings) {
		// TODO 自动生成的方法存根
		this.entity=livings;
		
		
	}
	
	public float WorsenProbly(){
		return this.worsenProbly;
	}
	
	public void setWorsenProbly(float f){
		this.worsenProbly=f;
	}
	
	 public void applyAttributesModifiersToEntity(EntityLivingBase e, BaseAttributeMap p_111185_2_, int p_111185_3_)
	    {
		 e=this.entity;
	        Iterator iterator = this.attrs.entrySet().iterator();

	        while (iterator.hasNext())
	        {
	            Entry entry = (Entry)iterator.next();
	            IAttributeInstance iattributeinstance = p_111185_2_.getAttributeInstance((IAttribute)entry.getKey());

	            if (iattributeinstance != null)
	            {
	                AttributeModifier attributemodifier = (AttributeModifier)entry.getValue();
	                iattributeinstance.removeModifier(attributemodifier);
	                iattributeinstance.applyModifier(new AttributeModifier(attributemodifier.getID(), this.getName() + " " + p_111185_3_, this.func_111183_a(p_111185_3_, attributemodifier), attributemodifier.getOperation()));
	            }
	        }
	    }
	 
	 public double func_111183_a(int p_111183_1_, AttributeModifier p_111183_2_)
	    {
	        return p_111183_2_.getAmount() * (double)(p_111183_1_ + 1);
	    }
	 
	private String getName() {
		// TODO 自动生成的方法存根
		return Name;
	}
	
	public Sick RegAttribute(IAttribute attr, String uuid, double value, int unKnow)
    {
        AttributeModifier attributemodifier = new AttributeModifier(UUID.fromString(uuid), this.getName(), value, unKnow);
        this.attrs.put(attr, attributemodifier);
        this.entity.getEntityAttribute(attr).setBaseValue(value);
        return this;
    }
	
	public Sick SetAttribute(IAttribute attr,double value){
		this.entity.getEntityAttribute(attr).setBaseValue(value);
		return this;
	}
	

}
