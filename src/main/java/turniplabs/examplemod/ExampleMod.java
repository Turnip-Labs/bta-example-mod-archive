package turniplabs.examplemod;

import turniplabs.halplibe.helper.*;
import turniplabs.halplibe.mixin.accessors.BlockAccessor;
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

    public static boolean probability(Random rand, double percent) {
        return percent > 0 && rand.nextInt(100) <= percent;
    }

    // Armor/tool materials
    public static final ArmorMaterial exampleArmorMaterial = ArmorHelper.createArmorMaterial("examplenite", 1000, 0.0f, 200.0f, 0.0f, 200.0f);
    public static final ToolMaterial exampleToolMaterial = new ToolMaterial().setDurability(16).setEfficiency(10.0f, 100.0f).setMiningLevel(0).setBlockHitDelay(0);
    
    // Items
    public static final Item exampleItem = ItemHelper.createItem(MOD_ID, new Item(140), "exampleitem", "example_item.png");
    public static final Item exampleCustomItem = ItemHelper.createItem(MOD_ID, new ExampleCustomItem(141), "customitem", "example_custom_item.png");
    public static final Item exampleFood = ItemHelper.createItem(MOD_ID, new ItemFood(142, 4, false), "food.example", "example_food.png");
    public static final Item exampleTool = ItemHelper.createItem(MOD_ID, new ItemToolShovel(143, exampleToolMaterial), "tool.shovel.example", "example_tool.png");

    public static final Item exampleHelmet = ItemHelper.createItem(MOD_ID, new ItemArmor(144, exampleArmorMaterial, 0), "armor.helmet.example", "example_helmet.png");
    public static final Item exampleChestplate = ItemHelper.createItem(MOD_ID, new ItemArmor(145, exampleArmorMaterial, 1), "armor.chestplate.example", "example_chestplate.png");
    public static final Item exampleLeggings = ItemHelper.createItem(MOD_ID, new ItemArmor(146, exampleArmorMaterial, 2), "armor.leggings.example", "example_leggings.png");
    public static final Item exampleBoots = ItemHelper.createItem(MOD_ID, new ItemArmor(147, exampleArmorMaterial, 3), "armor.boots.example", "example_boots.png");

    // Blocks
    public static final Block exampleBlock = BlockHelper.createBlock(MOD_ID, new Block(900, Material.ground), "example", "example_block.png", Block.soundSandFootstep, 0.1f, 0.1f, 0.0f);
    public static final Block redMushroomCap = BlockHelper.createBlock(MOD_ID, new Block(902, Material.cloth), "mushroom.cap.red", "red_mushroom_cap.png", Block.soundClothFootstep, 0.1f, 0.1f, 0.0f);
    public static final Block brownMushroomCap = BlockHelper.createBlock(MOD_ID, new Block(903, Material.cloth), "mushroom.cap.brown", "brown_mushroom_cap.png", Block.soundClothFootstep, 0.1f, 0.1f, 0.0f);
    public static final Block mushroomStem = BlockHelper.createBlock(MOD_ID, new Block(904, Material.cloth), "mushroom.stem", "mushroom_stem.png", "mushroom_stem_side.png", Block.soundClothFootstep, 0.1f, 0.1f, 0.0f);
    public static final Block examplePortalBlock = new ExamplePortalBlock(901, 3, Block.glowstone.blockID, Block.fluidWaterStill.blockID).setBlockName("portal.example").setTexCoords(13, 12).setNotInCreativeMenu();
    static {
        ((BlockAccessor) examplePortalBlock).callSetHardness(-1.0f);
        ((BlockAccessor) examplePortalBlock).callSetStepSound(Block.soundGlassFootstep);
        ((BlockAccessor) examplePortalBlock).callSetLightValue(0.75f);
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
    }
}
