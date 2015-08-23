package cn.BiochemistryCraft.Block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCocoa;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import cn.BiochemistryCraft.Register.BCCRegisterItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTreeFruit extends BlockCocoa{
	public static IIcon icon;
	private Random rand = new Random();

	public BlockTreeFruit(){	
		setTickRandomly(true);
		setHardness(0.2F);
		setResistance(5.0F);
		setBlockTextureName(BiochemistryCraft.MODID+":treeFruitBlock");
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand){
		if (canBlockStay(world, x, y, z)){
			if(rand.nextInt(6) == 0){
				dropBlockAsItem(world, x, y, z, 0, 0);
			}
		}else{
			dropBlockAsItem(world, x, y, z, 0, 0);
			world.setBlock(x, y, z, Blocks.air, 0, 2);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z){
		return BCCRegisterItem.treeFruit;
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
		if (!canBlockStay(world, x, y, z)){
			dropBlockAsItem(world, x, y, z, 0, 0);
			world.setBlock(x, y, z, Blocks.air, 0, 2);
		}
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z){
		return world.getBlock(x, y + 1, z) == BCCRegisterBlock.treeFruitLeave;
	}
	
	@Override
	public Item getItemDropped(int meta, Random rand, int par3){
		return BCCRegisterItem.treeFruit;
	}
	  
	public boolean renderAsNormalBlock(){
		return false;
	}
	  
	public boolean isOpaqueCube(){
		return false;
	}

	public void dropBlockAsItemWithChance(World world, int arg1, int arg2, int arg3, int arg4, float arg5, int arg6){
		super.dropBlockAsItemWithChance(world, arg1, arg2, arg3, arg4, arg5, arg6);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata){
		return icon;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister arg0){
	    icon = arg0.registerIcon(BiochemistryCraft.MODID+":treeFruitBlock");
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getCocoaIcon(int p_149988_1_){
		return icon;
	}
	
	public int onBlockPlaced(World world, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_){
		return rand.nextInt(3);
	}
	
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int p_149690_5_, int fortune){
	    ArrayList<ItemStack> drop = new ArrayList<ItemStack>();
	    drop.add(new ItemStack(BCCRegisterItem.treeFruit, 1, 0));
	    return drop;
	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_){
		int l = p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_);
	    int i1 = getDirection(l);
	    int j1 = 1;
	    int k1 = 4 + j1 * 2;
	    int l1 = 5 + j1 * 2;
	    float f = k1 / 2.0F;
	    switch (i1){
	    	case 0: 
	    		setBlockBounds((8.0F - f) / 16.0F, (12.0F - l1) / 16.0F, (15.0F - k1) / 16.0F, (8.0F + f) / 16.0F, 0.75F, 0.9375F);
	    		break;
	    	case 1: 
	    		setBlockBounds(0.0625F, (12.0F - l1) / 16.0F, (8.0F - f) / 16.0F, (1.0F + k1) / 16.0F, 0.75F, (8.0F + f) / 16.0F);
	    		break;
	    	case 2: 
	    		setBlockBounds((8.0F - f) / 16.0F, (12.0F - l1) / 16.0F, 0.0625F, (8.0F + f) / 16.0F, 0.75F, (1.0F + k1) / 16.0F);
	    		break;
	    	case 3: 
	    		setBlockBounds((15.0F - k1) / 16.0F, (12.0F - l1) / 16.0F, (8.0F - f) / 16.0F, 0.9375F, 0.75F, (8.0F + f) / 16.0F);
	    }
	}
	
	public void dropBlockAsItem(World world, int x, int y, int z){
		dropBlockAsItem(world, x, y, z, 0, 0);
		world.setBlockToAir(x, y, z);
	}
}
