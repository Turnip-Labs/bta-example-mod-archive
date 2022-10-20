package azurelmao.examplemod;

import azurelmao.examplemod.mixin.ExampleInvoker;
import net.minecraft.src.*;

public class BlockHelper {

    public static Block createBlock(int id, String name, int x, int y, Material material, StepSound stepSound, float hardness, float resistance, float lightValue) {
        Block block = new Block(id, material);
        block.setTexCoords(x, y);
        block.setBlockName(name);

        ((ExampleInvoker) block).callSetHardness(hardness);
        ((ExampleInvoker) block).callSetResistance(resistance);
        ((ExampleInvoker) block).callSetStepSound(stepSound);
        ((ExampleInvoker) block).callSetLightValue(lightValue);

        Item.itemsList[block.blockID] = new ItemBlock(block.blockID - Block.blocksList.length);

        return block;
    }

    public static Block createBlock(int id, String name, int topX, int topY, int bottomX, int bottomY, int sidesX, int sidesY, Material material, StepSound stepSound, float hardness, float resistance, float lightValue) {
        Block block = new Block(id, material);
        block.setTexCoords(topX, topY, bottomX, bottomY, sidesX, sidesY);
        block.setBlockName(name);

        ((ExampleInvoker) block).callSetHardness(hardness);
        ((ExampleInvoker) block).callSetResistance(resistance);
        ((ExampleInvoker) block).callSetStepSound(stepSound);
        ((ExampleInvoker) block).callSetLightValue(lightValue);

        Item.itemsList[block.blockID] = new ItemBlock(block.blockID - Block.blocksList.length);

        return block;
    }

    public static Block createBlock(int id, String name, int topX, int topY, int bottomX, int bottomY, int northX, int northY, int eastX, int eastY, int southX, int southY, int westX, int westY, Material material, StepSound stepSound, float hardness, float resistance, float lightValue) {
        Block block = new Block(id, material);
        block.setTexCoords(topX, topY, bottomX, bottomY, northX, northY, eastX, eastY, southX, southY, westX, westY);
        block.setBlockName(name);

        ((ExampleInvoker) block).callSetHardness(hardness);
        ((ExampleInvoker) block).callSetResistance(resistance);
        ((ExampleInvoker) block).callSetStepSound(stepSound);
        ((ExampleInvoker) block).callSetLightValue(lightValue);

        Item.itemsList[block.blockID] = new ItemBlock(block.blockID - Block.blocksList.length);

        return block;
    }
}
