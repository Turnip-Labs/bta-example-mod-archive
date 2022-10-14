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
}
