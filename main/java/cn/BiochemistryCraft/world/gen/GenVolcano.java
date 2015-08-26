package cn.BiochemistryCraft.world.gen;

import java.util.Random;

import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class GenVolcano extends BioGenBase {

	@Override
	protected void generateEnd(World world, Random rand, int chunkX, int chunkZ) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	protected void generateSurface(World world, Random rand, int chunkX,
			int chunkZ) {
		// TODO 自动生成的方法存根
		int h1=world.getHeightValue(chunkX, chunkZ);
		int posX = chunkX + rand.nextInt(64);
    	int posY = rand.nextInt(55);
    	int posZ = chunkZ + rand.nextInt(64);
    	if(world.getBlock(posX, posY, posZ) == BCCRegisterBlock.BlockTephra||world.getBlock(posX, posY, posZ) == BCCRegisterBlock.BlockVolcano){
    		if(rand.nextInt(2)==1){
    			if(h1>80){
    				genCreator(world,posX,posY,posZ);
    			}
    		}
    	}
		
	}

	@Override
	protected void generateNether(World world, Random rand, int chunkX,
			int chunkZ) {
		// TODO 自动生成的方法存根
		
	}

	public void lal(World w,int x,int y,int z){
		for(int i=0;i<y-25;i--){
			w.setBlock(x,y-i,z,Blocks.air);
			
		}
		for(int s=0;s<y-30;s--){
			if(s<25){
				w.setBlock(x,y-s,z, Blocks.lava);
			}
		}
	}
	
	public void genCreator(World w,int x,int y,int z){
		for(int i=0;i<8;i++){
			lal(w,x+i, y, z);
			for(int i1=0;i1>-8;i1--){
				lal(w,x-i1,y,z);

				for(int i2=0;i2<8;i2++){
					lal(w,x, y, z+i2);
					for(int i3=0;i3>-8;i3--){
						lal(w,x,y,z-i3);
						
					}
				}
			}
		}
		
	}
	
	
	
}
