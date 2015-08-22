package cn.BiochemistryCraft.Register;

import cn.BiochemistryCraft.Entity.EntityBioPig;

import cn.BiochemistryCraft.Entity.Throwable.EntityAcid;
import cn.BiochemistryCraft.TileEntity.TileentityBioExtracter;
import cn.BiochemistryCraft.client.render.RenderAcid;
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
		
		EntityRegistry.registerModEntity(EntityAcid.class, "EntityAcid", 2, BiochemistryCraft.instance, 32, 32, true);
		EntityRegistry.registerModEntity(EntityBioPig.class, "EntityBioPig", 3, BiochemistryCraft.instance, 32, 32, true);
	}

	public void EntityRenderRegisterInit()
	{
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityAcid.class, new RenderAcid());
		RenderingRegistry.registerEntityRenderingHandler(EntityBioPig.class, new RenderBioPig(new ModelPig(),0.5f));
	}

}
