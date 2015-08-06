package cn.BiochemistryCraft.Block;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;

import scala.actors.threadpool.Arrays;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Item.ItemHerbs;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import cn.BiochemistryCraft.Register.BCCRegisterItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockGracilariaCorp extends BlockCrops{
	@SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
	
	public BlockGracilariaCorp(){
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        setTickRandomly(true);
        setBlockTextureName(BiochemistryCraft.MODID+":gracilariaCorp");
        setBlockName("gracilariaCorp");
	}
	
	public int getRenderType(){	
		return 1;
	}
	
	private Item getSeedItem(){
		return BCCRegisterItem.gracilaria;
    }
	
	private Item getCropItem(){
        return getSeedItem();
    }
	
	public Item getItemDropped(int arg0, Random arg1, int arg2){
	    return getSeedItem();
	}
	
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune){
		ArrayList<ItemStack> ret = new ArrayList();
		ret.add(new ItemStack(getSeedItem(), 1, 0));
		if (metadata >= 2) {
	    	for (int i = 0; i < 3 + fortune; i++) {
	    		if (world.rand.nextInt(5) <= metadata) {
	    			ret.add(new ItemStack(getSeedItem(), 1, 0));
	    		}
	    	}
	    }
	    return ret;
	}
	
	@SideOnly(Side.CLIENT)
	public Item getItem(World arg0, int arg1, int arg2, int arg3){
	    return getSeedItem();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister arg0){
	    this.iconArray = new IIcon[3];
	    for (int i = 0; i < this.iconArray.length; i++){
	      this.iconArray[i] = arg0.registerIcon(getTextureName() + "_stage_" + i);
	    }
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata){
		if(metadata < 0 || metadata > 2){
			metadata = 2;
		}
		return iconArray[metadata];
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random){
		if(!canBlockStay(world, x, y, z)){
			dropBlockAsItem(world, x, y, z, new ItemStack(BCCRegisterItem.gracilaria, 1));
		}else if(world.getBlockLightValue(x, y, z) >= 8){
			int metadata = world.getBlockMetadata(x, y, z);
			if (metadata == 2) {
				return;
			}
			if (random.nextInt(12) != 0) {
				return;
			}
			metadata++;
			world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
		}
    }
	
	protected boolean canPlaceBlockOn(Block block){
		return block == Blocks.water;
	}
	
	public boolean canBlockStay(World world, int x, int y, int z){
		return canPlaceBlockOn(world.getBlock(x, y - 1, z));
	}
}
