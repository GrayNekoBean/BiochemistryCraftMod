package cn.BiochemistryCraft.core.sick;

public enum TriggerType { COLLIDE_BLOCK(0), REACH_POSISION(1);
	private int index;
	
	public int getIndex(){
		return this.index;
	}
	
	TriggerType(int index){
		this.index = index;
	}
}
