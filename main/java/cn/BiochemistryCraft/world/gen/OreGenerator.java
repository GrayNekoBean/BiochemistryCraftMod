package cn.BiochemistryCraft.world.gen;

import java.util.Random;

import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class OreGenerator extends BioGenBase{

	@Override
	protected void generateEnd(World world, Random rand, int chunkX, int chunkZ) {
		// TODO �Զ���ɵķ������
		
	}

	@Override
	protected void generateSurface(World world, Random rand, int chunkX,
			int chunkZ) {
		for(int k = 0; k <= rand.nextInt(8); k++){
        	int posX = chunkX + rand.nextInt(16);
        	int posY = rand.nextInt(36) + 20;
        	int posZ = chunkZ + rand.nextInt(16);
        	
        	(new WorldGenMinable(BCCRegisterBlock.pyrite, 2 + rand.nextInt(7))).generate(world, rand, posX, posY, posZ);
        	(new WorldGenMinable(BCCRegisterBlock.sulfurore, 2 + rand.nextInt(7))).generate(world, rand, posX, posY, posZ);
        }
		
	}

	@Override
	protected void generateNether(World world, Random rand, int chunkX,
			int chunkZ) {
		// TODO �Զ���ɵķ������
		
	}

}
