package cn.BiochemistryCraft.Block;

import cn.BiochemistryCraft.core.sick.PotionBio;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class BlockBioDirt extends BCCBlockBase{
	private PotionEffect effect;
	public BlockBioDirt(Material p_i45394_1_) {
		super(p_i45394_1_);
		
		
		// TODO Auto-generated constructor stub
		this.setBlock("BioDirt",true);
		//this.setBlockName("BioDirt");
		//this.setBlockTextureName("biomod:BioDirt");
		this.setHardness(0.5f);
		this.setResistance(10.0f);
		this.setLightLevel(6.0f);
		this.setHarvestLevel("shavel", 0);
		this.setStepSound(Block.soundTypeGrass);
		//this.setCreativeTab(CreativeTabs.tabTransport);
	}
	@Override
	public void onBlockClicked(World world,int x,int y,int z,EntityPlayer player){
		this.addEffectToPlayer((PotionBio) PotionBio.hunger, 1, player);
		
	}
	
	public void addEffectToPlayer(PotionBio potion,int strong,EntityPlayer player){
		this.effect=new PotionEffect(potion.id,Integer.MAX_VALUE,strong,false);
		effect.getCurativeItems().remove((Object)new ItemStack(Items.milk_bucket));
		player.addPotionEffect(effect);
	}
}
