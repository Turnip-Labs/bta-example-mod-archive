package azurelmao.examplemod.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = Minecraft.class, remap = false)
public interface ExampleAccessor {

    // Accessors are used to get or set fields which have protected or private access

    @Accessor("theMinecraft")
    static Minecraft getTheMinecraft() {
        throw new AssertionError();
    }
}
