package cn.BiochemistryCraft.TileEntity;

import cn.BiochemistryCraft.GUI.CraftingBioExtracter;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileentityBioExtracter extends TileEntity implements IInventory{
	
	
	private ItemStack tstack[]=new ItemStack[3];
	//private int i=0;
	public int tableBurnTime = 0;
	public int outputTime = 0;
	public int maxBurnTime = 0;
	
	
	@Override
    public void updateEntity() {
           // TODO Auto-generated method stub
	           super.updateEntity();
	           //System.out.println("Hello GUI"+(i++));
	           ItemStack output = null;
	           if(tableBurnTime > 0)
	           {
	                   // 取得修复的物品
	                   ItemStack bioItem = getStackInSlot(0);
	                   // 取得修复好的物品
	                   ItemStack outputItem = getStackInSlot(1);
	                   // 确定开始修复的条件之一：修复物品槽不为空，已修复物品槽为空
	                   if(bioItem != null && (outputItem == null || outputItem.getItem() == CraftingBioExtracter.getBioItem(bioItem).getItem()))
	                   {
	                	   output=CraftingBioExtracter.getBioItem(bioItem);
	                	   if(output!=null)
	                		   outputTime++;
	                   }
	                   else
	                	   outputTime=0;
	                   // 减少燃烧时间
	                   tableBurnTime -= 1;
	                   
	                   
	           }
	           else // 没有燃料的情况下
	           {
	                   // 如果有被修复的物品
                   if(getStackInSlot(0) != null && CraftingBioExtracter.getBioItem(getStackInSlot(0)) != null && getStackInSlot(2)!=null)
                   {
                           // 取得燃料槽的物品
                           ItemStack burnItem = getStackInSlot(2);
                           // 取得物品的燃烧值
                       int getBurnTime = CraftingBioExtracter.getBioTime(burnItem);
                       // 判断物品是否能燃烧
                       if(getBurnTime > 0)
                       {
                           maxBurnTime = getBurnTime;
                           tableBurnTime = getBurnTime;
                           // 如果燃烧物品为岩浆桶
                                   // 其他物品就减少
                           if(burnItem.stackSize - 1 > 0)
                           {
                                   burnItem.stackSize--;
                                   setInventorySlotContents(2, burnItem);
                           }
                           else
                           {
                                   setInventorySlotContents(2, null);
                           }
                       }
                       else 
                    	   outputTime=0;
                   }
                   else
                	   outputTime=0;
	           }
	           if(outputTime>=100)
	           {
	        	  ItemStack bioItem = getStackInSlot(0);
	        	  ItemStack returnItem = getStackInSlot(1);
	        	  if(returnItem!=null)
	        		  output.stackSize+=returnItem.stackSize;
	              setInventorySlotContents(1,output);
	              if(--bioItem.stackSize>0)
	            	  setInventorySlotContents(0,bioItem);
	              else
	            	  setInventorySlotContents(0,null);
	              outputTime=0;
	           }
	           if(getStackInSlot(0)==null)
	        	   outputTime=0;   
           }
	
	@Override
	public int getSizeInventory() {
		// TODO �Զ���ɵķ������
		return tstack.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		// TODO �Զ���ɵķ������
		return tstack[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
        if (this.tstack[index] != null)
        {
            ItemStack itemstack;

            if (this.tstack[index].stackSize <= count)
            {
                itemstack = this.tstack[index];
                this.tstack[index] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.tstack[index].splitStack(count);

                if (this.tstack[index].stackSize == 0)
                {
                            this.tstack[index] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
}    //复制原版熔炉代码

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		// TODO �Զ���ɵķ������
		this.tstack[var1] = var2;
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
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items", 10);
        this.tstack = new ItemStack[this.getSizeInventory()];
        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.getCompoundTagAt(var3);
            byte var5 = var4.getByte("Slot");
            if (var5 >= 0 && var5 < this.tstack.length)
            {
                this.tstack[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }
        this.tableBurnTime = par1NBTTagCompound.getShort("tableBurnTime");
        this.maxBurnTime = par1NBTTagCompound.getShort("maxBurnTime");
    }

    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("tableBurnTime", (short)this.tableBurnTime);
        par1NBTTagCompound.setShort("maxBurnTime", (short)this.maxBurnTime);
        NBTTagList var2 = new NBTTagList();
        for (int var3 = 0; var3 < this.tstack.length; ++var3)
        {
            if (this.tstack[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.tstack[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }
        par1NBTTagCompound.setTag("Items", var2);
    }
    
    public static int getItemBurnTime(ItemStack p_145952_0_)
    {
        if (p_145952_0_ == null)
        {
            return 0;
        }
        else
        {
            Item item = p_145952_0_.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab)
                {
                    return 150;
                }

                if (block.getMaterial() == Material.wood)
                {
                    return 300;
                }

                if (block == Blocks.coal_block)
                {
                    return 16000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(p_145952_0_);
        }
    }

}
