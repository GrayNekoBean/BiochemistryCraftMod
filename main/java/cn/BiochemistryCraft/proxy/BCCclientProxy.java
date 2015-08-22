package cn.BiochemistryCraft.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Register.BCCEntityRegister;
import cn.BiochemistryCraft.core.sick.SSick;

public class BCCclientProxy extends BCCcommonProxy{
	
	public Minecraft mc=Minecraft.getMinecraft();
	
	public void preInit(){
		super.preInit();
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public void load(){
		super.load();
	}
	
	public void postLoad(){
		super.postLoad();
	}
	
	
	
	public void registerRenderThings(){
		super.registerRenderThings();
		BiochemistryCraft.entityregister.EntityRenderRegisterInit();
	}
	
	public void registerSound(){
		super.registerSound();
	}
	
	public void registerNormalThings(){
		super.registerNormalThings();
	}
	
	@SubscribeEvent
	public void showSickGUIinGame(RenderGameOverlayEvent.Pre event){
		
		FontRenderer render=mc.fontRenderer;
		render.drawString(SSick.getName(), GuiIngameForge.right_height, GuiIngameForge.left_height, 0xFFFFFF);
		mc.renderEngine.bindTexture(Gui.icons);
	}
	
	
}
