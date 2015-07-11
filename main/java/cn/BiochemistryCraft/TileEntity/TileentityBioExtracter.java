package cn.BiochemistryCraft.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileentityBioExtracter extends TileEntity implements IInventory{
	
	
	private ItemStack stack[]=new ItemStack[3];
	private int i=0;

	
	
	@Override
    public void updateEntity() {
           // TODO Auto-generated method stub
           super.updateEntity();
           //System.out.println("Hello GUI"+(i++));
    }
	
	@Override
	public int getSizeInventory() {
		// TODO �Զ���ɵķ������
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		// TODO �Զ���ɵķ������
        if (this.stack[par1] != null)
        {
        	ItemStack var3;

        	if (this.stack[par1].stackSize <= par2)
        	{
        		var3 = this.stack[par1];
        		this.stack[par1] = null;
        		return var3;
        	}
        	else
        	{
        		var3 = this.stack[par1].splitStack(par2);
	        
        		if (this.stack[par1].stackSize == 0)
        		{
        			this.stack[par1] = null;
        		}
	
        		return var3;
        	}
        }
        else
        {
        	return null;
        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		// TODO �Զ���ɵķ������
		this.stack[var1] = var2;
        if (var2 != null && var2.stackSize > this.getInventoryStackLimit())
        {
                var2.stackSize = this.getInventoryStackLimit();
        }
		
	}

	@Override
	public String getInventoryName() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO �Զ���ɵķ������
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO �Զ���ɵķ������
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO �Զ���ɵķ������
		return true;
	}

	@Override
	public void openInventory() {
		// TODO �Զ���ɵķ������
		
	}

	@Override
	public void closeInventory() {
		// TODO �Զ���ɵķ������
		
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO �Զ���ɵķ������
		return false;
	}
	
	

}
