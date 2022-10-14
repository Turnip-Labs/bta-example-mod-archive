package azurelmao.examplemod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.src.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExampleMod implements ModInitializer {
    public static final String MOD_ID = "examplemod";

    // Ideally use this whenever you need to print text like so,
    //
    //      ExampleMod.LOGGER.info("some kind of error");
    //
    // The difference between using `System.out.println()` is that your message
    // will be appended with your mod's id, in this case:
    //
    //      (examplemod) some kind of error
    //
    // This makes it easier for other modders to know which mod causes what.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Use your mod's id in the translation keys to prevent conflicts with other mods.
    // Example:
    //
    //      new Item().setName(ExampleMod.MOD_ID + ".example.item");
    //
    // Will result in this in the lang file:
    //
    //      "item.examplemod.example.item"
    //
    // Or you can use a helper method:
    public static String name(String name) {
        return ExampleMod.MOD_ID + "." + name;
    }

    // Items
    public static final Item exampleItem = new Item(140).setIconCoord(0, 14).setItemName(name("example.item"));
    public static final Item exampleCustomItem = new ExampleCustomItem(141).setIconCoord(1, 14).setItemName(name("example.custom.item"));
    public static final Item exampleFood = new ItemFood(142, 4, false).setIconCoord(2, 14).setItemName(name("food.example.food"));
    public static final Item exampleTool = new ItemToolShovel(143, ExampleToolMaterial.exampleToolMaterial).setIconCoord(3, 14).setItemName(name("tool.example.tool"));

    public static final Item exampleHelmet = new ItemArmor(144, ExampleArmorMaterial.exampleArmorMaterial, 0).setIconCoord(4, 14).setItemName(name("armor.example.helmet"));
    public static final Item exampleChestplate = new ItemArmor(145, ExampleArmorMaterial.exampleArmorMaterial, 1).setIconCoord(5, 14).setItemName(name("armor.example.chestplate"));
    public static final Item exampleLeggings = new ItemArmor(146, ExampleArmorMaterial.exampleArmorMaterial, 2).setIconCoord(6, 14).setItemName(name("armor.example.leggings"));
    public static final Item exampleBoots = new ItemArmor(147, ExampleArmorMaterial.exampleArmorMaterial, 3).setIconCoord(7, 14).setItemName(name("armor.example.boots"));

    // Blocks
    public static final Block exampleBlock = BlockHelper.createBlock(900, name("example.block"), Material.ground, Block.soundSandFootstep, 31, 0, 0.1f, 0.1f, 0.0f);


    @Override
    public void onInitialize() {
        LOGGER.info("ExampleMod initialized.");
    }
}
