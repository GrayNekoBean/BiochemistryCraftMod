package cn.BiochemistryCraft.world.biome;

import cn.BiochemistryCraft.Register.BCCRegisterBlock;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenHills;

public class BiomeVolcano extends BiomeGenHills{

	public static BiomeGenBase.Height Height_volcano=new BiomeGenBase.Height(1.5f,0.5f);
	
	
	public BiomeVolcano(int p_i1971_1_) {
		super(p_i1971_1_, false);
		this.topBlock=BCCRegisterBlock.BlockTephra;
		this.fillerBlock=BCCRegisterBlock.BlockVolcano;
		this.temperature=1.5f;
		this.rainfall=0.0f;
		this.color=	0x999900;
		// TODO 自动生成的构造函数存根
	}

}