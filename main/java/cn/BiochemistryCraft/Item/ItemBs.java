package cn.BiochemistryCraft.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
public class ItemBs extends Item{
    public static final String[] BloodKind = new String[] {"cow", "pig", "chicken", "wolf", "player", "bat", "horse", "mooshroom", "ocelot", "sheep", "squid",
		"cavespider", "creeper", "enderman", "ghast", "magmacube", "pigzombie", "silverfish", "slime", "spider", "witch", "zombie"};
    public static IIcon i1;
    public static IIcon i2;
    public int xz;
	public ItemBs( int xzs){
		super();
		this.xz = xzs;
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setUnlocalizedName(BloodKind[this.xz] + "blood");
		this.setMaxStackSize(16);
		this.setMaxDamage(1);
		GameRegistry.registerItem(this, getxzsmean(xzs));
	}
	public static String getxzsmean(int xz){
		switch(xz){
			case 0: return "牛血"; 
			case 1: return "猪血"; 
			case 2: return "鸡血"; 
			case 3: return "狼血";
			case 4: return "人血";
			case 5: return "蝙蝠血";
			case 6: return "马血";
			case 7: return "哞菇血";
			case 8: return "猫血";
			case 9: return "羊血";
			case 10: return "章鱼血";
			case 11: return "地洞蜘蛛血";
			case 12: return "爬行者血";
			case 13: return "末影人血";
			case 14: return "幽灵血";
			case 15: return "熔岩史莱姆血";
			case 16: return "僵尸猪人血";
			case 17: return "虫血";
			case 18: return "史莱姆血";
			case 19: return "蜘蛛血";
			case 20: return "女巫血";
			case 21: return "僵尸血";
		default: return "牛血";
		}
	}
    public IIcon getIcon(ItemStack s, int r, EntityPlayer p, ItemStack u, int ur)
    {
    	if(this.xz <= 10){
    		return i1;
    	}else{
    		return i2;
    	}
    }
    public void registerIcons(IIconRegister ir)
    {
    	i1 = ir.registerIcon("biochemistrytextures:RedBloodSyringe");
    	i2 = ir.registerIcon("biochemistrytextures:GreenBloodSyringe");
    }
}
