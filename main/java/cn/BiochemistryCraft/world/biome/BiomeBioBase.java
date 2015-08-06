package cn.BiochemistryCraft.world.biome;

import sun.security.jca.GetInstance;
import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeBioBase extends BiomeGenBase{
    private static final BiomeBioBase INSTANCE = new BiomeBioBase();
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
	        this.waterColorMultiplier = 0xffffff / 2;
	}
	
	public static BiomeBioBase getInstance(){
	    return INSTANCE;
	}
}
