package cn.BiochemistryCraft.core.sick;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import cn.BiochemistryCraft.network.PacketMain;
import cn.BiochemistryCraft.network.packet.PacketSickInfo;

public abstract class SSick extends TimerTask {
	private static final String NBT_ROOT = SickPlayerInfo.NBT_ROOT;
	private static final String NBT_SICK = SickPlayerInfo.NBT_SICK;
	
	private static String sickName;
	public static int sickID;
	public EntityLivingBase entity;
	public static List<SSick> sickList = new ArrayList();
	public Random rand;
	private int immune = SickPlayerInfo.immuneValue;
	private int infect = SickPlayerInfo.infectValue;
	
	public SSick() {
	}

	public static String getName() {
		return sickName;
	}
	
	public boolean equals(SSick sick){
		return sick == null ? false : sick.sickID == this.sickID;
	}

	@Override
	public void run() {
		if(entity instanceof EntityPlayer){
			System.out.println(((EntityPlayer)entity).getDisplayName() + " is sick, sick name:"
					+ sickName + ", sick ID is " + sickID + ".");
		}
		this.SickUpdate();
		this.displayEffect();
	}

	public void SickUpdate() {
		if (immune <= infect) {
			if (rand.nextInt(500 - immune) < infect - immune) {
				infect++;
			}

			if (infect > (float) immune * 1.5) {
				if (rand.nextInt(immune) == 1) {
					randomSick();
				}
			}

		}
		displayEffect();
	}

	public abstract void displayEffect();
	
	public void randomSick() {
		for (int i = 0; i < sickList.size(); i++) {
			if (i == rand.nextInt(sickList.size())) {
				displayEffect();
			}
		}
	}

	public void EndSick() {
		this.cancel();
		if (this.entity instanceof EntityPlayer) {
			List<SSick> a = SickPlayerInfo.read((EntityPlayer) this.entity);
			a.remove(this);
			SickPlayerInfo.write((EntityPlayer) this.entity, a);
			if (this.entity instanceof EntityPlayerMP) {
				PacketMain.sendToPlayer(new PacketSickInfo(a, this.immune, this.infect), (EntityPlayer) this.entity);
			}
		}
	}

	public void SetEntity(EntityLivingBase entity) {
		this.entity = entity;
		this.rand = entity.worldObj.rand;
		if (this.entity instanceof EntityPlayer) {
			List<SSick> a = SickPlayerInfo.read((EntityPlayer) this.entity);
			if (a == null) {
				a = new ArrayList();
			} else if (a.indexOf(this) == -1) {
					return;
			}
			a.add(this);
			SickPlayerInfo.write((EntityPlayer) this.entity, a);
			if (this.entity instanceof EntityPlayerMP) {
				PacketMain.sendToPlayer(new PacketSickInfo(a, this.immune, this.infect), (EntityPlayer) this.entity);
			}
		}
	}

	public static EntityPlayer getPlayerEntity() {
		return Minecraft.getMinecraft().thePlayer;
	}

	public void playRandomSound(String str, Random rand) {

	}
}
