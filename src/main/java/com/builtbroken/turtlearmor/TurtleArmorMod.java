package com.builtbroken.turtlearmor;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/7/2017.
 */
@Mod(modid = TurtleArmorMod.DOMAIN, name = "Turtle Boat Armor", version = TurtleArmorMod.VERSION)
public class TurtleArmorMod
{
    public static final String MAJOR_VERSION = "@MAJOR@";
    public static final String MINOR_VERSION = "@MINOR@";
    public static final String REVISION_VERSION = "@REVIS@";
    public static final String BUILD_VERSION = "@BUILD@";
    public static final String VERSION = MAJOR_VERSION + "." + MINOR_VERSION + "." + REVISION_VERSION + "." + BUILD_VERSION;

    public static final String DOMAIN = "sbmturtleboatarmor";
    public static final String PREFIX = DOMAIN + ":";

    /** Information output thing */
    public static final Logger logger = LogManager.getLogger("SBM-TurtleBoatArmor");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    }
}
