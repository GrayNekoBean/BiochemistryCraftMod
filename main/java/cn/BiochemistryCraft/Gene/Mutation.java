package cn.BiochemistryCraft.Gene;

import net.minecraft.entity.EntityLiving;
import cn.BiochemistryCraft.Entity.BCCGeneAnimal;
import cn.BiochemistryCraft.Entity.BCCGeneMonster;
import cn.BiochemistryCraft.core.sick.Sick;

public class Mutation extends Sick{
	
	
	public Mutation(String name, int strong) {
		super(name, strong);
		// TODO 自动生成的构造函数存根
	}

	public float probly;
	public BCCGeneMonster mob;
	public BCCGeneAnimal animal;
	
	public void mutation_mob(){
		
		
		
	}
	
	public void mutation_animal(){
		
	}

}
