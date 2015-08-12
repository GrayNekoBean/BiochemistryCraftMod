package cn.BiochemistryCraft.Block;

import java.util.Random;
import java.util.Timer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cn.BiochemistryCraft.BCCDamageSource;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import cn.BiochemistryCraft.core.sick.SickCold;
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
        public static class FluidAcid extends BlockFluidClassic{
        @SideOnly(Side.CLIENT)
        protected IIcon stillIcon;
        @SideOnly(Side.CLIENT)
        protected IIcon flowingIcon;
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
	    	this.oldUpdateTick(world, x, y, z, rand);
	    	Block under = world.getBlock(x, y - 1, z);
	    	Block b1 = world.getBlock(x + 1, y, z);
	    	Block b2 = world.getBlock(x - 1, y, z);
	    	Block b3 = world.getBlock(x, y, z + 1);
	    	Block b4 = world.getBlock(x, y, z - 1);
	    	if(rand.nextInt(100) >= 80){
	    		
		    if (under.getMaterial() == Material.rock && under != Blocks.bedrock) {
			if(under == BCCRegisterBlock.corrodedStone){
				world.setBlockToAir(x, y - 1, z);
			}
			else
				world.setBlock(x, y - 1, z, BCCRegisterBlock.corrodedStone);
		    }
		    if (under.getMaterial() == Material.ground || under.getMaterial() == Material.grass) {
		    	world.setBlock(x, y - 1, z, BCCRegisterBlock.acidicDirt);
		    }
	    	}
	    	if(rand.nextInt(100) >= 80){
		    if (b1.getMaterial() == Material.rock && b1 != Blocks.bedrock) {
				if(b1 == BCCRegisterBlock.corrodedStone){
					world.setBlockToAir(x + 1, y, z);
				}
				else
					world.setBlock(x + 1, y, z, BCCRegisterBlock.corrodedStone);
			    }
			    if (b1.getMaterial() == Material.ground || b1.getMaterial() == Material.grass) {
			    	world.setBlock(x + 1, y, z, BCCRegisterBlock.acidicDirt);
			    }
	    	}
	    	if(rand.nextInt(100) >= 80){
		    if (b2.getMaterial() == Material.rock && b2 != Blocks.bedrock) {
			if(b2 == BCCRegisterBlock.corrodedStone){
				world.setBlockToAir(x - 1, y, z);
			}
			else
				world.setBlock(x - 1, y, z, BCCRegisterBlock.corrodedStone);
		    }
		    if (b2.getMaterial() == Material.ground || b2.getMaterial() == Material.grass) {
		    	world.setBlock(x - 1, y, z, BCCRegisterBlock.acidicDirt);
		    }
	    	}
	    	
	    	if(rand.nextInt(100) >= 80){
		    if (b3.getMaterial() == Material.rock && b3 != Blocks.bedrock) {
			if(b3 == BCCRegisterBlock.corrodedStone){
				world.setBlockToAir(x, y, z + 1);
			}
			else
				world.setBlock(x, y, z + 1, BCCRegisterBlock.corrodedStone);
		    }
		    if (b3.getMaterial() == Material.ground || b3.getMaterial() == Material.grass) {
		    	world.setBlock(x, y, z + 1, BCCRegisterBlock.acidicDirt);
		    }
	    	}
	    	
	    	if(rand.nextInt(100) >= 80){
		    if (b4.getMaterial() == Material.rock && b4 != Blocks.bedrock) {
			if(b4 == BCCRegisterBlock.corrodedStone){
				world.setBlockToAir(x, y, z - 1);
			}
			else
				world.setBlock(x, y, z - 1, BCCRegisterBlock.corrodedStone);
		    }
		    if (b4.getMaterial() == Material.ground || b4.getMaterial() == Material.grass) {
		    	world.setBlock(x, y, z - 1, BCCRegisterBlock.acidicDirt);
		    }
	    	}
	    }
	    private void oldUpdateTick(World world, int x, int y, int z, Random rand){
	        int quantaRemaining = quantaPerBlock - world.getBlockMetadata(x, y, z);
	        int expQuanta = -101;
	        int eva = 1;

	        // check adjacent block levels if non-source
	        if (quantaRemaining < quantaPerBlock)
	        {
	            int y2 = y - densityDir;

	            if (world.getBlock(x,     y2, z    ) == this ||
	                world.getBlock(x - 1, y2, z    ) == this ||
	                world.getBlock(x + 1, y2, z    ) == this ||
	                world.getBlock(x,     y2, z - 1) == this ||
	                world.getBlock(x,     y2, z + 1) == this)
	            {
	                expQuanta = quantaPerBlock - 1;
	            }
	            else
	            {
	                int maxQuanta = -100;
	                maxQuanta = getLargerQuanta(world, x - 1, y, z,     maxQuanta);
	                maxQuanta = getLargerQuanta(world, x + 1, y, z,     maxQuanta);
	                maxQuanta = getLargerQuanta(world, x,     y, z - 1, maxQuanta);
	                maxQuanta = getLargerQuanta(world, x,     y, z + 1, maxQuanta);

	                expQuanta = maxQuanta - 1;
	            }

	            // decay calculation
	            if (expQuanta != quantaRemaining)
	            {
	                quantaRemaining = expQuanta;

	                if (expQuanta <= 0)
	                {
	                    world.setBlock(x, y, z, Blocks.air);
	                }
	                else
	                {
	                    world.setBlockMetadataWithNotify(x, y, z, quantaPerBlock - expQuanta + eva, 3);
	                    world.scheduleBlockUpdate(x, y, z, this, tickRate);
	                    world.notifyBlocksOfNeighborChange(x, y, z, this);
	                }
	            }
	        }
	        // This is a "source" block, set meta to zero, and send a server only update
	        else if (quantaRemaining >= quantaPerBlock)
	        {
	            world.setBlockMetadataWithNotify(x, y, z, 0, 2);
	        }

	        // Flow vertically if possible
	        if (canDisplace(world, x, y + densityDir, z))
	        {
	            flowIntoBlock(world, x, y + densityDir, z, 1);
	            return;
	        }

	        // Flow outward if possible
	        int flowMeta = quantaPerBlock - quantaRemaining + 1;
	        if (flowMeta >= quantaPerBlock)
	        {
	            return;
	        }

	        if (isSourceBlock(world, x, y, z) || !isFlowingVertically(world, x, y, z))
	        {
	            if (world.getBlock(x, y - densityDir, z) == this)
	            {
	                flowMeta = 1;
	            }
	            boolean flowTo[] = getOptimalFlowDirections(world, x, y, z);

	            if (flowTo[0]) flowIntoBlock(world, x - 1, y, z,     flowMeta + eva);
	            if (flowTo[1]) flowIntoBlock(world, x + 1, y, z,     flowMeta + eva);
	            if (flowTo[2]) flowIntoBlock(world, x,     y, z - 1, flowMeta + eva);
	            if (flowTo[3]) flowIntoBlock(world, x,     y, z + 1, flowMeta + eva);
	        }
	    }
    }

}
