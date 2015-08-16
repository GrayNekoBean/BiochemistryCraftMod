package cn.BiochemistryCraft.core;

import org.apache.logging.log4j.Level;

import cn.BiochemistryCraft.BiochemistryCraft;
import cpw.mods.fml.common.FMLLog;
import akka.event.Logging.Info;

public class BCCLogger {
	public static void info(String format, Object... data){
		FMLLog.log(BiochemistryCraft.NAME, Level.INFO, format, data);
	}
	public static void debug(String format, Object... data){
		FMLLog.log(BiochemistryCraft.NAME, Level.DEBUG, format, data);
	}
	public static void warn(String format, Object... data){
		FMLLog.log(BiochemistryCraft.NAME, Level.WARN, format, data);
	}
	public static void err(String format, Object... data){
		FMLLog.log(BiochemistryCraft.NAME, Level.ERROR, format, data);
	}
}
