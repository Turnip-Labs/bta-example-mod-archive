package azurelmao.examplemod.mixin.entity;

import net.minecraft.src.RenderManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(value = RenderManager.class, remap = false)
public interface RenderManagerInterface {

    @Accessor("entityRenderMap")
    Map getEntityRenderMap();

    @Accessor("entityRenderMap")
    void setEntityRenderMap(Map map);
}
