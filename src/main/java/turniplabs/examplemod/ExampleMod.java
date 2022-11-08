package turniplabs.examplemod;

import turniplabs.halplibe.helper.*;
import turniplabs.halplibe.mixin.helper.BlockInterface;
import net.fabricmc.api.ModInitializer;
import net.minecraft.src.*;
import net.minecraft.src.material.ArmorMaterial;
import net.minecraft.src.material.ToolMaterial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;


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

    public static boolean probability(Random rand, double percent) {
        return percent > 0 && rand.nextInt(100) <= percent;
    }

    // Armor/tool materials
    public static final ArmorMaterial exampleArmorMaterial = ArmorHelper.createArmorMaterial("examplenite", 1000, 0.0f, 200.0f, 0.0f, 200.0f);
    public static final ToolMaterial exampleToolMaterial = new ToolMaterial().setDurability(16).setEfficiency(10.0f, 100.0f).setMiningLevel(0).setBlockHitDelay(0);
    
    // Items
    public static final Item exampleItem = new Item(140).setIconCoord(0, 14).setItemName(name("example.item"));
    public static final Item exampleCustomItem = new ExampleCustomItem(141).setIconCoord(1, 14).setItemName(name("example.custom.item"));
    public static final Item exampleFood = new ItemFood(142, 4, false).setIconCoord(2, 14).setItemName(name("food.example.food"));
    public static final Item exampleTool = new ItemToolShovel(143, exampleToolMaterial).setIconCoord(3, 14).setItemName(name("tool.example.tool"));

    public static final Item exampleHelmet = new ItemArmor(144, exampleArmorMaterial, 0).setIconCoord(4, 14).setItemName(name("armor.example.helmet"));
    public static final Item exampleChestplate = new ItemArmor(145, exampleArmorMaterial, 1).setIconCoord(5, 14).setItemName(name("armor.example.chestplate"));
    public static final Item exampleLeggings = new ItemArmor(146, exampleArmorMaterial, 2).setIconCoord(6, 14).setItemName(name("armor.example.leggings"));
    public static final Item exampleBoots = new ItemArmor(147, exampleArmorMaterial, 3).setIconCoord(7, 14).setItemName(name("armor.example.boots"));

    // Blocks
    public static final Block exampleBlock = BlockHelper.createBlock(900, name("example.block"), 31, 0, Material.ground, Block.soundSandFootstep, 0.1f, 0.1f, 0.0f);
    public static final Block redMushroomCap = BlockHelper.createBlock(902, name("mushroom.cap.red"), 31, 1,  Material.cloth, Block.soundClothFootstep, 0.1f, 0.1f, 0.0f);
    public static final Block brownMushroomCap = BlockHelper.createBlock(903, name("mushroom.cap.brown"), 31, 2,  Material.cloth, Block.soundClothFootstep, 0.1f, 0.1f, 0.0f);
    public static final Block mushroomStem = BlockHelper.createBlock(904, name("mushroom.stem"), 31, 4, 31, 4, 31, 3, Material.cloth, Block.soundClothFootstep, 0.1f, 0.1f, 0.0f);
    public static final Block examplePortalBlock = new ExamplePortalBlock(901, 3, Block.glowstone.blockID, Block.fluidWaterStill.blockID).setBlockName("example.portal").setTexCoords(13, 12).setNotInCreativeMenu();
    static {
        ((BlockInterface) examplePortalBlock).callSetHardness(-1.0f);
        ((BlockInterface) examplePortalBlock).callSetStepSound(Block.soundGlassFootstep);
        ((BlockInterface) examplePortalBlock).callSetLightValue(0.75f);
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

        // Entity
        EntityHelper.createEntity(ExampleEntity.class, new RenderBiped(new ModelZombie(), 0.5f), 60, "Zotch");

        // Command
        CommandHelper.createCommand(new ExampleCommand());

        // Textures
        TextureHelper.addTextureToItems(MOD_ID, "example_item.png", 0, 14);
        TextureHelper.addTextureToItems(MOD_ID, "example_custom_item.png", 1, 14);
        TextureHelper.addTextureToItems(MOD_ID, "example_food.png", 2, 14);
        TextureHelper.addTextureToItems(MOD_ID, "example_tool.png", 3, 14);
        TextureHelper.addTextureToItems(MOD_ID, "example_helmet.png", 4, 14);
        TextureHelper.addTextureToItems(MOD_ID, "example_chestplate.png", 5, 14);
        TextureHelper.addTextureToItems(MOD_ID, "example_leggings.png", 6, 14);
        TextureHelper.addTextureToItems(MOD_ID, "example_boots.png", 7, 14);

        TextureHelper.addTextureToTerrain(MOD_ID, "example_block.png", 31, 0);
        TextureHelper.addTextureToTerrain(MOD_ID, "red_mushroom_cap.png", 31, 1);
        TextureHelper.addTextureToTerrain(MOD_ID, "brown_mushroom_cap.png", 31, 2);
        TextureHelper.addTextureToTerrain(MOD_ID, "mushroom_stem_side.png", 31, 3);
        TextureHelper.addTextureToTerrain(MOD_ID, "mushroom_stem.png", 31, 4);
    }
}
