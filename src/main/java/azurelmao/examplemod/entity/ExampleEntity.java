package azurelmao.examplemod.entity;

import net.minecraft.src.EntityZombie;
import net.minecraft.src.Item;
import net.minecraft.src.World;

public class ExampleEntity extends EntityZombie {

    public ExampleEntity(World world) {
        super(world);
        this.texture = "/mob/notchbie.png";
    }

    @Override
    protected int getDropItemId() {
        return Item.foodAppleGold.itemID;
    }

}
