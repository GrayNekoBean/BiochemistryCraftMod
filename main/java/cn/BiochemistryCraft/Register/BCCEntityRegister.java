package cn.BiochemistryCraft.Register;

import net.minecraft.entity.Entity;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Entity.EntityBioPig;
import cn.BiochemistryCraft.Entity.EntityLavaZommbie;
import cn.BiochemistryCraft.Entity.Throwable.EntityAcid;
import cn.BiochemistryCraft.TileEntity.TileentityBioExtracter;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class BCCEntityRegister {
    
	public void EntityRegisterInit()
	{
		GameRegistry.registerTileEntity(TileentityBioExtracter.class, "TileentityBioExtracter");
/*//		EntityRegistry.registerGlobalEntityID(EntityDiable.class, "Le_Diable", 500);
		EntityRegistry.registerGlobalEntityID(EntityAcid.class, "Acid", 402);
		EntityRegistry.registerGlobalEntityID(EntityBioPig.class, "BioPig", 403);
		EntityRegistry.registerGlobalEntityID(EntityLavaZommbie.class, "LavaZombie", 501, 44975, 7969893);
//		EntityRegistry.registerModEntity(EntityDiable.class, "Le_Diable", 500, BiochemistryCraft.instance, 64, 64, true);
		EntityRegistry.registerModEntity(EntityAcid.class, "Acid", 402, BiochemistryCraft.instance, 32, 32, true);
		EntityRegistry.registerModEntity(EntityBioPig.class, "BioPig", 403, BiochemistryCraft.instance, 32, 32, true);
		EntityRegistry.registerModEntity(EntityLavaZommbie.class, "LavaZombie", 501, BiochemistryCraft.instance, 64, 64, true);*/
		reg2gather(EntityAcid.class, "Acid", 402, 32, 32, true);
		reg2gather(EntityBioPig.class, "BioPig", 403, 64, 1, true, 0x492603, 0x216011);
		reg2gather(EntityLavaZommbie.class, "LavaZombie", 501, 64, 1, true, 0x00AFAF, 0x799C65);
	}
	public void reg2gather(Class<? extends Entity> cls, String id, int numID, int catchRange, int updateFre, boolean kineticUpdate){
	    EntityRegistry.registerGlobalEntityID(cls, id, numID);
	    EntityRegistry.registerModEntity(cls, id, numID, BiochemistryCraft.instance, catchRange, updateFre, kineticUpdate);
	}
	public void reg2gather(Class<? extends Entity> cls, String id, int numID, int catchRange, int updateFre, boolean kineticUpdate, int bgColor, int frColor){
	    EntityRegistry.registerGlobalEntityID(cls, id, numID, bgColor, frColor);
	    EntityRegistry.registerModEntity(cls, id, numID, BiochemistryCraft.instance, catchRange, updateFre, kineticUpdate);
	}
}