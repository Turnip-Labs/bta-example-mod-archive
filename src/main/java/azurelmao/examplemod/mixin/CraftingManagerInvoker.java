package azurelmao.examplemod.mixin;

import net.minecraft.src.CraftingManager;
import net.minecraft.src.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value = CraftingManager.class, remap = false)
public interface CraftingManagerInvoker {

    @Invoker("addRecipe")
    void callAddRecipe(ItemStack itemstack, Object[] aobj);

    @Invoker("addShapelessRecipe")
    void callAddShapelessRecipe(ItemStack itemstack, Object[] aobj);
}
