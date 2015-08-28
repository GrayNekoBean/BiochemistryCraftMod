package cn.BiochemistryCraft.core.sick;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.BiochemistryCraft.core.BCCLogger;

public class SickRegistry {
	private static List<SSick> sickclslist = new ArrayList<SSick>();
	private static List<String> sicknmlist = new ArrayList<String>();
	private static int id = 0;

	@SuppressWarnings("static-access")
	public static void registerSick(SSick sick, String name) {
		if(sicknmlist.contains(name)){
			BCCLogger.err("The name %s has been used by %s", name, getSickFromName(name));
			return;
		}
		if(sickclslist.contains(sick)){
			BCCLogger.err("The disease %s has been registered as %s", sick, getNameFromID(sickclslist.indexOf(sick)));
			return;
		}
		sick.sickID = sickclslist.size();
		sickclslist.add(sick);
		sicknmlist.add(name);
	}
	
	@SuppressWarnings("static-access")
	public static void registerSick(SSick sick, String name, int specificID) {
		if(sickclslist.get(specificID) != null){
			BCCLogger.err("The id %s has been used by %s", specificID, sickclslist.get(specificID));
			return;
		}
		if(sicknmlist.contains(name)){
			BCCLogger.err("The name %s has been used by %s", name, getSickFromName(name));
			return;
		}
		if(sickclslist.contains(sick)){
			BCCLogger.err("The disease %s has been registered as %s", sick, getNameFromID(sickclslist.indexOf(sick)));
			return;
		}
		sick.sickID = specificID;
		sickclslist.set(specificID, sick);
		sicknmlist.set(specificID, name);
	}

	public void RegistrySick(SSick sick) {

	}
	public static void printRegisteredDisease(){
		BCCLogger.info("%s disease%s ha%s been registered", sickclslist.size(), sickclslist.size() == 1 ? "" : "s", sickclslist.size() == 1 ? "s" : "ve");
		if(sickclslist.size() != 0){
			if(sickclslist.size() == 1){BCCLogger.info("It is:");}
			else{BCCLogger.info("They are:");}
			for (int i = 0; i < sickclslist.size(); i++) {
				BCCLogger.info("%s,with ID %s", getNameFromID(i), i);
			}
		}
	}
	public static SSick getSickFromName(String s) {
		int i = sicknmlist.indexOf(s);
		if(i != -1){
		return sickclslist.get(i);
		}
		else{
			return null;
		}
	}

	public static SSick getSickFromID(int i) {
		return sickclslist.get(i);
	}

	public static String getNameFromID(int i) {
		return sicknmlist.get(i);
	}

	public static SSick getRandomSick() {
		Random r = new Random();
		int i = r.nextInt(id);
		return getSickFromID(i);
	}

	public static SSick getRandomSick(Random rand) {
		int i = rand.nextInt(id);
		return getSickFromID(i);
	}
}
