package cn.BiochemistryCraft.proxy;

import cn.BiochemistryCraft.Register.BCCEntityRegister;

public class BCCclientProxy extends BCCcommonProxy{

public void preInit(){
		super.preInit();
	}
	
	public void load(){
		super.load();
	}
	
	public void postLoad(){
		super.postLoad();
	}
	
	public void registerRenderThings(){
	super.registerRenderThings();
	BCCEntityRegister.EntityRenderRegisterInit();
	}
	
	public void registerSound(){
		super.registerSound();
	}
	
	public void registerNormalThings(){
		super.registerNormalThings();
	}
}
