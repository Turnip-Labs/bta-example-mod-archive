package azurelmao.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

import java.util.Random;

public class ExampleCustomItem extends Item {

    private Random rand;

    public ExampleCustomItem(int i) {
        super(i);
        this.rand = new Random();
    }

    public boolean isFull3D() {
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        Minecraft mc = Minecraft.getMinecraft();

        if (mc.objectMouseOver != null && mc.objectMouseOver.entityHit == null) {
            int x = mc.objectMouseOver.blockX;
            int y = mc.objectMouseOver.blockY;
            int z = mc.objectMouseOver.blockZ;

            Block block = Block.blocksList[mc.theWorld.getBlockId(x, y, z)];

            // Check if block is not air
            if (block.blockID > 0) {
                mc.theWorld.setBlockWithNotify(x, y, z, 0);

                for (int i = 0; i < 5; i++) {

                    // (particle, pos, motion)
                    world.spawnParticle("flame",
                            x + 0.5 + this.rand.nextFloat() - 0.5,
                            y + 0.5 + this.rand.nextFloat() - 0.5,
                            z + 0.5 + this.rand.nextFloat() - 0.5,
                            (this.rand.nextFloat() - 0.5) / 50 ,
                            (this.rand.nextFloat() - 0.5) / 50,
                            (this.rand.nextFloat() - 0.5) / 50);
                }

                // (entity, sound, volume, pitch)
                world.playSoundAtEntity(entityplayer, "mob.ghast.fireball", 0.5f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            }
        }

        entityplayer.swingItem();
        return itemstack;
    }
}
