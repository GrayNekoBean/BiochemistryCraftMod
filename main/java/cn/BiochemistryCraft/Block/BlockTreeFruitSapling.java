package cn.BiochemistryCraft.Block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.event.terraingen.TerrainGen;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import cn.BiochemistryCraft.Register.BCCRegisterItem;
import cn.BiochemistryCraft.world.gen.feature.WorldGenFruitTree;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTreeFruitSapling extends BlockBush{
	private IIcon icon;
	
	public BlockTreeFruitSapling(){
		super(Material.plants);
	    float f = 0.4F;
	    setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	    setBlockTextureName(BiochemistryCraft.MODID+":treeFruitSaplingBlock");
	}
	
	public void updateTick(World world, int x, int y, int z, Random rand){
		super.updateTick(world, x, y, z, rand);
	}
	
	public void treeGene(World world, int x, int y, int z, Random rand){
		if (!TerrainGen.saplingGrowTree(world, rand, x, y, z)){
			return;
		}
		int meta = world.getBlockMetadata(x, y, z) & 3;
		Object object = new WorldGenFruitTree();
		world.setBlock(x, y, z, Blocks.air, 0, 4);
		if (!((WorldGenerator)object).generate(world, rand, x, y, z)){
			world.setBlock(x, y, z, this, meta, 4);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister arg0){
		icon = arg0.registerIcon(BiochemistryCraft.MODID+":treeFruitSaplingBlock");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return icon;
	}
	
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z){
		return EnumPlantType.Plains;
	}
	
	public void dropBlockAsItemWithChance(World world, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_){
	    if ((!world.isRemote)){
	          dropBlockAsItem(world, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(BCCRegisterItem.treeFruitSapling, 1, 0));
	    }
	}
	
	@Override
	protected boolean canPlaceBlockOn(Block arg0){
		return arg0==BCCRegisterBlock.biodirt || arg0==Blocks.dirt || arg0==Blocks.grass;
	}
	
	@Override
	public boolean canBlockStay(World arg0, int arg1, int arg2, int arg3){
		return canPlaceBlockOn(arg0.getBlock(arg1, arg2 - 1, arg3));
	}
}
