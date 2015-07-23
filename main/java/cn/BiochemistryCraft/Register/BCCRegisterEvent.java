package cn.BiochemistryCraft.Register;

import net.minecraftforge.common.MinecraftForge;
import cn.BiochemistryCraft.event.EventBonemeal;

public class BCCRegisterEvent {
	public void eventRegisterInit(){
		MinecraftForge.EVENT_BUS.register(new EventBonemeal());
	}
}
