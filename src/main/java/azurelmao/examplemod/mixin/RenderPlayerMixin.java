package azurelmao.examplemod.mixin;

import net.minecraft.src.RenderPlayer;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = RenderPlayer.class, remap = false)
public class RenderPlayerMixin {

    // Mixin for custom armor sprites

    @Mutable
    @Final
    @Shadow
    private static String[] armorFilenamePrefix;

    static {
        armorFilenamePrefix = ArrayUtils.add(armorFilenamePrefix, "examplenite");
    }
}
