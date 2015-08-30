package cn.BiochemistryCraft.client.render;

import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderLavaZombieBroken extends RenderBiped{
	public RenderLavaZombieBroken(ModelBiped m, float f,float f2) {
		super(m,f,f2);
		// TODO 鑷姩鐢熸垚鐨勬瀯閫犲嚱鏁板瓨鏍�
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity e) {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		return new ResourceLocation(BiochemistryCraft.MODID,"textures/entity/LavaZombieBroken.png");
			
	}
	
	//protected ResourceLocation getThisEntityTexture(EntityLavaZombie entity){
	//	if(entity.protecting==(byte)1){
	//		return new ResourceLocation(BiochemistryCraft.MODID,"textures/entity/LavaZombie.png");
	//	}
	//	else{
	//		return new ResourceLocation(BiochemistryCraft.MODID,"textures/entity/LavaZombieBroken.png");
	//	}
	//	
	//}
}
