package cn.BiochemistryCraft.Register;

import cn.BiochemistryCraft.Entity.EntityDiable;
import cn.BiochemistryCraft.TileEntity.TileentityBioExtracter;
import cn.BiochemistryCraft.client.render.RenderDiable;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.techne.*;



public class BCCEntityRegister {
	
	
	public BCCEntityRegister()
	{
		
	}
	
	public void EntityRegisterInit()
	{
		GameRegistry.registerTileEntity(TileentityBioExtracter.class, "TileentityBioExtracter");
	}

	public void EntityRenderRegisterInit()
	{
		EntityRegistry.registerModEntity(EntityDiable.class, "Le Diable", 500, BiochemistryCraft.instance, 64, 64, true);
		RenderingRegistry.registerEntityRenderingHandler(EntityDiable.class, new RenderDiable(0.5f));
	}
}
