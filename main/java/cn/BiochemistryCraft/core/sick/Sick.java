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

	public EntityPlayer player;
	public Random rnd;
	public float probly=0.8f;
	public static EntityLivingBase entity;
	public Potion theEffect;
	public boolean gotSick;
	public int prevStrong;
	public String Name;
	public int maxStrong;
	public float worsenProbly;
	public Map attrs= Maps.newHashMap();
	public List<Sick> HasSicks = new ArrayList();
	public List<Sick> sickList = new ArrayList();
	//=========================================================================================
	public static Sick sickCold=new SickCold();
	public Sick(String name,int strong,EntityLivingBase entity2){
		entity2=player;
		this.maxStrong=strong;
		this.Name=name;
		this.entity=entity2;
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
		Random rnd=this.entity.worldObj.rand;
		
		if(((IBiology)entity).getSick(this)==true){
			this.HasSicks.add(sickList.get(rnd.nextInt(sickList.size())));
			this.gotSick=true;
		}
		if(this.rnd.nextInt((int)(60*60*3/probly))==10){
			//player.addPotionEffect(new PotionEffect(Potion.poison.id,strong*this.rnd.nextInt(250)*62,0));
			this.HasSicks.add(sickList.get(rnd.nextInt(sickList.size())));
			this.gotSick=true;
		}
		if(gotSick==true){
			for(int i=0;i<HasSicks.size();i++){
				if(this.HasSicks.get(i) != null){
		 this.HasSicks.get(i).displayEffect(entity);
				}
		}
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

	public void displayEffect(EntityLivingBase entity2) {
		// TODO 自动生成的方法存根
		this.entity=entity2;
		
		
	}
	
	public float WorsenProbly(){
		return this.worsenProbly;
	}
	
	public void setWorsenProbly(float f){
		this.worsenProbly=f;
	}
	
	 
	 public double func_111183_a(int p_111183_1_, AttributeModifier p_111183_2_)
	    {
	        return p_111183_2_.getAmount() * (double)(p_111183_1_ + 1);
	    }
	 
	private String getName() {
		// TODO 自动生成的方法存根
		return Name;
	}
	
	public void RegisterSick(Sick s){
		
		for(int i=0;i<sickList.size();i++){
			sickList.add(i, s);
		}
	}
	
	public Sick RegAttribute(IAttribute attr, UUID uuid, double value, int unKnow)
    {
        AttributeModifier attributemodifier = new AttributeModifier(uuid, this.getName(), value, unKnow);
        this.attrs.put(attr, attributemodifier);
        this.entity.getEntityAttribute(attr).setBaseValue(value);
        return this;
    }
	
	public Sick SetAttribute(IAttribute attr,double value){
		this.entity.getEntityAttribute(attr).setBaseValue(value);
		return this;
	}
	
	public void addSick(Sick s){
		if(HasSicks.indexOf(s)==-1){
			HasSicks.add(s);
		}
		else{
			s.prevStrong++;
		}
	}
	
	public List<Sick> getHasSick(){
		
		return HasSicks;
		
	}
	
}
