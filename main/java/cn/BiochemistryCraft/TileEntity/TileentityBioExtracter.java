package cn.BiochemistryCraft.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileentityBioExtracter extends TileEntity implements IInventory{
	
	
	private ItemStack stack[]=new ItemStack[3];

	@Override
	public int getSizeInventory() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public String getInventoryName() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO 自动生成的方法存根
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO 自动生成的方法存根
		return true;
	}

	@Override
	public void openInventory() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void closeInventory() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO 自动生成的方法存根
		return false;
	}
	
	
	

}
