package cn.BiochemistryCraft.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.techne.TechneModel;

public class RenderDiable extends RenderLiving{

	public static ResourceLocation TextureDiable1;
	public static ResourceLocation TextureDiable2;
	public static ResourceLocation TextureDiable3;
	public static ResourceLocation TextureDiable4;
	public static ResourceLocation TextureDiable5;
	
	public static ResourceLocation diableModelSRC=new ResourceLocation("biomod:models/ModelDiable");
	public static TechneModel diableModel = new TechneModel(diableModelSRC);
	public RenderDiable(float p_i1262_2_) {
		super(diableModel, p_i1262_2_);
		// TODO 自动生成的构造函数存根
	}
	
	

	@Override
	protected ResourceLocation getEntityTexture(Entity e) {
		// TODO 自动生成的方法存根
	switch(e.worldObj.rand.nextInt(5)){
	
	case 1:
		return this.TextureDiable1;
				
	case 2:
		return this.TextureDiable2;
	
	case 3:
		return this.TextureDiable3;
		
	case 4:
		return this.TextureDiable4;
		
	default :
		return this.TextureDiable5;
	
	
	}
	}
}
