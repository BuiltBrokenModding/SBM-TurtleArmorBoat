package com.builtbroken.turtlearmor;

import com.builtbroken.turtlearmor.content.boat.EntityBoatArmor;
import com.builtbroken.turtlearmor.content.boat.RenderEntityBoat;
import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/7/2017.
 */
public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit()
    {
        super.preInit();
        RenderingRegistry.registerEntityRenderingHandler(EntityBoatArmor.class, new RenderEntityBoat());
    }
}
