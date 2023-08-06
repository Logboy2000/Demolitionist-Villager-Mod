package logboy2000.tntvillager;

import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Blocks;

public class ModPoiTypes {
    public static PoiType TNT_POI;
    public static void registerPOIs() {
        TNT_POI = PointOfInterestHelper.register(new ResourceLocation(DemolitionistVillager.MOD_ID,"tnt_villager"), 1, 1, Blocks.ORANGE_WOOL);
    }
}
