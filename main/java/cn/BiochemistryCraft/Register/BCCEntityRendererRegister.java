package cn.BiochemistryCraft.Register;

import net.minecraft.client.model.ModelPig;
import cn.BiochemistryCraft.Entity.EntityBioPig;
import cn.BiochemistryCraft.Entity.Throwable.EntityAcid;
import cn.BiochemistryCraft.client.render.RenderAcid;
import cn.BiochemistryCraft.client.render.RenderBioPig;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class BCCEntityRendererRegister {
	public void EntityRenderRegisterInit()
	{
//		RenderingRegistry.registerEntityRenderingHandler(EntityDiable.class, new RenderDiable(0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntityAcid.class, new RenderAcid());
		RenderingRegistry.registerEntityRenderingHandler(EntityBioPig.class, new RenderBioPig(new ModelPig(),0.5f));
	}
}
