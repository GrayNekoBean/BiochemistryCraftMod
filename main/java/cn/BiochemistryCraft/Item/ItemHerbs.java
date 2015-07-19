package cn.BiochemistryCraft.Item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemHerbs extends ItemFood implements IPlantable{
	private static final String[] herbsArray = new String[] {"fireGrass", "coolGrass"};
	
	private Block cropBlock;
	private Block soilBlock;
	
	public ItemHerbs(Block cropBlock, Block soilBlock, int id) {
		super(1, 0.6F, false);
		//effectSetting(id);
		this.soilBlock = soilBlock;
		this.cropBlock = cropBlock;
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10){
		if (par7 != 1){
			return false;
		}else if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack)){
            Block soil = par3World.getBlock(par4, par5, par6);
            if (soil != null && canPlaceBlockOn(soil) && par3World.isAirBlock(par4, par5 + 1, par6)) {
                par3World.setBlock(par4, par5 + 1, par6, this.cropBlock);
                --par1ItemStack.stackSize;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
	}
	
	@Override
	public Block getPlant(IBlockAccess arg0, int arg1, int arg2, int arg3) {
		return this.cropBlock;
	}

	@Override
	public int getPlantMetadata(IBlockAccess arg0, int arg1, int arg2, int arg3) {
		return 0;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess arg0, int arg1, int arg2, int arg3) {
		return EnumPlantType.Crop;
	}
	
	public static String getName(int id){
		return herbsArray[id];
	}
	
	private boolean canPlaceBlockOn(Block arg0){
		return arg0==soilBlock;
	}
	/*
	//这部分是用来增加使用后的药水效果的，先留着好了=。=
	private void effectSetting(int id){
		switch(id){
		case 0: //火炎草
			setPotionEffect("");
			break;
		case 1: //清凉草
			setPotionEffect("");
			break;
		}
	}
	*/
}
