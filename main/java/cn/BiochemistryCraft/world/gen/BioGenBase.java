package cn.BiochemistryCraft.world.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public abstract class BioGenBase implements IWorldGenerator {
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1:
            generateNether(world, rand, chunkX * 16, chunkZ * 16);
            break;
        case 0:
            generateSurface(world, rand, chunkX * 16, chunkZ * 16);
            break;
        case 1:
            generateEnd(world, rand, chunkX * 16, chunkZ * 16);
            break;
		}
	}
	
	protected abstract void generateEnd(World world, Random rand, int chunkX, int chunkZ);

	protected abstract void generateSurface(World world, Random rand, int chunkX, int chunkZ);

	protected abstract void generateNether(World world, Random rand, int chunkX, int chunkZ);
}
