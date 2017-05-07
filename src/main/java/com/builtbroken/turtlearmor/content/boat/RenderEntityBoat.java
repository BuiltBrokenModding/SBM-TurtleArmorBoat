package com.builtbroken.turtlearmor.content.boat;

import com.builtbroken.turtlearmor.TurtleArmorMod;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.entity.RenderBoat;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/7/2017.
 */
public class RenderEntityBoat extends RenderBoat
{
    private static final ResourceLocation boatTextures = new ResourceLocation(TurtleArmorMod.DOMAIN, "textures/entity/boat.png");

    /** instance of ModelBoat for rendering */
    protected ModelBase modelBoat;

    public RenderEntityBoat()
    {
        this.shadowSize = 0.5F;
        this.modelBoat = new ModelBoat();
    }

    @Override
    public void doRender(Entity entity, double xx, double yy, double zz, float p_76986_8_, float p_76986_9_)
    {
        if (entity instanceof EntityBoatArmor)
        {
            EntityBoatArmor boat = (EntityBoatArmor) entity;

            GL11.glPushMatrix();
            GL11.glTranslatef((float) xx, (float) yy, (float) zz);
            GL11.glRotatef(180.0F - p_76986_8_, 0.0F, 1.0F, 0.0F);
            float f2 = (float) boat.getTimeSinceHit() - p_76986_9_;
            float f3 = boat.getDamageTaken() - p_76986_9_;

            if (f3 < 0.0F)
            {
                f3 = 0.0F;
            }

            if (f2 > 0.0F)
            {
                GL11.glRotatef(MathHelper.sin(f2) * f2 * f3 / 10.0F * (float) boat.getForwardDirection(), 1.0F, 0.0F, 0.0F);
            }

            float f4 = 0.75F;
            GL11.glScalef(f4, f4, f4);
            GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
            this.bindEntityTexture(boat);
            GL11.glScalef(-1.0F, -1.0F, 1.0F);
            this.modelBoat.render(boat, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return boatTextures;
    }
}
