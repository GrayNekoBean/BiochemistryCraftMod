package cn.BiochemistryCraft.Register;

import cn.BiochemistryCraft.Entity.EntityBioPig;
import cn.BiochemistryCraft.Entity.EntityDiable;
import cn.BiochemistryCraft.Entity.Throwable.EntityAcid;
import cn.BiochemistryCraft.TileEntity.TileentityBioExtracter;
import cn.BiochemistryCraft.client.render.RenderBioPig;
import cn.BiochemistryCraft.client.render.RenderDiable;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.client.model.ModelPig;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.techne.*;



public class BCCEntityRegister {
	
	
	public BCCEntityRegister()
	{
		
	}
	
	public void EntityRegisterInit()
	{
		GameRegistry.registerTileEntity(TileentityBioExtracter.class, "TileentityBioExtracter");
		EntityRegistry.registerGlobalEntityID(EntityDiable.class, "Le_Diable", 500);
		EntityRegistry.registerModEntity(EntityDiable.class, "Le_Diable", 500, BiochemistryCraft.instance, 64, 64, true);
		EntityRegistry.registerGlobalEntityID(EntityAcid.class, "Acid", 402);
		EntityRegistry.registerModEntity(EntityAcid.class, "Acid", 402, BiochemistryCraft.instance, 32, 32, true);
		EntityRegistry.registerGlobalEntityID(EntityBioPig.class, "BioPig", 403);
		EntityRegistry.registerModEntity(EntityBioPig.class, "BioPig", 403, BiochemistryCraft.instance, 32, 32, true);
	}

	public void EntityRenderRegisterInit()
	{
		
		RenderingRegistry.registerEntityRenderingHandler(EntityDiable.class, new RenderDiable(0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntityBioPig.class, new RenderBioPig(new ModelPig(),0.5f));
	}

}
