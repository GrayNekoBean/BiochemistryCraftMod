package cn.BiochemistryCraft.Gene;

import cn.BiochemistryCraft.core.sick.Sick;

public class InfectSource {
	
	public boolean canSick=true;
	
	public String name;
	
	public byte strong;
	
	public String reason=null;
	
	public boolean causeMutate=true;
	//=======================================================================================
	
	public static InfectSource Xvirus=new InfectSource("Xvirus");
	public static InfectSource furorVirus=new InfectSource("furorVirus");
	public static InfectSource parasiticer=new InfectSource("parasiticer");//寄生体
	
	
	public InfectSource(String Name){
		this.name=Name;
	}
	
	
	public InfectSource(String Name,byte Strong){
		
		this.name=Name;
		this.strong=Strong;
		
	}

	public boolean canCauseSick(){
		
		return this.canSick;
		
	}
	
	public Sick[] causeSick(Sick[] par1){
		if(this.canCauseSick()==true){
			return par1;
		}
		else{
			System.out.print("please return the method canCauseSick true first!");
			return null;
			
		}
	}
	
	public boolean canCauseMutate(){
		return causeMutate;
	}
	
	public String isCausedBy(){
		if(!(this.reason==null)){
		return this.reason;
		}
		else{
			return this.name;
		}
	}
	
	public void setReason(String str){
		
		reason=str;		
	
}
	
}