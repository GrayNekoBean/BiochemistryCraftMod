package cn.BiochemistryCraft.Item;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Entity.Throwable.EntityAcid;

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
			EntityAcid entity=new EntityAcid(world,player,4,1.5F,1.5F);
			world.spawnEntityInWorld(entity);
		}
		return itemstk;
	}
	
	

}
	
