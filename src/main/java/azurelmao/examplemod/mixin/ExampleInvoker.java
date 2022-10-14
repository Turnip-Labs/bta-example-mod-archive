package azurelmao.examplemod.mixin;

import net.minecraft.src.Block;
import net.minecraft.src.StepSound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value = Block.class, remap = false)
public interface ExampleInvoker {

    @Invoker("setHardness")
    Block callSetHardness(float f); // name of method MUST NOT be the same as the method that's being invoked

    @Invoker("setResistance")
    Block callSetResistance(float f);

    @Invoker("setStepSound")
    Block callSetStepSound(StepSound stepSound);

    @Invoker("setLightValue")
    Block callSetLightValue(float f);
}
