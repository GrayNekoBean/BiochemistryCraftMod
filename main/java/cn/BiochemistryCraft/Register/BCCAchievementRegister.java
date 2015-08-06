package cn.BiochemistryCraft.Register;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.BiochemistryCraft.BiochemistryCraft;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class BCCAchievementRegister {
    public static AchievementPage bioPage;
    private List<Achievement> ach = new LinkedList<Achievement>();
    public static Achievement beginner;
    public static Achievement treef;
    public static Achievement herbfac;
    public BCCAchievementRegister(){
	beginner = putAchievement("achievement.beginer", "beginer", 0, 0, new ItemStack(BCCRegisterBlock.biodirt));
	treef = putAchievement("achievement.treef", "treef", -1, -1, new ItemStack(BCCRegisterItem.treeFruit), beginner);
	herbfac = putAchievement("achievement.herb", "herb", -3, -1, new ItemStack(BCCRegisterItem.herbsArray[0]), treef);
    }
    public Achievement putAchievement(String id, String name, int x, int y, ItemStack stack) {
	Achievement tmpa = new Achievement(id, name, x, y, stack, (Achievement)null).initIndependentStat().registerStat();
	ach.add(tmpa);
	return tmpa;
    }
    public Achievement putAchievement(String id, String name, int x, int y, ItemStack stack, Achievement preach){
	Achievement tmpa = new Achievement(id, name, x, y, stack, preach).registerStat();
	ach.add(tmpa);
	return tmpa;
    }
    public Achievement putSpecialAchievement(String id, String name, int x, int y, ItemStack stack, Achievement preach){
	Achievement tmpa = new Achievement(id, name, x, y, stack, preach).setSpecial().registerStat();
	ach.add(tmpa);
	return tmpa;
    }
    public void putAchievement(Achievement ach){
	this.ach.add(ach);
    }
    public void achievementsInit(){
	Achievement[] tmpa = (Achievement[]) ach.toArray(new Achievement[ach.size()]);
	bioPage = new AchievementPage(BiochemistryCraft.NAME, tmpa);
	AchievementPage.registerAchievementPage(bioPage);
    }
}
