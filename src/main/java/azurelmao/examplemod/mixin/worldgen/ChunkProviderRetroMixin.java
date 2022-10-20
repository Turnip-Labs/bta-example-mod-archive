package azurelmao.examplemod.mixin.worldgen;

import azurelmao.examplemod.worldgen.GiantBrownMushroom;
import azurelmao.examplemod.worldgen.GiantRedMushroom;
import net.minecraft.src.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(value = ChunkProviderRetro.class, remap = false)
public class ChunkProviderRetroMixin {

    @Shadow
    private Random rand;

    @Shadow
    public NoiseGeneratorOctaves mobSpawnerNoise;

    @Shadow
    private World worldObj;

    private boolean probability(int percent) {
        return percent != 0 && rand.nextInt(100) >= 100 - percent;
    }

    @Inject(method = "populate", at = @At(value = "RETURN"))
    private void examplemod_populate(IChunkProvider ichunkprovider, int chunkX, int chunkZ, CallbackInfo ci) {
        // Chunk positions in blocks, at the corner of the chunk
        int preX = chunkX * 16;
        int preZ = chunkZ * 16;

        // Noise
        int magicValue = (int)((mobSpawnerNoise.func_806_a((double)preX / 2, (double)preZ / 2) / 8.0 + rand.nextDouble() * 4.0 + 4.0) / 3.0);
        if (magicValue < 0) {
            magicValue = 0;
        }

        // Put the tree declaration here if you want bunching behaviour - trees will generate more or less in groups

        for (int i = 0; i < magicValue; ++i) {

            // 50% chance for the other mushroom to appear
            Object tree = new GiantRedMushroom();
            if (probability(50)) {
                tree = new GiantBrownMushroom();
            }

            int x = preX + rand.nextInt(16) + 8;
            int z = preZ + rand.nextInt(16) + 8;
            ((WorldGenerator) tree).func_517_a(1.0, 1.0, 1.0);
            ((WorldGenerator) tree).generate(worldObj, rand, x, worldObj.getHeightValue(x, z), z);
        }
    }
}