package com.nexuslink.networking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TunnelRelayClient {
    private static final Logger LOGGER = LoggerFactory.getLogger("nexuslink-relay");

    public static void registerSession(String code) {
        LOGGER.info("Registered multiplayer tunnel session with code: {}", code);
    }

    public static void unregisterSession() {
        LOGGER.info("Unregistered multiplayer tunnel session.");
    }
}
