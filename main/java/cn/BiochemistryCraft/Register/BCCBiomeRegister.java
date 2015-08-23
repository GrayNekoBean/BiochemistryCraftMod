package cn.BiochemistryCraft.Register;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

public class BCCBiomeRegister {
//    public static final BiomeGenBase biobase = new BiomeBioBase(100).setBiomeName("BioBase");
    public void registerBiome(){
//	regBiome(biobase);
    }
    public void regBiome(BiomeGenBase biome) {
	BiomeDictionary.registerBiomeType(biome, new BiomeDictionary.Type[] {});
    }
    
    public void regBiome(BiomeGenBase biome, BiomeDictionary.Type... types) {
	BiomeDictionary.registerBiomeType(biome, types);
    }
}
