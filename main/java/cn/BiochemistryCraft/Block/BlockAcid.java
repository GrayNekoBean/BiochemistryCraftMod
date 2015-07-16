package cn.BiochemistryCraft.Block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockAcid extends Block{

	IIcon icon1;
	IIcon icon2;
	public BlockAcid(Material m) {
		super(m);
		// TODO 自动生成的构造函数存根
		this.setBlockName("Acid");
		this.setCreativeTab(BiochemistryCraft.biocreativetab);
		this.setHarvestLevel("shavel", 3);
		this.setStepSound(Block.soundTypeWood);
		this.setHardness(2F);
		this.setBlockBounds(0F, 0F,0F, 1F, 0.25F,1F);
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int number, int p_149691_2_)
    {
        if(number==0 || number==1)
        	return icon2;
        else
        	return icon1;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.icon1 = p_149651_1_.registerIcon("biomod:AcidRound");
        this.icon2 = p_149651_1_.registerIcon("biomod:AcidTb");
    }
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        float f = 0.1F;
        return AxisAlignedBB.getBoundingBox((double)p_149668_2_, (double)p_149668_3_, (double)p_149668_4_, (double)(p_149668_2_ + 1), (double)((float)(p_149668_3_ + 1) - f), (double)(p_149668_4_ + 1));
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World w, int x, int y, int z, Entity entity)
    {
    	entity.motionX *= 0.4D;
    	entity.motionZ *= 0.4D;
        entity.attackEntityFrom(DamageSource.cactus, 0.5F);
    }
	
}
