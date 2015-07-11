package cn.BiochemistryCraft.GUI;

import cn.BiochemistryCraft.TileEntity.TileentityBioExtracter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class BioGuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO 自动生成的方法存根
		 switch(ID){
		 case GUIID.BioExtracter:
			return new ContainerBioExtracter(player.inventory, (TileentityBioExtracter)player.worldObj.getTileEntity(x, y, z));
		 }
		 return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch(ID){
		 case GUIID.BioExtracter:
			return new GUIBioExtracter(player.inventory, (TileentityBioExtracter)player.worldObj.getTileEntity(x, y, z));
		 }
		// TODO 自动生成的方法存根
		return null;
	}
}
