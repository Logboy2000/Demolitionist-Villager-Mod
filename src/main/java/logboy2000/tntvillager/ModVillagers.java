package logboy2000.tntvillager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;


public class ModVillagers {



    public static final PointOfInterestType TNT_POI = registerPOI("tnt_poi", ModBlocks.TNT_WORKSTATION);
    public static final VillagerProfession DEMOLITIONIST = registerProfession("demolitionist",
            RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(), new Identifier(DemolitionistVillager.MOD_ID, "tnt_poi")));


    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(DemolitionistVillager.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(DemolitionistVillager.MOD_ID, name)).workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build());
    }

    public static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(DemolitionistVillager.MOD_ID, name),
                1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
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
                            6,2,0.20f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(Items.FLINT_AND_STEEL),
                            6,2,0.20f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(DEMOLITIONIST, 2,
                factories -> {


                    Enchantment enchantment = Enchantments.BLAST_PROTECTION; // Change this to the desired enchantment
                    int enchantmentLevel = 0;
                    while (enchantmentLevel==0){
                        enchantmentLevel = Random.create().nextInt(4);// Change this to the desired enchantment level
                    }
                    ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK);
                    enchantedBook.addEnchantment(enchantment, enchantmentLevel);

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD),
                            new ItemStack(enchantedBook.getItem()),
                            6,2,0.20f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(DEMOLITIONIST, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD),
                            new ItemStack(Items.GUNPOWDER, 3),
                            6,2,0.20f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(DEMOLITIONIST, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD),
                            new ItemStack(Items.FIREWORK_STAR, 3),
                            6,2,0.20f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(DEMOLITIONIST, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(Items.CREEPER_HEAD),
                            6,2,0.20f
                    ));
                });
    }
}




