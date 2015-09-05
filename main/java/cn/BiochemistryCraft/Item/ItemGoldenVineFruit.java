package cn.BiochemistryCraft.Item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.core.sick.SSick;
import cn.BiochemistryCraft.core.sick.SickCold;
import cn.BiochemistryCraft.core.sick.SickHeatIllness;
import cn.BiochemistryCraft.core.sick.SickPlayerInfo;

public class ItemGoldenVineFruit extends ItemCure{

	public ItemGoldenVineFruit(){
		super(2, 0.8F);
		setTextureName(BiochemistryCraft.MODID+":goldenVineFruit");
	    setCreativeTab(BiochemistryCraft.biocreativetab);
		setUnlocalizedName("goldenVineFruit");
	}
    protected void onCureTaken(ItemStack itemStack, World world, EntityPlayer player) {
    	if(SickPlayerInfo.getSickListFromPlayer(player) != null){
    	for (SSick sick : SickPlayerInfo.read(player)) {
			if(sick instanceof SickCold || sick instanceof SickHeatIllness.HeatExhaustion){
				sick.endSick();
//				SickPlayerInfo.removeSick(player, sick);

			}
		}
    	}
		super.onCureTaken(itemStack, world, player);
	}
}
