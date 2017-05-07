package com.builtbroken.turtlearmor;

import com.builtbroken.turtlearmor.content.armor.ItemTurtleArmor;
import com.builtbroken.turtlearmor.content.boat.EntityBoatArmor;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
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

    public static final String DOMAIN = "smbturtleboatarmor";
    public static final String PREFIX = DOMAIN + ":";

    /** Information output thing */
    public static final Logger logger = LogManager.getLogger("SBM-TurtleBoatArmor");

    @Mod.Instance(DOMAIN)
    public static TurtleArmorMod INSTANCE;

    @SidedProxy(clientSide = "com.builtbroken.turtlearmor.ClientProxy", serverSide = "com.builtbroken.turtlearmor.CommonProxy")
    public static CommonProxy proxy;

    public static Item chestArmor;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        chestArmor = new ItemTurtleArmor(1).setTextureName(PREFIX + "turtle_chestplate");
        GameRegistry.registerItem(chestArmor, "turtleArmorChest");

        EntityRegistry.registerModEntity(EntityBoatArmor.class, "sbmTurtleBoatArmor", 0, this, 200, 1, true);

        proxy.preInit();
    }
}
