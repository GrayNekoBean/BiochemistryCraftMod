package cn.BiochemistryCraft.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.item.Item;

public class BCCitemBase extends Item{

	public BCCitemBase(){
		
	}
	
	
	public void setItem(String str){
		this.setUnlocalizedName(str);
		this.setTextureName(BiochemistryCraft.NAME + this.getUnlocalizedName() );
		GameRegistry.registerItem(this,this.getUnlocalizedName());
		
	}
	
}
