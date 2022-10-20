package azurelmao.examplemod;

import azurelmao.examplemod.mixin.entity.EntityListInterface;
import azurelmao.examplemod.mixin.entity.RenderManagerInterface;
import net.minecraft.src.*;

import java.util.Map;

public class EntityHelper {

    public static void createEntity(Class clazz, Render render, int id, String name) {
        Map entityRenderMap = ((RenderManagerInterface) RenderManager.instance).getEntityRenderMap();
        entityRenderMap.put(clazz, render);
        render.setRenderManager(RenderManager.instance);

        EntityListInterface.callAddMapping(clazz, name, id);
    }
}
