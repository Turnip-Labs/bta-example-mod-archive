package azurelmao.examplemod.mixin;

import net.minecraft.src.RenderPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = RenderPlayer.class, remap = false)
public interface ExampleAccessor {

    // Accessors are used to get or set fields which have protected or private access or are final

    // Non-static fields are set like this:
    //
    //      @Accessor("field")
    //      void setField(type x); // type must be the same as the field's type
    //
    // And get like this:
    //
    //      @Accessor("field")
    //      type getField();
    //
    @Accessor("armorFilenamePrefix")
    static String[] getArmorFilenamePrefix() {
        throw new AssertionError();
    }

    @Accessor("armorFilenamePrefix")
    static void setArmorFilenamePrefix(String[] strings) {
        throw new AssertionError();
    }
}
