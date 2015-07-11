package cn.BiochemistryCraft.GUI;

import cn.BiochemistryCraft.TileEntity.TileentityBioExtracter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerBioExtracter extends Container{
	private TileentityBioExtracter tile;
	public ContainerBioExtracter(InventoryPlayer player, TileentityBioExtracter TileEntityBioExtracter)
    {
           tile = TileEntityBioExtracter;
           this.addSlotToContainer(new Slot(tile, 0, 49, 19));
           this.addSlotToContainer(new Slot(tile, 1, 112, 19));
           this.addSlotToContainer(new Slot(tile, 2, 80, 54));
           int var3;
           for (var3 = 0; var3 < 3; ++var3)
           {
               for (int var4 = 0; var4 < 9; ++var4)
               {
                   this.addSlotToContainer(new Slot(player, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
               }
           }

           for (var3 = 0; var3 < 9; ++var3)
           {
               this.addSlotToContainer(new Slot(player, var3, 8 + var3 * 18, 142));
           }
    }
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		// TODO 自动生成的方法存根
		return true;
	}

}
