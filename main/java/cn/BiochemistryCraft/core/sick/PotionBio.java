package cn.BiochemistryCraft.core.sick;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class PotionBio extends Potion{

	
	
	
	protected PotionBio(int p_i1573_1_, boolean p_i1573_2_, int p_i1573_3_) {
		super(p_i1573_1_, p_i1573_2_, p_i1573_3_);
		// TODO 自动生成的构造函数存根
	}
	public PotionBio(Potion e){
		super(e.getId(),e.isBadEffect(),e.getLiquidColor());
	}
	public boolean shouldRenderInvText(PotionEffect effect){
		return false;
	}
    @SideOnly(Side.CLIENT)
    public void renderInventoryEffect(int x, int y, PotionEffect effect, net.minecraft.client.Minecraft mc) { }
}
