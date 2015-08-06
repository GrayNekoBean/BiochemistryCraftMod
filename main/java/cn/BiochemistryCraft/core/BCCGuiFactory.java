package cn.BiochemistryCraft.core;

import java.util.Set;

import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import cpw.mods.fml.client.IModGuiFactory;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.GuiConfigEntries.CategoryEntry;

public class BCCGuiFactory implements IModGuiFactory {
    @Override
    public void initialize(Minecraft minecraftInstance) {}

    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass() {
	return BCCGuiConfig.class;
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
	return null;
    }

    @Override
    public RuntimeOptionGuiHandler getHandlerFor(
	    RuntimeOptionCategoryElement element) {
	return null;
    }
    public static class BCCGuiConfig extends GuiConfig{
	public BCCGuiConfig(GuiScreen parent) {
		super(parent, new ConfigElement(BCCConfig.config.getCategory(BCCConfig.Reference.CATEGORY_GLOBEL)).getChildElements(), BiochemistryCraft.MODID, false,
				false, I18n.format("config.title"));
	}
    }
}
