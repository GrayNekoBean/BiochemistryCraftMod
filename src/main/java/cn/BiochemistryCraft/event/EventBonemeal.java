package cn.BiochemistryCraft.event;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cn.BiochemistryCraft.Block.BlockTreeFruit;
import cn.BiochemistryCraft.Block.BlockTreeFruitSapling;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventBonemeal {
	@SubscribeEvent
    public void onBonemeal(BonemealEvent event){
		World world = event.world;
	    Random rand = world.rand;
	    Block block = event.block;
	    int posX = event.x;
	    int posY = event.y;
	    int posZ = event.z;
	    int metadata = world.getBlockMetadata(posX, posY, posZ);
	    for(int i = 0; i <= 2; i++){
	    	if (block == BCCRegisterBlock.herbsCorpArray[i]){
				if (!world.isRemote){
					if(rand.nextInt(5) <= 2 && metadata < 1){
						world.setBlockMetadataWithNotify(posX, posY, posZ, 1, 2);
					}
				}
				event.setResult(Result.ALLOW);
			}
	    }
	    if (block == BCCRegisterBlock.treeFruitBlock){
			if (!world.isRemote){
				((BlockTreeFruit)block).dropBlockAsItem(world, posX, posY, posZ);
			}
			event.setResult(Result.ALLOW);
		}
	    if (block == BCCRegisterBlock.treeFruitSaplingBlock){
			if (!world.isRemote){
				if(rand.nextInt(4) == 0){
					((BlockTreeFruitSapling)BCCRegisterBlock.treeFruitSaplingBlock).treeGene(world, posX, posY, posZ, rand);
				}
			}
			event.setResult(Result.ALLOW);
		}
	    if (block == BCCRegisterBlock.treeFruitLeave){
	    	if (!world.isAirBlock(posX, posY - 1, posZ)){
				event.setResult(Result.DENY);
			}else if (!world.isRemote){
				if(rand.nextInt(7) <= 2){
					world.setBlock(posX, posY - 1, posZ, BCCRegisterBlock.treeFruitBlock);
					world.setBlockMetadataWithNotify(posX, posY - 1, posZ, 1 << 2 | rand.nextInt(4), 2);
				}
				event.setResult(Result.ALLOW);
			}
		}
	    if (block == BCCRegisterBlock.goldenVine){
			if (!world.isRemote){
		    	int md = metadata >> 2;
				if(rand.nextInt(6) == 0){
					world.setBlockMetadataWithNotify(posX, posY, posZ, md << 2 | 1, 0);
				}
				world.setBlockMetadataWithNotify(posX, posY, posZ, md << 2 | 1, 0);
				event.setResult(Result.ALLOW);
			}
		}
	    if (block == BCCRegisterBlock.gracilariaCorp){
			if (!world.isRemote){
				if(rand.nextInt(7) <= 2){
					metadata++;
					if(metadata < 0 || metadata > 2){
						metadata = 2;
					}
					world.setBlockMetadataWithNotify(posX, posY, posZ, metadata, 2);
				}
			}
			event.setResult(Result.ALLOW);
		}
    }
}
