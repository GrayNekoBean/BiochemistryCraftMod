package cn.BiochemistryCraft.Entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDiable  extends BCCGeneMonster implements IBiology{

	public float prob=2.0f;
	
	
	public EntityDiable(World p_i1738_1_) {
		
		super(p_i1738_1_);
		this.useNormalMobAI(true);//是否快捷使用一般的怪物AI
		this.setHealth(25);//设置生命值
		this.setAttack(3.0f);//设置攻击力
		this.SetMutationProbly(prob);//设置变异几率
		// TODO 自动生成的构造函数存根
	}
	
	public EntityDiable(World p_i1738_1_,EntityLivingBase e) {
		
		super(p_i1738_1_);
		this.useNormalMobAI(true);//是否快捷使用一般的怪物AI
		this.setHealth(25);//设置生命值
		this.setAttack(3.0f);//设置攻击力
		this.SetMutationProbly(prob);//设置变异几率
		this.setPosition(e.posX, e.posY, e.posZ);
		// TODO 自动生成的构造函数存根
	}
	
	protected void addRandomArmor(){//给怪物添加装备
		Item rndItem = null;
		switch(this.worldObj.rand.nextInt(10)){
		
		case 1|2|3:
			rndItem=Items.iron_axe;
		
		case 5|6|7:
			rndItem=Items.iron_sword;
			
			default:
				
		
		
		}
		
		this.setCurrentItemOrArmor(1, new ItemStack(rndItem));
	}

	public EMutationKind setMutateKind(){//设置变异的种类暂时未完成
		
		return null;
		
	}
	
	public boolean attackEntityFrom(DamageSource damage,float par2){//当怪物被打时触发
		
		super.attackEntityFrom(damage, par2);
		this.prob++;
		return true;
		
	}
	
	
	
	
}
