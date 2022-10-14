package azurelmao.examplemod.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = Minecraft.class, remap = false)
public interface ExampleAccessor {

    @Accessor("theMinecraft")
    static Minecraft getTheMinecraft() {
        throw new AssertionError();
    }
}
