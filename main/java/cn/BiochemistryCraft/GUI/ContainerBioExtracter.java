package cn.BiochemistryCraft.GUI;

import java.util.Iterator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cn.BiochemistryCraft.TileEntity.TileentityBioExtracter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBioExtracter extends Container{
	private TileentityBioExtracter tile;
	private int lastTableBurnTime = 0;
	private int lastMaxBurnTime = 0;
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
	@Override
    public void addCraftingToCrafters(ICrafting par1iCrafting) {
            // TODO Auto-generated method stub
            super.addCraftingToCrafters(par1iCrafting);
            par1iCrafting.sendProgressBarUpdate(this, 0, this.tile.tableBurnTime);
            par1iCrafting.sendProgressBarUpdate(this, 1, this.tile.maxBurnTime);
    }
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
            if (par1 == 0)
            {
            	this.tile.tableBurnTime = par2;
            }
            if (par1 == 1)
            {
            	this.tile.maxBurnTime = par2;
            }
    }
    @Override
    public void detectAndSendChanges()
    {
    	// TODO Auto-generated method stub
    	super.detectAndSendChanges();
    	Iterator var1 = this.crafters.iterator();
    	while (var1.hasNext())
    	{
    		ICrafting var2 = (ICrafting)var1.next();
    		if (this.lastTableBurnTime != this.tile.tableBurnTime)
    		{
    			var2.sendProgressBarUpdate(this, 0, this.tile.tableBurnTime);
    		}

    		if (this.lastMaxBurnTime  != this.tile.maxBurnTime)
    		{
    			var2.sendProgressBarUpdate(this, 1, this.tile.maxBurnTime);
    		}
    	}
    	this.lastTableBurnTime = this.tile.tableBurnTime;
    	this.lastMaxBurnTime = this.tile.maxBurnTime;
    }
    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack var3 = null;
        Slot var4 = (Slot)this.inventorySlots.get(par2);

        if (var4 != null && var4.getHasStack())
        {
            ItemStack var5 = var4.getStack();
            var3 = var5.copy();
            // 点击到Slot的ID为0-2之间的时候，将物品送回玩家的背包中
            if (par2 >= 0 && par2 <= 2)
            {
                if (!this.mergeItemStack(var5, 3, 30, false))
                {
                    return null;
                }

                var4.onSlotChange(var5, var3);
            }
            // 点击到玩家的背包的时候将物品送到玩家的快捷栏中
            else if (par2 > 3 && par2 < 30)
            {
                if (!this.mergeItemStack(var5, 30, 39, false))
                {
                    return null;
                }
            }
            // 点击到玩家的快捷栏的时候将物品送到背包中
            else if (par2 >= 30 && par2 < 39)
            {
                if (!this.mergeItemStack(var5, 3, 30, false))
                {
                    return null;
                }
            }

            if (var5.stackSize == 0)
            {
                var4.putStack((ItemStack)null);
            }
            else
            {
                var4.onSlotChanged();
            }

            if (var5.stackSize == var3.stackSize)
            {
                return null;
            }

            var4.onPickupFromSlot(par1EntityPlayer, var5);
        }

        return var3;
    }
}
