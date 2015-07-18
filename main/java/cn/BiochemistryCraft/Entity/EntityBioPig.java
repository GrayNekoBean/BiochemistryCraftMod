package cn.BiochemistryCraft.Entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;

public class EntityBioPig extends EntityMob
{
    public EntityBioPig(World world)
    {
        super(world);
        setSize(0.9F, 0.9F);
        experienceValue = 5;
    }
    public EntityBioPig(World world,EntityLivingBase e)
    {
        super(world);
        setSize(0.9F, 0.9F);
        experienceValue = 5;
        this.setPosition(e.posX, e.posY, e.posZ);
    }
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20F);
        //this.getAttributeMap().registerAttribute(field_110186_bp).setBaseValue(this.rand.nextDouble() * ForgeModContainer.zombieSummonBaseChance);
    }

    
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
    }
    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
    }
    /*protected String getLivingSound()
    {
        return "mob.pig";
    }
    protected String getHurtSound()
    {
        return "mob.pig";
    }
    protected String getDeathSound()
    {
        return "mob.pigdeath";
    }*/
    protected Item getDropItem()
    {
        return Items.porkchop;
    }
}
