package turniplabs.examplemod;

import net.minecraft.src.BlockPortal;
import net.minecraft.src.World;

import java.util.Random;

public class ExamplePortalBlock extends BlockPortal {

    public ExamplePortalBlock(int id, int targetDimension, int portalMaterialId, int portalTriggerId) {
        super(id, targetDimension, portalMaterialId, portalTriggerId);
    }

    public void randomDisplayTick(World world, int i, int j, int k, Random random) {
        int meta = world.getBlockMetadata(i, j, k);
        if ((meta & 2) > 0 && random.nextInt(20) == 0) {
            world.playSoundEffect((double)i + 0.5, (double)j + 0.5, (double)k + 0.5, "portal.portal", 0.5F, random.nextFloat() * 0.4F + 0.8F);
        }

        for(int l = 0; l < 4; ++l) {
            double d = (float)i + random.nextFloat();
            double d1 = (float)j + random.nextFloat();
            double d2 = (float)k + random.nextFloat();
            double d3;
            double d4;
            double d5;
            int i1 = random.nextInt(2) * 2 - 1;
            d3 = ((double)random.nextFloat() - 0.5) * 0.5;
            d4 = ((double)random.nextFloat() - 0.5) * 0.5;
            d5 = ((double)random.nextFloat() - 0.5) * 0.5;
            if (world.getBlockId(i - 1, j, k) != this.blockID && world.getBlockId(i + 1, j, k) != this.blockID) {
                d = (double)i + 0.5 + 0.25 * (double)i1;
                d3 = random.nextFloat() * 2.0F * (float)i1;
            } else {
                d2 = (double)k + 0.5 + 0.25 * (double)i1;
                d5 = random.nextFloat() * 2.0F * (float)i1;
            }

            world.spawnParticle("splash", d, d1, d2, d3, d4, d5);
        }
    }

}
