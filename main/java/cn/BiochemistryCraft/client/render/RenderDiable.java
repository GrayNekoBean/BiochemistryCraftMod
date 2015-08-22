package cn.BiochemistryCraft.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.techne.TechneModel;

public class RenderDiable extends RenderLiving{

	public static ResourceLocation TextureDiable1=new ResourceLocation("biomod:diable");
	public static ResourceLocation TextureDiable2;
	public static ResourceLocation TextureDiable3;
	public static ResourceLocation TextureDiable4;
	public static ResourceLocation TextureDiable5;
	
	public static ResourceLocation diableModelSRC=new ResourceLocation("biomod:textures/models/ModelDiable.tcn");
	public static TechneModel diableModel = new TechneModel(diableModelSRC);
	public RenderDiable(float p_i1262_2_) {
		super(diableModel, p_i1262_2_);
		// TODO 自动生成的构造函数存根
	}
	
	

	@Override
	protected ResourceLocation getEntityTexture(Entity e) {
		// TODO 自动生成的方法存根
		return this.diableModelSRC;
	
	
	}
}
