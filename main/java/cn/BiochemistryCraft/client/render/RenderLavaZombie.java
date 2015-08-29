package cn.BiochemistryCraft.client.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Entity.EntityLavaZombie;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLavaZombie extends RenderBiped
{
    private static final ResourceLocation resZombieTextures = new ResourceLocation(BiochemistryCraft.MODID,"textures/entity/lavazombie/reszombie.png");
    private static final ResourceLocation zombieTextures = new ResourceLocation(BiochemistryCraft.MODID,"textures/entity/lavazombie/zombie.png");
    private ModelBiped field_82434_o;
    protected ModelBiped field_82437_k;
    protected ModelBiped field_82435_l;

    public RenderLavaZombie()
    {
        super(new ModelZombie(), 0.5F, 1.0F);
        this.field_82434_o = this.modelBipedMain;
    }

    protected void func_82421_b()
    {
        this.field_82423_g = new ModelZombie(1.0F, true);
        this.field_82425_h = new ModelZombie(0.5F, true);
        this.field_82437_k = this.field_82423_g;
        this.field_82435_l = this.field_82425_h;
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLavaZombie p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        this.func_82427_a(p_77032_1_);
        if (p_77032_1_.isImmuneToFire())
        {
            this.bindTexture(resZombieTextures);
        }
        if (!p_77032_1_.isImmuneToFire())
        {
            this.bindTexture(zombieTextures);
        }
        return super.shouldRenderPass((EntityLiving)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityLavaZombie p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.func_82427_a(p_76986_1_);
        super.doRender((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityLavaZombie p_110775_1_)
    {
        return p_110775_1_.isImmuneToFire() ? resZombieTextures : zombieTextures;
    }

    protected void renderEquippedItems(EntityLavaZombie p_77029_1_, float p_77029_2_)
    {
        this.func_82427_a(p_77029_1_);
        super.renderEquippedItems((EntityLiving)p_77029_1_, p_77029_2_);
    }

    private void func_82427_a(EntityLavaZombie p_82427_1_)
    {
            this.mainModel = this.field_82434_o;
            this.field_82423_g = this.field_82437_k;
            this.field_82425_h = this.field_82435_l;

        this.modelBipedMain = (ModelBiped)this.mainModel;
    }

    protected void rotateCorpse(EntityLavaZombie p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        super.rotateCorpse(p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    protected void renderEquippedItems(EntityLiving p_77029_1_, float p_77029_2_)
    {
        this.renderEquippedItems((EntityLavaZombie)p_77029_1_, p_77029_2_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityLiving p_110775_1_)
    {
        return this.getEntityTexture((EntityLavaZombie)p_110775_1_);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityLavaZombie)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityLavaZombie)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityLavaZombie)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected void renderEquippedItems(EntityLivingBase p_77029_1_, float p_77029_2_)
    {
        this.renderEquippedItems((EntityLavaZombie)p_77029_1_, p_77029_2_);
    }

    protected void rotateCorpse(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        this.rotateCorpse((EntityLavaZombie)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityLavaZombie)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityLavaZombie)p_110775_1_);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityLavaZombie)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}