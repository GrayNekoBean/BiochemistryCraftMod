package cn.BiochemistryCraft.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import cn.BiochemistryCraft.Register.BCCEntityRendererRegister;
import cn.BiochemistryCraft.core.sick.SSick;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BCCclientProxy extends BCCcommonProxy{
    public static BCCEntityRendererRegister entityrendererregister;
	
	public void preInit(FMLPreInitializationEvent event){
		super.preInit(event);
	}
	
	public void load(FMLInitializationEvent event){
		super.load(event);
		entityrendererregister=new BCCEntityRendererRegister();
		entityrendererregister.EntityRenderRegisterInit();
	}
	
	public void postLoad(FMLPostInitializationEvent event){
		super.postLoad(event);
	}
	
	public void registerRenderThings(){
		super.registerRenderThings();
//		BiochemistryCraft.entityrendererregister.EntityRenderRegisterInit();
	}
	
	public void registerSound(){
		super.registerSound();
	}
	
	public void registerNormalThings(){
		super.registerNormalThings();
	}
	
	@SubscribeEvent
	public void showSickGUIinGame(RenderGameOverlayEvent.Pre event){
		Minecraft mc = FMLClientHandler.instance().getClient();
		FontRenderer render=mc.fontRenderer;
		render.drawString(SSick.getName(), GuiIngameForge.right_height, GuiIngameForge.left_height, 0xFFFFFF);
		mc.renderEngine.bindTexture(Gui.icons);
	}
}