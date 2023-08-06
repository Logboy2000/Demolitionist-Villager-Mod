package logboy2000.tntvillager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.npc.VillagerProfession;


public class ModVillagers {
    public static VillagerProfession DEMOLITIONIST;

    public static void registerVillagers() {
        DemolitionistVillager.LOGGER.debug("Registering Demolitionist Villager");
        DEMOLITIONIST = Registry.register(Registries.VILLAGER_PROFESSION,
                new ResourceLocation(DemolitionistVillager.MOD_ID,"tntvillager"),
                new VillagerProfession(
                "tntvillager",
                holder -> holder.value().equals(ModPoiTypes.TNT_POI),
                holder -> !holder.value().equals(ModPoiTypes.TNT_POI),
                ImmutableSet.of(),
                ImmutableSet.of(),
                SoundEvents.VILLAGER_WORK_ARMORER));
    }
}




