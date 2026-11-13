package com.nexuslink.client;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NexusLinkClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("nexuslink-client");

    @Override
    public void onInitializeClient() {
        LOGGER.info("NexusLink Client Initialized. Preparing UI and Networking hooks.");
    }
}
