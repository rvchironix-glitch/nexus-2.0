package com.nexuslink.networking;

import java.util.UUID;

public class SessionManager {
    private static boolean hosting = false;
    private static String sessionCode = "";

    public static void startHosting(String worldName) {
        hosting = true;
        sessionCode = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        TunnelRelayClient.registerSession(sessionCode);
    }

    public static void stopHosting() {
        hosting = false;
        sessionCode = "";
        TunnelRelayClient.unregisterSession();
    }

    public static boolean isHosting() {
        return hosting;
    }

    public static String getSessionCode() {
        return sessionCode;
    }
}
