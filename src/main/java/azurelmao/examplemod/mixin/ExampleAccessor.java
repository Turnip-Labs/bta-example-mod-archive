package azurelmao.examplemod.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = Minecraft.class, remap = false)
public interface ExampleAccessor {

    // Accessors are used to get or set fields which have protected or private access or are final

    // Static fields have to throw an AssertionError
    @Accessor("theMinecraft")
    static Minecraft getTheMinecraft() {
        throw new AssertionError();
    }

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
    // Check RenderManagerInterface for a practical example.
}
