package cn.BiochemistryCraft.Block;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockTreeFruitLeave extends BlockLeavesBase implements IShearable{
	int[] adjacentTreeBlocks;
	IIcon icon;
	
	public BlockTreeFruitLeave(){
		super(Material.leaves, false);
	    setCreativeTab(null);
	    setTickRandomly(true);
	    setHardness(0.2F);
	    setLightOpacity(1);
	    setStepSound(soundTypeGrass);
	    setBlockTextureName(BiochemistryCraft.MODID+":treeFruitLeave");
	}
	
	public String[] func_150125_e() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int arg0, int arg1) {
		return icon;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister arg0){
		icon = arg0.registerIcon(getTextureName());
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand){
		byte b0 = 4;
		int i1 = b0 + 1;
		byte b1 = 32;
		int j1 = b1 * b1;
		int k1 = b1 / 2;

		if (adjacentTreeBlocks == null){
			adjacentTreeBlocks = new int[b1 * b1 * b1];
		}
		int l1;
		if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y + i1, z + i1)){
			int i2;
			int j2;

			for (l1 = -b0; l1 <= b0; ++l1){
				for (i2 = -b0; i2 <= b0; ++i2){
					for (j2 = -b0; j2 <= b0; ++j2){
						Block block = world.getBlock(x + l1, y + i2, z + j2);

						if (!block.canSustainLeaves(world, x + l1, y + i2, z + j2)){
							if (block.isLeaves(world, x + l1, y + i2, z + j2)){
								adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -2;
							}else{
								adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -1;
							}
						}else{
							adjacentTreeBlocks[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = 0;
						}
					}
				}
			}

			for (l1 = 1; l1 <= 4; ++l1){
				for (i2 = -b0; i2 <= b0; ++i2){
					for (j2 = -b0; j2 <= b0; ++j2){
						for (int k2 = -b0; k2 <= b0; ++k2){
							if (adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1] == l1 - 1){
								if (adjacentTreeBlocks[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2){
									adjacentTreeBlocks[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
								}

								if (adjacentTreeBlocks[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2){
									adjacentTreeBlocks[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
								}

								if (adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] == -2){
									adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] = l1;
								}

								if (adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] == -2){
									adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] = l1;
								}

								if (adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] == -2){
									adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] = l1;
								}

								if (adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] == -2){
									adjacentTreeBlocks[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] = l1;
								}
							}
						}
					}
				}
			}
		}

		l1 = adjacentTreeBlocks[k1 * j1 + k1 * b1 + k1];

		if (l1 >= 0){
			world.setBlockMetadataWithNotify(x, y, z, 0, 4);
		}else{
			removeLeaves(world, x, y, z);
		}
		if(world.getBlock(x, y - 1, z) == Blocks.air && rand.nextInt(25) == 0){
			world.setBlock(x, y - 1, z, BCCRegisterBlock.treeFruitBlock);
			world.setBlockMetadataWithNotify(x, y - 1, z, 1 << 2 | rand.nextInt(4), 2);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_){
		if ((p_149734_1_.canLightningStrikeAt(p_149734_2_, p_149734_3_ + 1, p_149734_4_)) && (!World.doesBlockHaveSolidTopSurface(p_149734_1_, p_149734_2_, p_149734_3_ - 1, p_149734_4_)) && (p_149734_5_.nextInt(15) == 1)){
			double d0 = p_149734_2_ + p_149734_5_.nextFloat();
			double d1 = p_149734_3_ - 0.05D;
			double d2 = p_149734_4_ + p_149734_5_.nextFloat();
			p_149734_1_.spawnParticle("dripWater", d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}
	
	private void removeLeaves(World world, int x, int y, int z){
		world.setBlockToAir(x, y, z);
	}
	
	public Item getItemDropped(int meta, Random rand, int par3){
	    return null;
	}
	
	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int size){
	    super.harvestBlock(world, player, x, y, z, size);
	} 
	
	public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_){
	    //super.dropBlockAsItemWithChance(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, 1.0F, p_149690_7_);
	}
	
	@Override
	public boolean isShearable(ItemStack arg0, IBlockAccess arg1, int arg2, int arg3, int arg4) {
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack arg0, IBlockAccess arg1, int arg2, int arg3, int arg4, int arg5) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(Blocks.leaves, 1, 1));
		return ret;
	}
	
	@Override
	public int quantityDropped(Random random){
		return 0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBlockColor(){
		double d0 = 0.5D;
		double d1 = 1.0D;
		return ColorizerFoliage.getFoliageColor(d0, d1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderColor(int meta){
		return ColorizerFoliage.getFoliageColorBasic();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess world, int x, int y, int z){
		int meta = world.getBlockMetadata(x, y, z);

		int r = 0;
		int g = 0;
		int b = 0;

		for (int l1 = -1; l1 <= 1; ++l1){
			for (int i2 = -1; i2 <= 1; ++i2){
				int j2 = world.getBiomeGenForCoords(x + i2, z + l1).getBiomeFoliageColor(x + i2, y, z + l1);
				r += (j2 & 16711680) >> 16;
			g += (j2 & 65280) >> 8;
				b += j2 & 255;
			}
		}

		return (r / 9 & 255) << 16 | (g / 9 & 255) << 8 | b / 9 & 255;
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side){
		return true;
	}
}
