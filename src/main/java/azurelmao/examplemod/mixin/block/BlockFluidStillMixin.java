package azurelmao.examplemod.mixin.block;

import azurelmao.examplemod.ExampleMod;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFluidStill;
import net.minecraft.src.BlockPortal;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = BlockFluidStill.class, remap = false)
public class BlockFluidStillMixin {

    // We don't need an @Inject annotation here because BlockFluidStill does not implement `onBlockAdded()`
    // If you wanted to do the same for BlockFire, you would have to use @Inject
    public void onBlockAdded(World world, int i, int j, int k) {
        if (world.getBlockId(i, j - 1, k) == Block.glowstone.blockID) {
            ((BlockPortal) ExampleMod.examplePortalBlock).tryToCreatePortal(world, i, j, k);
        }
    }
}



