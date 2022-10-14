package azurelmao.examplemod;

import azurelmao.examplemod.mixin.ExampleInvoker;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.Material;
import net.minecraft.src.StepSound;

public class BlockHelper {

    public static Block createBlock(int id, String name, Material material, StepSound stepSound, int x, int y,  float hardness, float resistance,float lightValue) {
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
