package cn.BiochemistryCraft.Register;

import cn.BiochemistryCraft.TileEntity.TileentityBioExtracter;
import cpw.mods.fml.common.registry.GameRegistry;

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
				
	}
}
