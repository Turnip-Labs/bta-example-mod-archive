package azurelmao.examplemod.worldgen;

import azurelmao.examplemod.ExampleMod;
import net.minecraft.shared.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.BlockGrass;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

import java.util.Random;

public class GiantRedMushroom extends WorldGenerator {
    public final int capId;
    public final int stemId;
    public final int heightMod;

    public GiantRedMushroom() {
        this.capId = ExampleMod.redMushroomCap.blockID;
        this.stemId = ExampleMod.mushroomStem.blockID;
        this.heightMod = 4;
    }

    @Override
    public boolean generate(World world, Random random, int originX, int originY, int originZ) {
        int height = random.nextInt(6) + this.heightMod;
        boolean flag = true;
        if (originY >= 1 && originY + height + 1 <= Minecraft.WORLD_HEIGHT_BLOCKS) {
            int searchWidth;

            // Check if there is enough space for the tree
            for(int y = originY; y <= originY + height + 1; ++y) {
                searchWidth = 1;

                if (y == originY) {
                    searchWidth = 0;
                }

                if (y >= originY + height - 3) {
                    searchWidth = 2;
                }

                for(int x = originX - searchWidth ; x <= originX + searchWidth && flag; ++x) {

                    for(int z = originZ - searchWidth; z <= originZ + searchWidth && flag; ++z) {

                        if (y >= 0 && y < Minecraft.WORLD_HEIGHT_BLOCKS) {
                            int blockId = world.getBlockId(x, y, z);
                            if (blockId != 0 && blockId != this.capId) {
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag) {
                return false;
            } else {
                int blockBelowId = world.getBlockId(originX, originY - 1, originZ);
                // Can only spawn on grass or dirt
                if ((Block.blocksList[blockBelowId] instanceof BlockGrass || blockBelowId == Block.dirt.blockID) && originY < Minecraft.WORLD_HEIGHT_BLOCKS - height - 1) {
                    world.setBlockWithNotify(originX, originY - 1, originZ, Block.dirt.blockID);

                    int mushroomWidth = 2;

                    for (int y = height - 3; y < height; ++y) {

                        for (int x = -mushroomWidth + 1; x < mushroomWidth; ++x) {

                            // South part
                            if (!Block.opaqueCubeLookup[world.getBlockId(originX + x, originY + y, originZ + mushroomWidth)]) {
                                world.setBlockWithNotify(originX + x, originY + y, originZ + mushroomWidth, capId);
                            }

                            // North part
                            if (!Block.opaqueCubeLookup[world.getBlockId(originX + x, originY + y, originZ - mushroomWidth)]) {
                                world.setBlockWithNotify(originX + x, originY + y, originZ - mushroomWidth, capId);
                            }
                        }

                        for (int z = -mushroomWidth + 1; z < mushroomWidth; ++z) {

                            // East part
                            if (!Block.opaqueCubeLookup[world.getBlockId(originX + mushroomWidth, originY + y, originZ + z)]) {
                                world.setBlockWithNotify(originX + mushroomWidth, originY + y, originZ + z, capId);
                            }

                            // West part
                            if (!Block.opaqueCubeLookup[world.getBlockId(originX - mushroomWidth, originY + y, originZ + z)]) {
                                world.setBlockWithNotify(originX - mushroomWidth, originY + y, originZ + z, capId);
                            }
                        }
                    }

                    // Top part
                    for (int x = -mushroomWidth + 1; x < mushroomWidth; ++x) {
                        for (int z = -mushroomWidth + 1; z < mushroomWidth; ++z) {
                            if (!Block.opaqueCubeLookup[world.getBlockId(originX + x, originY + height, originZ + z)]) {
                                world.setBlockWithNotify(originX + x, originY + height, originZ + z, capId);
                            }
                        }
                    }

                    // Stem
                    for (int y = 0; y < height; ++y) {
                        int blockId = world.getBlockId(originX, originY + y, originZ);
                        if (blockId == 0) {
                            world.setBlockWithNotify(originX, originY + y, originZ, stemId);
                        }
                    }

                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}
