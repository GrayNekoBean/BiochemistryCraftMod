package cn.BiochemistryCraft.Register;

import cn.BiochemistryCraft.world.biome.BiomeVolcano;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class BCCBiomeRegister {
//    public static final BiomeGenBase biobase = new BiomeBioBase(100).setBiomeName("BioBase");
	public static final BiomeVolcano volcano = new BiomeVolcano(100);
    public void registerBiome(){
//	regBiome(biobase);
    	regBiome(volcano, new Type[]{Type.MOUNTAIN,Type.HILLS,Type.HOT});
    }
    public void regBiome(BiomeGenBase biome) {
    	BiomeDictionary.registerBiomeType(biome, new Type[] {});
    }
    
    public void regBiome(BiomeGenBase biome, Type... types) {
    	BiomeDictionary.registerBiomeType(biome, types);
    }
    
    public void regNEutociaBiome(BiomeGenBase biome) {
    	BiomeDictionary.registerBiomeType(biome, new Type[] {});
    	BiomeGenBase.explorationBiomesList.remove(biome);
    }
    
    public void regNEutociaBiome(BiomeGenBase biome, Type... types) {
    	BiomeDictionary.registerBiomeType(biome, types);
    	BiomeGenBase.explorationBiomesList.remove(biome);
    }
}
