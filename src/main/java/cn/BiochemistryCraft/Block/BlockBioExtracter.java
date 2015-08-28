package cn.BiochemistryCraft.Block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.GUI.GUIID;
import cn.BiochemistryCraft.TileEntity.TileentityBioExtracter;

public class BlockBioExtracter extends BlockContainer{

	public BlockBioExtracter(Material m) {
		super(m);
		// TODO �Զ���ɵĹ��캯����
		this.setUnlocalizedName("BioExtracter");
		//this.setBlockTextureName("biomod:BioExtracter");
		this.setCreativeTab(BiochemistryCraft.biocreativetab);
		this.setHarvestLevel("shavel", 3);
		this.setStepSound(Block.soundTypeWood);
		this.setHardness(2F);
		this.setBlockBounds(0.25F, 0.25F,0.25F, 0.75F, 0.75F,0.75F);
	}
	
	@Override
    public boolean onBlockActivated(World par1World, int par2, int par3,
                  int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
                  float par8, float par9) {
           // TODO Auto-generated method stub
            par5EntityPlayer.openGui(BiochemistryCraft.instance, GUIID.BioExtracter, par1World, par2, par3, par4);
          

     return true;
    }
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO �Զ���ɵķ������
		return new TileentityBioExtracter();
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int number, int p_149691_2_)
    {
        if(number==0 || number==1)
        	return icon2;
        else
        	return icon1;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.icon1 = p_149651_1_.registerIcon("biomod:BioExtracter");
        this.icon2 = p_149651_1_.registerIcon("biomod:BioExtracterTb");
    }
	
}
