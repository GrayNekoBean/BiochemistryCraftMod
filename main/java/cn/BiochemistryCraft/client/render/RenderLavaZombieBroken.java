package cn.BiochemistryCraft.client.render;

import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderLavaZombieBroken extends RenderBiped{
	public RenderLavaZombieBroken(ModelBiped m, float f,float f2) {
		super(m,f,f2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity e) {
		return new ResourceLocation(BiochemistryCraft.MODID,"textures/entity/lavazombie/zombie.png");
	}

}
