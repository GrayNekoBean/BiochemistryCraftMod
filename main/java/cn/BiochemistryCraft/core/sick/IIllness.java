package cn.BiochemistryCraft.core.sick;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public interface IIllness {
    public void effectOnMob(EntityLivingBase entity);
    
    public void effectOnPlayer(EntityPlayer player);
}
