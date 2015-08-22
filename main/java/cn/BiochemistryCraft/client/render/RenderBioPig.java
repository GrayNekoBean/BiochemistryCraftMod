package cn.BiochemistryCraft.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBioPig extends RenderLiving{

	private static final ResourceLocation texture = new ResourceLocation("biomod:textures/entity/BioPig.png");
	public RenderBioPig(ModelBase m, float f) {
		super(m, f);
		// TODO 自动生成的构造函数存根
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		// TODO 自动生成的方法存根
		return texture;
	}

}
