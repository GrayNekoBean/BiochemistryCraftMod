package cn.BiochemistryCraft.Item;


import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Entity.EntityBioPig;

import cn.BiochemistryCraft.Entity.Throwable.EntityAcid;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemAcidWand extends Item{

	public ItemAcidWand() {
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName("AcidWand");
		this.setTextureName("biomod:AcidWand");
		this.setCreativeTab(BiochemistryCraft.biocreativetab);
		this.setMaxDamage(200);
		this.setMaxStackSize(1);
	}
	
	public ItemStack onItemRightClick(ItemStack itemstk, World world, EntityPlayer player)
	{
		itemstk.damageItem(20 , player);
		if(!world.isRemote)
		{
			double x=player.posX;
			double y=player.posY;
			double z=player.posZ;
			EntityAcid entity=new EntityAcid(world,player,4,1.5F,1.5F);
			world.spawnEntityInWorld(entity);
			
		}
		return itemstk;
	}
	
	

}
	
