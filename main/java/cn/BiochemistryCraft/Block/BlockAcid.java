package cn.BiochemistryCraft.Block;

import java.util.Random;
import java.util.Timer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cn.BiochemistryCraft.BCCDamageSource;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import cn.BiochemistryCraft.core.BCCConfig;
import cn.BiochemistryCraft.core.BCCLogger;
import cn.BiochemistryCraft.core.sick.SickCold;
import cn.BiochemistryCraft.network.PacketMain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
	        this.setTickRandomly(true);
	}
	    public int tickRate(World p_149738_1_)
	    {
	        return 30;
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
        float f = 0.25F;
        return AxisAlignedBB.getBoundingBox((double)p_149668_2_, (double)p_149668_3_, (double)p_149668_4_, (double)(p_149668_2_ + 1), (double)((float)(p_149668_3_ + f)), (double)(p_149668_4_ + 1));
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World w, int x, int y, int z, Entity entity)
    {
    	entity.motionX *= 0.4D;
    	entity.motionZ *= 0.4D;
        entity.attackEntityFrom(BCCDamageSource.acid, 0.5F);
        if(entity instanceof EntityLivingBase)
        {
	        Timer t=new Timer();
	        SickCold s=new SickCold();
	        s.SetEntity((EntityLivingBase) entity);
	        t.schedule(new SickCold(), 1000);
        }
    }
    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
		super.onNeighborBlockChange(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
		Block under = p_149695_1_.getBlock(p_149695_2_, p_149695_3_ - 1, p_149695_4_);
		if(!under.getMaterial().isSolid()){
		    p_149695_1_.setBlockToAir(p_149695_2_, p_149695_3_, p_149695_4_);
		}
    }
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
    	if(BCCConfig.canAcidCorrode()){
    	Block under = p_149674_1_.getBlock(p_149674_2_, p_149674_3_ - 1, p_149674_4_);
    	if (under.getMaterial() == Material.rock) {
    		if(under == BCCRegisterBlock.corrodedStone){
    			p_149674_1_.setBlockToAir(p_149674_2_, p_149674_3_ - 1, p_149674_4_);
    		}
    		else
    			p_149674_1_.setBlock(p_149674_2_, p_149674_3_ - 1, p_149674_4_, BCCRegisterBlock.corrodedStone);
    	}
    	if (under.getMaterial() == Material.ground || under.getMaterial() == Material.grass) {
    		p_149674_1_.setBlock(p_149674_2_, p_149674_3_ - 1, p_149674_4_, BCCRegisterBlock.acidicDirt);
    	}
    	}
    }
    public static class FluidAcid extends BlockFluidClassic{
    	@SideOnly(Side.CLIENT)
    	protected IIcon stillIcon;
    	@SideOnly(Side.CLIENT)
    	protected IIcon flowingIcon;
		float s = 0,s1 = 0,s2 = 0,s3 = 0,s4 = 0;
    	public FluidAcid(Fluid fluid, Material material) {
			super(fluid, material);
	        setCreativeTab(BiochemistryCraft.biocreativetab);
		}
        @Override
        public IIcon getIcon(int side, int meta) {
                return (side == 0 || side == 1)? stillIcon : flowingIcon;
        }
        @SideOnly(Side.CLIENT)
        @Override
        public void registerBlockIcons(IIconRegister register) {
                stillIcon = register.registerIcon(BiochemistryCraft.MODID + ":acid_still");
                flowingIcon = register.registerIcon(BiochemistryCraft.MODID + ":acid_flow");
        }
        public void onEntityCollidedWithBlock(World w, int x, int y, int z, Entity entity)
        {
            entity.attackEntityFrom(BCCDamageSource.acid, 0.5F);
            if(entity instanceof EntityLivingBase)
            {
    	        Timer t=new Timer();
    	        SickCold s=new SickCold();
    	        s.SetEntity((EntityLivingBase) entity);
    	        t.schedule(new SickCold(), 1000);
            }
        }
        @Override
        public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
                if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
                return super.canDisplace(world, x, y, z);
        }
        
        @Override
        public boolean displaceIfPossible(World world, int x, int y, int z) {
                if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
                return super.displaceIfPossible(world, x, y, z);
        }
	    @Override
	    public void updateTick(World world, int x, int y, int z, Random rand)
	    {
	    	super.updateTick(world, x, y, z, rand);
	    	if(BCCConfig.canAcidCorrode()){
	    		Block under = world.getBlock(x, y - 1, z);
	    		Block b1 = world.getBlock(x + 1, y, z);
	    		Block b2 = world.getBlock(x - 1, y, z);
	    		Block b3 = world.getBlock(x, y, z + 1);
	    		Block b4 = world.getBlock(x, y, z - 1);
	    		if(rand.nextInt(100) >= BCCConfig.getCCBase()){	    		
	    			if (isCorrodibleRock(under)) {
	    				corrodePlz(world, under, x, y - 1, z);
	    			}
	    			if (isAcidibleDirt(under)) {
	    				world.setBlock(x, y - 1, z, BCCRegisterBlock.acidicDirt);
	    			}
	    		}
	    		if(rand.nextInt(100) >= BCCConfig.getCCBase()){
	    			if (isCorrodibleRock(b1)) {
	    				corrodePlz(world, b1, x + 1, y, z);
	    			}
	    			if (isAcidibleDirt(b1)) {
	    				world.setBlock(x + 1, y, z, BCCRegisterBlock.acidicDirt);
	    			}
	    		}
	    		if(rand.nextInt(100) >= BCCConfig.getCCBase()){
	    			if (isCorrodibleRock(b2)) {
	    				corrodePlz(world, b2, x - 1, y, z);
	    			}
	    			if (isAcidibleDirt(b2)) {
	    				world.setBlock(x - 1, y, z, BCCRegisterBlock.acidicDirt);
	    			}
	    		}
	    		
	    		if(rand.nextInt(100) >= BCCConfig.getCCBase()){
	    			if (isCorrodibleRock(b3)) {
	    				corrodePlz(world, b3, x, y, z + 1);
	    			}
	    			if (isAcidibleDirt(b3)) {
	    				world.setBlock(x, y, z + 1, BCCRegisterBlock.acidicDirt);
	    			}
	    		}
	    	
	    		if(rand.nextInt(100) >= BCCConfig.getCCBase()){
	    			if (isCorrodibleRock(b4)) {
	    				corrodePlz(world, b4, x, y, z - 1);
	    			}
	    			if (isAcidibleDirt(b4)) {
	    				world.setBlock(x, y, z - 1, BCCRegisterBlock.acidicDirt);
	    			}
	    		}
	    	}
	    }

	    private boolean isCorrodibleRock(Block bk){
	    	return bk.getMaterial() == Material.rock && bk != Blocks.bedrock && bk != Blocks.obsidian;
	    }
	    
	    private boolean isAcidibleDirt(Block bk){
	    	return bk.getMaterial() == Material.ground || bk.getMaterial() == Material.grass;
	    }
	    private void corrodePlz(World world, Block bk, int x, int y, int z){
	    	int meta = world.getBlockMetadata(x, y, z);
	    	if(bk instanceof Block){
	    		world.setBlock(x, y, z, BCCRegisterBlock.corrodedStone);
	    	}
	    	if(bk instanceof BlockSlab){
	    		if(((BlockSlab)bk).renderAsNormalBlock()){
		    		world.setBlock(x, y, z, BCCRegisterBlock.cStoneDoubleSlab);	
	    		}
	    		if(!((BlockSlab)bk).renderAsNormalBlock()){
		    		world.setBlock(x, y, z, BCCRegisterBlock.cStoneSlab, meta, 3);	
	    		}
	    	}
	    	if(bk instanceof BlockStairs){
	    		world.setBlock(x, y, z, BCCRegisterBlock.cStoneStair, meta, 3);
	    	}
	    	if(bk == BCCRegisterBlock.corrodedStone || bk == BCCRegisterBlock.cStoneSlab || bk == BCCRegisterBlock.cStoneDoubleSlab || bk == BCCRegisterBlock.cStoneStair){
	    		world.setBlockToAir(x, y, z);
	    	}
	    }
	    
        }

}
