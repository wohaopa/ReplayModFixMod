package com.github.wohaopa.replaymodfixmod.mixins;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.replaymod.lib.it.unimi.dsi.fastutil.objects.Object2IntMap;
import com.replaymod.lib.it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import com.replaymod.replaystudio.us.myles.ViaVersion.api.data.MappingDataLoader;

@Mixin(MappingDataLoader.class)
public abstract class MappingDataLoaderMixin {

    /**
     * @author wohaopa
     * @reason Gson 2.2.4 has no JsonObject.size()
     */
    @Overwrite(remap = false)
    public static Object2IntMap<String> indexedObjectToMap(JsonObject object) {
        Set<Map.Entry<String, JsonElement>> set = object.entrySet();
        Object2IntMap<String> map = new Object2IntOpenHashMap(set.size() * 2, 1.0F);
        map.defaultReturnValue(-1);
        Iterator var2 = set.iterator();

        while (var2.hasNext()) {
            Map.Entry<String, JsonElement> entry = (Map.Entry) var2.next();
            map.put(entry.getValue().getAsString(), Integer.parseInt(entry.getKey()));
        }

        return map;
    }
}
