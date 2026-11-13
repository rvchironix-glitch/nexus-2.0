package com.nexuslink;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NexusLinkMod implements ModInitializer {
    public static final String MOD_ID = "nexuslink";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing NexusLink Multiplayer & Social Core...");
    }
}
