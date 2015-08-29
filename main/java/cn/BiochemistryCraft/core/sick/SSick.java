package cn.BiochemistryCraft.core.sick;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.potion.PotionEffect;
import cn.BiochemistryCraft.core.BCCLogger;
import cn.BiochemistryCraft.network.PacketMain;
import cn.BiochemistryCraft.network.packet.PacketSickInfo;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
@SuppressWarnings({ "unused" , "static-access" })
public abstract class SSick extends TimerTask {
	private static final String NBT_ROOT = SickPlayerInfo.NBT_ROOT;
	private static final String NBT_SICK = SickPlayerInfo.NBT_SICK;
	
	private static String sickName;
	public static int sickID;
	public EntityLivingBase entity;
	private Timer timer;
	public static List<SSick> sickList = new ArrayList<SSick>();
	public Random rand = new Random();
	private int immune = SickPlayerInfo.immuneValue;
	private int infect = SickPlayerInfo.infectValue;
	public PotionEffect effect;
	public List<ItemStack> curetiveList;
	
	public SSick () {
		
	}
	
	public abstract InfectType setInfectType(InfectType type);
	
	public SSick (EntityLivingBase entity, Timer timer, int delay) {
		this.entity = entity;
		this.timer = timer;
		this.setUp();
		timer.scheduleAtFixedRate(this, 1 / 20, delay);
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
			BCCLogger.debug(((EntityPlayer)entity).getDisplayName() + " is sick, disease name:"
					+ sickName + ", disease ID is " + sickID + ".");
		}
		this.sickUpdate();
		this.displayEffect();
	}

	public void sickUpdate() {
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
	
	public SSick randomSick() {
		for (int i = 0; i < sickList.size(); i++) {
			if (i == rand.nextInt(sickList.size())) {
				displayEffect();
				return sickList.get(i);
			}
		}
		return null;
	}

	public void endSick() {
		this.cancel();
		if (this.entity instanceof EntityPlayer) {
			List<SSick> a = SickPlayerInfo.read((EntityPlayer) this.entity);
			a.remove(this);
			SickPlayerInfo.write((EntityPlayer) this.entity, a);
			SickPlayerInfo.removeSick((EntityPlayer) this.entity, this);
			if (this.entity instanceof EntityPlayerMP) {
				PacketMain.sendToPlayer(new PacketSickInfo(a, this.immune, this.infect), (EntityPlayer) this.entity);
			}
		}
	}

	private void setUp() {
		this.rand = entity.worldObj.rand;
		if (this.entity instanceof EntityPlayer) {
			List<SSick> a = SickPlayerInfo.read((EntityPlayer) this.entity);
			if (a == null) {
				a = new ArrayList<SSick>();
			} else if (a.indexOf(this) == -1) {
					return;
			}
			a.add(this);
			SickPlayerInfo.write((EntityPlayer) this.entity, a);
			SickPlayerInfo.addSick((EntityPlayer) this.entity, this);
			if (this.entity instanceof EntityPlayerMP) {
				PacketMain.sendToPlayer(new PacketSickInfo(a, this.immune, this.infect), (EntityPlayer) this.entity);
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public static EntityPlayer getClientPlayerEntity() {
		return FMLClientHandler.instance().getClientPlayerEntity();
	}
	
	@SideOnly(Side.SERVER)
	public static EntityPlayer getServerPlayerEntity() {
		return ((NetHandlerPlayServer)FMLCommonHandler.instance().getClientToServerNetworkManager().channel().attr(NetworkRegistry.NET_HANDLER).get()).playerEntity;
	}

	public void playRandomSound(String str, Random rand) {
		
	}
	public void addEffectToPlayer(PotionBio potion,int strong,List<ItemStack> list){
		this.effect=new PotionEffect(potion.id,Integer.MAX_VALUE,strong,false);
		effect.getCurativeItems().remove((Object)new ItemStack(Items.milk_bucket));
		this.getClientPlayerEntity().addPotionEffect(effect);
	}
	    enum InfectType{
	    	
	    	XVirus,          //X病毒是几乎所有僵尸都携带的病毒，感染性强，但容易治疗，对于怪物来说，这种病毒很容易变异
	    	
	    	FurorVirus,  //狂暴者病毒是少数变异体所携带的病毒，他们有时候甚至会隐藏于一些具有攻击性的植物上

	    	prions,     //朊病毒，不会变异，但是很容易致命，会对大脑进行攻击
	    	
	    	parasiticBody,   //寄生体，寄生在生物身上，被寄生者在平时外貌不发生变化
	    	
	    	MRSA,    //抗药性金葡菌，感染性较强的细菌，不容易治疗
	    	
	    	NetherBacteria,   //地狱菌，感染后会使生物体温上升，一些怪物感染后会有熔岩属性
	    	
	    	typhoid;    //伤寒菌，致死能力弱，但是难治疗，带来的负面效果多
	    	
	    	private InfectType(){
	    		
	    	}
	    }
}
