package azurelmao.examplemod;

import net.minecraft.src.helper.DamageType;
import net.minecraft.src.material.ArmorMaterial;

public class ExampleArmorMaterial {
    public static final ArmorMaterial exampleArmorMaterial = new ArmorMaterial("examplenite", 3, 1000);
    static {
        ArmorMaterial.setProtectionValuePercent(exampleArmorMaterial, DamageType.FALL, 80.0f);
        ArmorMaterial.setProtectionValuePercent(exampleArmorMaterial, DamageType.GENERIC, 200.0f);
    }
}
