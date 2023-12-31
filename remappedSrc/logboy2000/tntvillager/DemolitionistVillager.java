package logboy2000.tntvillager;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemolitionistVillager implements ModInitializer {
    public static final String MOD_ID = "tntvillager";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModVillagers.registerTrades();
        ModBlocks.registerModBlocks();
        ModVillagers.registerVillagers();
    }
}
