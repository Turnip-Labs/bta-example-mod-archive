package azurelmao.examplemod;

import azurelmao.examplemod.block.ExamplePortalBlock;
import azurelmao.examplemod.item.ExampleArmorMaterial;
import azurelmao.examplemod.item.ExampleCustomItem;
import azurelmao.examplemod.item.ExampleToolMaterial;
import azurelmao.examplemod.mixin.ExampleInvoker;
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
    public static final Block exampleBlock = BlockHelper.createBlock(900, name("example.block"), 31, 0, Material.ground, Block.soundSandFootstep, 0.1f, 0.1f, 0.0f);
    public static final Block redMushroomCap = BlockHelper.createBlock(902, name("mushroom.cap.red"), 31, 1,  Material.cloth, Block.soundClothFootstep, 0.1f, 0.1f, 0.0f);
    public static final Block brownMushroomCap = BlockHelper.createBlock(903, name("mushroom.cap.brown"), 31, 2,  Material.cloth, Block.soundClothFootstep, 0.1f, 0.1f, 0.0f);
    public static final Block mushroomStem = BlockHelper.createBlock(904, name("mushroom.stem"), 31, 4, 31, 4, 31, 3, Material.cloth, Block.soundClothFootstep, 0.1f, 0.1f, 0.0f);
    public static final Block examplePortalBlock = new ExamplePortalBlock(901, 3, Block.glowstone.blockID, Block.fluidWaterStill.blockID).setBlockName("example.portal").setTexCoords(13, 12).setNotInCreativeMenu();
    static {
        ((ExampleInvoker) examplePortalBlock).callSetHardness(-1.0f);
        ((ExampleInvoker) examplePortalBlock).callSetStepSound(Block.soundGlassFootstep);
        ((ExampleInvoker) examplePortalBlock).callSetLightValue(0.75f);
    }

    // Dimension
    public static final Dimension exampleDimension = DimensionHelper.createDimension(3, "exampleworld", Dimension.overworld, 1.0f, examplePortalBlock, WorldType.overworldRetro, 0, 128);

    @Override
    public void onInitialize() {
        LOGGER.info("ExampleMod initialized.");

        // Recipes
        RecipeHelper.Crafting.removeRecipe(Item.bed);
        RecipeHelper.Crafting.createRecipe(exampleCustomItem, 1, new Object[]{"#A", "B#", 'A', Item.nethercoal, 'B', Item.stick});
        RecipeHelper.Crafting.createShapelessRecipe(exampleItem, 4, new Object[]{new ItemStack(Item.dustGlowstone, 1), new ItemStack(Item.dustRedstone, 1), new ItemStack(Item.dustSugar, 1), new ItemStack(Item.sulphur, 1)});

        RecipeHelper.Smelting.createRecipe(exampleFood, exampleItem);
        RecipeHelper.Blasting.createRecipe(Block.bedrock, Block.blockClay);
    }
}
