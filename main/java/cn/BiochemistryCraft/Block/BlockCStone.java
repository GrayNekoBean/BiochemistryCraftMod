package cn.BiochemistryCraft.Block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCStone {
	public static class Full extends Block{
		public Full() {
			super(Material.rock);
			setBlockName("CStone");
			setBlockTextureName(BiochemistryCraft.MODID + ":CStone");
			setCreativeTab(BiochemistryCraft.biocreativetab);
			setHardness(1.0F).setResistance(5.0F);
		}
	}
	public static class Slab extends BlockSlab{
	    @SideOnly(Side.CLIENT)
	    private IIcon field_150007_M;

	    public Slab(boolean p_i45431_1_)
	    {
	        super(p_i45431_1_, Material.rock);
			setBlockName("CStoneSlab");
			setCreativeTab(BiochemistryCraft.biocreativetab);
			setHardness(1.0F).setResistance(5.0F);
	    }

	    /**
	     * Gets the block's texture. Args: side, meta
	     */
	    @SideOnly(Side.CLIENT)
	    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	    {
	        if (this.field_150004_a && (p_149691_2_ & 8) != 0)
	        {
	            p_149691_1_ = 1;
	        }

	        return (p_149691_1_ != 1 && p_149691_1_ != 0 ? this.field_150007_M : this.blockIcon);
	    }

	    @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister p_149651_1_)
	    {
	        this.blockIcon = p_149651_1_.registerIcon(BiochemistryCraft.MODID + ":CStone");
	        this.field_150007_M = p_149651_1_.registerIcon(BiochemistryCraft.MODID + ":CStone");
	    }

	    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	    {
	        return Item.getItemFromBlock(BCCRegisterBlock.cStoneSlab);
	    }

	    /**
	     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
	     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
	     */
	    protected ItemStack createStackedBlock(int p_149644_1_)
	    {
	        return new ItemStack(Item.getItemFromBlock(BCCRegisterBlock.cStoneSlab), 2, p_149644_1_ & 7);
	    }

	    public String func_150002_b(int p_150002_1_)
	    {
	        return super.getUnlocalizedName();
	    }

	}
	public static class Stair extends BlockStairs{
		public Stair () {
			super(BCCRegisterBlock.corrodedStone, 0);
			setBlockName("CStoneStair");
			setCreativeTab(BiochemistryCraft.biocreativetab);
		}
	}
}
