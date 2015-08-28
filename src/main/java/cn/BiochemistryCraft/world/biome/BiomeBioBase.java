package cn.BiochemistryCraft.world.biome;

import net.minecraft.world.biome.BiomeGenBase;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;

public abstract class BiomeBioBase extends BiomeGenBase{
    public static int biomeID;
    public BiomeBioBase(){
    	this(biomeID);
    }
	public BiomeBioBase(int arg0) {
		super(arg0);
		this.topBlock = BCCRegisterBlock.biodirt;
		this.fillerBlock = BCCRegisterBlock.biodirt;
		this.rootHeight = height_Default.rootHeight;
		this.heightVariation = height_Default.variation;
	    this.temperature = 0.5F;
	    this.rainfall = 0.5F;
	}
}