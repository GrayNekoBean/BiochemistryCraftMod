package cn.BiochemistryCraft.CreativeTab;

import cn.BiochemistryCraft.Register.BCCRegisterItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BCCCreativeTab extends CreativeTabs{

	public BCCCreativeTab(String s) {
		super(s);
		// TODO �Զ���ɵĹ��캯����
	}

	@Override
	public Item getTabIconItem() {
		// TODO �Զ���ɵķ������
		return BCCRegisterItem.emptyneedle;
	}

}
