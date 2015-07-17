package cn.BiochemistryCraft.event;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class EventBonemeal {
	@SubscribeEvent
    public void onBonemeal(BonemealEvent event){
		EntityPlayer player = event.entityPlayer;
	    World world = event.world;
	    Random rand = world.rand;
	    Block block = event.block;
	    int posX = event.x;
	    int posY = event.y;
	    int posZ = event.z;
	    int metadata = world.getBlockMetadata(posX, posY, posZ);
	    for(int i = 0; i <= 1; i++){
	    	if (block == BCCRegisterBlock.herbsCorpArray[i]){
				if (!world.isRemote){
					if(rand.nextInt(4) > 2 && metadata < 1){
						world.setBlockMetadataWithNotify(posX, posY, posZ, 1, 2);
					}
				}
				event.setResult(Result.ALLOW);
			}
	    }
		
    }
}
