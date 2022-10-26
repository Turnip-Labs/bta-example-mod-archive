package azurelmao.examplemod.entity;

import net.minecraft.src.EntityZombie;
import net.minecraft.src.Item;
import net.minecraft.src.World;

public class ExampleEntity extends EntityZombie {

    public ExampleEntity(World world) {
        super(world);
        this.texture = "/mob/zotch.png";
    }

    @Override
    protected int getDropItemId() {
        return Item.foodAppleGold.itemID;
    }

    @Override
    protected void dropFewItems() {
        int i = this.getDropItemId();
        if (i > 0) {
            this.dropItem(i, 1);
        }
    }

}
