package turniplabs.examplemod.mixin;

import turniplabs.examplemod.ExampleMod;
import net.minecraft.src.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GuiMainMenu.class, remap = false)
public class ExampleMixin {

    // !!! Always prefix your mixin methods with your mod id. !!!
    // If a different mod mixins into the same class and it uses the same name it'll crash.


    // Mixin that injects a method call to `examplemod_someMethod` at the top (head) of `initGui`
    // What it actually does:
    //
    //      public void initGui() {
    //          examplemod_someMethod(ci);
    //          ...
    //      }
    //
    @Inject(method = "initGui", at = @At(value = "HEAD"))
    private void examplemod_someMethod(CallbackInfo ci) {
        ExampleMod.LOGGER.info("This line is printed by a mixin.");
    }

    // Mixin that injects a method call at the last line (before return)
    //
    //      public void initGui() {
    //          ...
    //          examplemod_otherMethod(ci);
    //          return;
    //      }
    //
    @Inject(method = "initGui", at = @At(value = "TAIL"))
    private void examplemod_otherMethod(CallbackInfo ci) {
        ExampleMod.LOGGER.info("This line is printed after the main menu is initialized.");
    }

    // If `cancellable` is set to true in the annotation `ci.cancel()` can be used to return out of the method that's being mixined.
    //
    //      public void initGui() {
    //          examplemod_anotherMethod(ci);
    //          if (ci.isCancelled()) return;
    //          ...
    //      }
    //
    @Inject(method = "initGui", at = @At(value = "HEAD"), cancellable = true)
    private void examplemod_anotherMethod(CallbackInfo ci) {
        boolean renderMenu = true; // change this to see for yourself

        if (renderMenu) {
            ExampleMod.LOGGER.info("Do nothing, menu will be rendered.");
        } else {
            ExampleMod.LOGGER.info("Don't render menu.");
            ci.cancel();
        }
    }

    // For more examples, please refer to:
    // https://fabricmc.net/wiki/tutorial:mixin_introduction
    // and
    // https://fabricmc.net/wiki/tutorial:mixin_examples
}
