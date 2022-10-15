package azurelmao.examplemod;

import azurelmao.examplemod.mixin.CraftingManagerInvoker;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class RecipeHelper {

    private static final CraftingManager craftingManager = CraftingManager.getInstance();

    public static void createRecipe(Item item, int amount, Object[] aobj) {
        ((CraftingManagerInvoker) craftingManager).callAddRecipe(new ItemStack(item, amount), aobj);
    }

    public static void createShapelessRecipe(Item item, int amount, Object[] aobj) {
        ((CraftingManagerInvoker) craftingManager).callAddShapelessRecipe(new ItemStack(item, amount), aobj);
    }

}
