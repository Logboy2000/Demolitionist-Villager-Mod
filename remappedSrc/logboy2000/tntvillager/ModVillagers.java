package logboy2000.tntvillager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;


public class ModVillagers {



    public static final PointOfInterestType TNT_POI = registerPOI("tnt_poi", ModBlocks.TNT_WORKSTATION);
    public static final VillagerProfession DEMOLITIONIST = registerProfession("demolitionist",
            RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(DemolitionistVillager.MOD_ID, "tnt_poi")));


    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type){
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(DemolitionistVillager.MOD_ID, name),
                makeProfession(DemolitionistVillager.MOD_ID + name, type, SoundEvents.ENTITY_VILLAGER_WORK_ARMORER));
    }

    private static VillagerProfession makeProfession(String id, RegistryKey<PointOfInterestType> workstation, SoundEvent workSound){
        return new VillagerProfession(id,
                entry -> entry.matches(poiTRegKey -> poiTRegKey.equals(workstation)),
                entry -> entry.matches(poiTRegKey -> poiTRegKey.equals(workstation)),
                ImmutableSet.of(),
                ImmutableSet.of(),
                workSound);
    }

    public static PointOfInterestType registerPOI(String name, Block block){
        return PointOfInterestHelper.register(new Identifier(DemolitionistVillager.MOD_ID, name),
                1,1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }
        public static void registerVillagers() {
        DemolitionistVillager.LOGGER.debug("Registering Demolitionist Villager");

    }


    public static void registerTrades(){
        TradeOfferHelper.registerVillagerOffers(DEMOLITIONIST, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD),
                            new ItemStack(Items.GUNPOWDER, 3),
                            2147483647,3,0.20f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD),
                            new ItemStack(Items.PAPER, 3),
                            2147483647,3,0.20f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(DEMOLITIONIST, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 5),
                            new ItemStack(Items.FLINT_AND_STEEL),
                            2147483647,10,0.20f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD),
                            new ItemStack(Items.SAND, 4),
                            2147483647,5,0.20f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(DEMOLITIONIST, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 5),
                            new ItemStack(Items.TNT),
                            2147483647,10,0.20f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, random.nextBetween(5, 8)),
                            new ItemStack(Items.TNT_MINECART),
                            2147483647,15,0.20f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(DEMOLITIONIST, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 5),
                            new ItemStack(Items.FIRE_CHARGE),
                            2147483647,15,0.20f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, random.nextBetween(1,3)),
                            new ItemStack(Items.FIREWORK_ROCKET, 5),
                            2147483647,10,0.20f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(DEMOLITIONIST, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(Items.CREEPER_HEAD),
                            2147483647,30,0.20f
                    ));
                });
    }
}




