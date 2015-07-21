package cn.BiochemistryCraft.Item;

import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemTreeFruitSapling extends Item implements IPlantable{
	public ItemTreeFruitSapling(){
		setTextureName(BiochemistryCraft.MODID+":treeFruitSapling");
		setCreativeTab(BiochemistryCraft.biocreativetab);
		setUnlocalizedName("treeFruitSapling");
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10){
		if (par7 != 1){
			return false;
		}else if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack)){
            Block soil = par3World.getBlock(par4, par5, par6);
            if (soil != null && canPlaceBlockOn(soil) && par3World.isAirBlock(par4, par5 + 1, par6)) {
                par3World.setBlock(par4, par5 + 1, par6, BCCRegisterBlock.treeFruitSaplingBlock);
                --par1ItemStack.stackSize;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
	}
	
	private boolean canPlaceBlockOn(Block arg0){
		return arg0==BCCRegisterBlock.biodirt || arg0==Blocks.dirt || arg0==Blocks.grass;
	}

	@Override
	public Block getPlant(IBlockAccess arg0, int arg1, int arg2, int arg3) {
		return BCCRegisterBlock.treeFruitSaplingBlock;
	}

	@Override
	public int getPlantMetadata(IBlockAccess arg0, int arg1, int arg2, int arg3) {
		return 0;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess arg0, int arg1, int arg2, int arg3) {
		return EnumPlantType.Crop;
	}

}
