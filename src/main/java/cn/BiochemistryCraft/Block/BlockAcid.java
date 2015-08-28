package cn.BiochemistryCraft.Block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import cn.BiochemistryCraft.BCCDamageSource;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import cn.BiochemistryCraft.core.BCCConfig;
import cn.BiochemistryCraft.core.sick.SickTrigger;
import cn.BiochemistryCraft.core.sick.TriggerType;

public class BlockAcid extends BlockFluidClassic{
		float s = 0,s1 = 0,s2 = 0,s3 = 0,s4 = 0;
    	public BlockAcid(Fluid fluid, Material material) {
			super(fluid, material);
	        setCreativeTab(BiochemistryCraft.biocreativetab);
		}
/*        @SideOnly(Side.CLIENT)
        @Override
        public void registerBlockIcons(IIconRegister register) {
                stillIcon = register.registerIcon(BiochemistryCraft.MODID + ":acid_still");
                flowingIcon = register.registerIcon(BiochemistryCraft.MODID + ":acid_flow");
        }*/
        public void onEntityCollidedWithBlock(World w, BlockPos pos, IBlockState state, Entity entity)
        {
            entity.attackEntityFrom(BCCDamageSource.acid, 0.5F);
            if(entity instanceof EntityLivingBase)
            {
            	SickTrigger.trigger(TriggerType.COLLIDE_BLOCK, state.getBlock(), (EntityLivingBase)entity);
            }
        }
        @Override
        public boolean canDisplace(IBlockAccess world, BlockPos pos) {
                if (world.getBlockState(pos).getBlock().getMaterial().isLiquid()) return false;
                return super.canDisplace(world, pos);
        }
        
        @Override
        public boolean displaceIfPossible(World world, BlockPos pos) {
                if (world.getBlockState(pos).getBlock().getMaterial().isLiquid()) return false;
                return super.displaceIfPossible(world, pos);
        }
	    @Override
	    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	    {
	    	super.updateTick(world, pos, state, rand);
	    	if(BCCConfig.canAcidCorrode()){
	    		Block under = world.getBlockState(pos.add(0, -1, 0)).getBlock();
	    		Block b1 = world.getBlockState(pos.add(1, 0, 0)).getBlock();
	    		Block b2 = world.getBlockState(pos.add(-1, 0, 0)).getBlock();
	    		Block b3 = world.getBlockState(pos.add(0, 0, 1)).getBlock();
	    		Block b4 = world.getBlockState(pos.add(0, 0, -1)).getBlock();
	    		if(rand.nextInt(100) >= BCCConfig.getCCBase()){
	    			if (isCorrodibleRock(under)) {
	    				corrodePlz(world, under, pos.add(0, -1, 0));
	    			}
	    			if (isAcidibleDirt(under)) {
	    				world.setBlockState(pos.add(0, -1, 0), BCCRegisterBlock.acidicDirt.getDefaultState());
	    			}
	    		}
	    		if(rand.nextInt(100) >= BCCConfig.getCCBase()){
	    			if (isCorrodibleRock(b1)) {
	    				corrodePlz(world, b1, pos.add(1, 0, 0));
	    			}
	    			if (isAcidibleDirt(b1)) {
	    				world.setBlockState(pos.add(1, 0, 0), BCCRegisterBlock.acidicDirt.getDefaultState());
	    			}
	    		}
	    		if(rand.nextInt(100) >= BCCConfig.getCCBase()){
	    			if (isCorrodibleRock(b2)) {
	    				corrodePlz(world, b2, pos.add(1, 0, 0));
	    			}
	    			if (isAcidibleDirt(b2)) {
	    				world.setBlockState(pos.add(1, 0, 0), BCCRegisterBlock.acidicDirt.getDefaultState());
	    			}
	    		}
	    		
	    		if(rand.nextInt(100) >= BCCConfig.getCCBase()){
	    			if (isCorrodibleRock(b3)) {
	    				corrodePlz(world, b3, pos.add(0, 0, 1));
	    			}
	    			if (isAcidibleDirt(b3)) {
	    				world.setBlockState(pos.add(0, 0, 1), BCCRegisterBlock.acidicDirt.getDefaultState());
	    			}
	    		}
	    	
	    		if(rand.nextInt(100) >= BCCConfig.getCCBase()){
	    			if (isCorrodibleRock(b4)) {
	    				corrodePlz(world, b4, pos.add(0, 0, -1));
	    			}
	    			if (isAcidibleDirt(b4)) {
	    				world.setBlockState(pos.add(0, 0, -1), BCCRegisterBlock.acidicDirt.getDefaultState());
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
	    private void corrodePlz(World world, Block bk, BlockPos pos){
	    	IBlockState state = world.getBlockState(pos);
	    	if(bk instanceof Block){
	    		world.setBlockState(pos, BCCRegisterBlock.corrodedStone.getDefaultState());
	    	}
	    	if(bk instanceof BlockSlab){
	    		if(((BlockSlab)bk).isDouble()){
		    		world.setBlockState(pos, BCCRegisterBlock.cStoneDoubleSlab.getDefaultState());	
	    		}
	    		if(!((BlockSlab)bk).isDouble()){
		    		world.setBlockState(pos, BCCRegisterBlock.cStoneSlab.getActualState(state, world, pos), 3);	
	    		}
	    	}
	    	if(bk instanceof BlockStairs){
	    		world.setBlockState(pos, BCCRegisterBlock.cStoneStair.getActualState(state, world, pos), 3);
	    	}
	    	if(bk == BCCRegisterBlock.corrodedStone || bk == BCCRegisterBlock.cStoneSlab || bk == BCCRegisterBlock.cStoneDoubleSlab || bk == BCCRegisterBlock.cStoneStair){
	    		world.setBlockToAir(pos);
	    	}
	    }
	    
        }