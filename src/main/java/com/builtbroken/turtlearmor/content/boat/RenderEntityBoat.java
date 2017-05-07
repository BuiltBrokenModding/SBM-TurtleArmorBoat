package com.builtbroken.turtlearmor.content.boat;

import com.builtbroken.turtlearmor.TurtleArmorMod;
import net.minecraft.client.renderer.entity.RenderBoat;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.ResourceLocation;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/7/2017.
 */
public class RenderEntityBoat extends RenderBoat
{
    private static final ResourceLocation boatTextures = new ResourceLocation(TurtleArmorMod.DOMAIN, "textures/entity/boat.png");

    @Override
    protected ResourceLocation getEntityTexture(EntityBoat p_110775_1_)
    {
        return boatTextures;
    }
}
