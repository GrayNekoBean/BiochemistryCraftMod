package cn.BiochemistryCraft.core.sick;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SickRegistry {
	private static List<SSick> sicklist=new ArrayList();
	private static int id=0;
	public static void registerSick(SSick sick)
	{
		sick.SickID = id;
		sicklist.add(id++, sick);
	}
	public static SSick getSickFromName(String s)
	{
		int i;
		if(s=="cold")
			i=0;
		else
			return null;
		return sicklist.get(i);
	}
	public static SSick getSickFromID(int i)
	{
		return sicklist.get(i);
	}
	public static String getNameFromID(int i)
	{
		switch (i)
		{
		case 0:return "cold";
		}
		return "cold";
	}
	public static SSick getRandomSick()
	{
		Random r=new Random();
		int i=r.nextInt(id);
		return getSickFromID(i);
	}
	public static SSick getRandomSick(Random rand)
	{
		int i=rand.nextInt(id);
		return getSickFromID(i);
	}
}
