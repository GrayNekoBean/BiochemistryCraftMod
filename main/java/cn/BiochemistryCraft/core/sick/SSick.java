package cn.BiochemistryCraft.core.sick;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import cn.BiochemistryCraft.network.PacketMain;
import cn.BiochemistryCraft.network.packet.PacketSickInfo;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;

public abstract class SSick extends TimerTask{
	private String SickName;
	public static int SickID;
	public EntityLivingBase entity;
	
	private static final String NBT_ROOT = SickPlayerInfo.NBT_ROOT;
	private static final String NBT_SICK = SickPlayerInfo.NBT_SICK;
	
	public SSick()
	{
	}

	@Override
	public void run() {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		System.out.println("鐢熺梾涓�");
		this.SickUpdate();
		this.displayEffect();
	}
	
	public void SickUpdate()
	{
		
	}
	
	
	public abstract void displayEffect();
	
	public void EndSick()
	{
		this.cancel();
		if(this.entity instanceof EntityPlayer){
			int[] a = SickPlayerInfo.read((EntityPlayer)this.entity);
			int[] b = new int[a.length - 1];
			for(int i = 0; i < a.length; i++){
				if(a[i] == SickID){
					System.arraycopy(a, 0, b, 0, i);
					System.arraycopy(a, i + 1, b, i, a.length - 1 - i);
					break;
				}
			}
			SickPlayerInfo.write((EntityPlayer)this.entity, b);
			if (this.entity instanceof EntityPlayerMP){
				PacketMain.sendToPlayer(new PacketSickInfo(b), (EntityPlayer)this.entity);
			}
		}
	}
	
	public void SetEntity(EntityLivingBase entity)
	{
		this.entity=entity;
		if(this.entity instanceof EntityPlayer){
			int[] a = SickPlayerInfo.read((EntityPlayer)this.entity);
			int[] b;
			if (a == null){
				b = new int[1];
				b[0] = SickID;
			}else{
				for(int i: a){
					if(i == SickID){
						return;
					}
				}
				b = new int[a.length + 1];
				System.arraycopy(a, 0, b, 0, a.length);
				b[a.length] = SickID;
			}
			SickPlayerInfo.write((EntityPlayer)this.entity, b);
			if (this.entity instanceof EntityPlayerMP){
				PacketMain.sendToPlayer(new PacketSickInfo(b), (EntityPlayer)this.entity);
			}
		}
	}
}
