package cn.BiochemistryCraft.client.render;

import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Entity.EntityLavaZombie;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderLavaZombie extends RenderBiped {

	public RenderLavaZombie(ModelBiped m, float f,float f2) {
		super(m,f,f2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity e) {
		return new ResourceLocation(BiochemistryCraft.MODID,"textures/entity/lavazombie/reszombie.png");
	}

}
