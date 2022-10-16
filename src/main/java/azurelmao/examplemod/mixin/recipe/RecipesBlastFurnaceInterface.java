package azurelmao.examplemod.mixin.recipe;

import net.minecraft.src.RecipesBlastFurnace;
import net.minecraft.src.RecipesFurnace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(value = RecipesBlastFurnace.class, remap = false)
public interface RecipesBlastFurnaceInterface {

    @Accessor("smeltingList")
    void setSmeltingList(Map map);
}
