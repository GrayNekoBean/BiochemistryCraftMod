package cn.BiochemistryCraft.Block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.BlockVine;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Register.BCCRegisterItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGoldenVine extends BlockVine implements IShearable{
	@SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
	
	public BlockGoldenVine() {
		super();
        setBlockTextureName(BiochemistryCraft.MODID+":goldenVine");
        setCreativeTab(BiochemistryCraft.biocreativetab);
        setBlockName("goldenVine");
	}
	
	public void updateTick(World world, int x, int y, int z, Random rand){
		int metadata = world.getBlockMetadata(x, y, z);
		int metadata2 = metadata & 3;
		world.setBlockMetadataWithNotify(x, y, z, metadata >> 2, 0);
		super.updateTick(world, x, y, z, rand);
		if(!world.isRemote && world.getBlockLightValue(x, y, z) >= 8 && metadata2 != 1){
			if(rand.nextInt(12) == 0){
				metadata2++;
			}
		}
		world.setBlockMetadataWithNotify(x, y, z, metadata << 2 | metadata2, 0);
	}
	  
	public Item getItemDropped(int p_149650_1_, Random rand, int p_149650_3_){
	    return BCCRegisterItem.goldenVineFruit;
	}
	  
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune){
		int metadata = world.getBlockMetadata(x, y, z) & 3;
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(Blocks.vine, 1));
		ret.add(new ItemStack(BCCRegisterItem.goldenVineFruit, 1 + metadata));
		return ret;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister arg0){
	    this.iconArray = new IIcon[2];
	    for (int i = 0; i < this.iconArray.length; i++){
	      this.iconArray[i] = arg0.registerIcon(getTextureName() + "_stage_" + i);
	    }
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata){
		metadata = metadata & 3;
		if(metadata < 0 || metadata > 1){
			metadata = 1;
		}
		return iconArray[metadata];
	}
	
	public int onBlockPlaced(World world, int x, int y, int z, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_){
		world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) << 2 | 0, 0);
		return super.onBlockPlaced(world, x, y, z, p_149660_5_, p_149660_6_, p_149660_7_, p_149660_8_, p_149660_9_);
	}
}
