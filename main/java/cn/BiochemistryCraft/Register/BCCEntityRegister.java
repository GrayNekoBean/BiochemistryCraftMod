package cn.BiochemistryCraft.Register;

import net.minecraft.entity.Entity;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Entity.EntityBioPig;
import cn.BiochemistryCraft.Entity.EntityLavaZombie;
import cn.BiochemistryCraft.Entity.EntityLavaZombieBroken;
import cn.BiochemistryCraft.Entity.Throwable.EntityAcid;
import cn.BiochemistryCraft.TileEntity.TileentityBioExtracter;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class BCCEntityRegister {
    
	public void EntityRegisterInit()
	{
		GameRegistry.registerTileEntity(TileentityBioExtracter.class, "TileentityBioExtracter");
		reg2gather(EntityAcid.class, "Acid", 402, 32, 32, true);
		reg2gather(EntityBioPig.class, "BioPig", 403, 64, 1, true, 0x492603, 0x216011);
		reg2gather(EntityLavaZombie.class, "LavaZombie", 501, 64, 1, true, 0x00AFAF, 0x799C65);
		reg2gather(EntityLavaZombieBroken.class, "LavaZombieBroken", 502, 64, 1, true);
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