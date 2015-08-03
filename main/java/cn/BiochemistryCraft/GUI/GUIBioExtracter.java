package cn.BiochemistryCraft.GUI;

import org.lwjgl.opengl.GL11;

import cn.BiochemistryCraft.TileEntity.TileentityBioExtracter;
import cn.BiochemistryCraft.core.BCCConfig;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GUIBioExtracter extends GuiContainer{
	private static final ResourceLocation resource = new ResourceLocation("biomod", BCCConfig.getGuiPath() + "container/BioExtracter.png");
	private TileentityBioExtracter tile;
	public GUIBioExtracter(InventoryPlayer inventory,
			TileentityBioExtracter tileEntity) {
		// TODO 自动生成的构造函数存根
		super(new ContainerBioExtracter(inventory, tileEntity));
		this.tile=tileEntity;
		this.doesGuiPauseGame();
	}
	
	 @Override
     protected void drawGuiContainerForegroundLayer(int par1, int par2) {
                 // TODO Auto-generated method stub
                 super.drawGuiContainerForegroundLayer(par1, par2);
                 this.fontRendererObj.drawString(StatCollector.translateToLocal("gui.Extracter.name"), 65, 6, 4210752);
                 this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
     }

	@Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2,int var3) 
	{
           // TODO Auto-generated method stub
           //int var4 = this.mc.renderEngine.getTexture("/gui/RepairTable.png");
	     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	     this.mc.renderEngine.bindTexture(resource);
	     int var5 = (this.width - this.xSize) / 2;
	     int var6 = (this.height - this.ySize) / 2;
	     this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
	     int b = tile.tableBurnTime; // 取得Tile内的燃料燃烧时间
	     float maxBurnTime = tile.maxBurnTime*1.0F;// 取得最大燃料燃烧时间，用float，不用的话得不出百分比
	     if (b > 0 && maxBurnTime > 0) // 确定描绘的时机
	     {
	         // 描绘火焰图像
	         this.drawTexturedModalRect(this.guiLeft + 81, this.guiTop + 37 + (int)(14 - 14 * ((float)b / maxBurnTime)),
	        		 176, (int)(14 - 14 * ((float)b / maxBurnTime)), 14, (int)(14 * ((float)b / maxBurnTime)));
	     }
	     
	     int out = tile.outputTime; // 取得Tile内的燃料燃烧时间
	     float maxOutputTime = 100F;// 取得最大燃料燃烧时间，用float，不用的话得不出百分比
	     if (b > 0 && maxBurnTime > 0) // 确定描绘的时机
	     {
	         // 描绘火焰图像
	         this.drawTexturedModalRect(this.guiLeft + 76, this.guiTop + 20,
	        		 176, 14, (int)(24*((float)out/maxOutputTime)), 16);
	     }
    }
}
