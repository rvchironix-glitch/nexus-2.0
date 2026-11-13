package com.nexuslink.friends;

public class Friend {
    private final String username;
    private final String uuid;
    private boolean online;
    private String currentServerSession;

    public Friend(String username, String uuid, boolean online) {
        this.username = username;
        this.uuid = uuid;
        this.online = online;
        this.currentServerSession = "";
    }

    public String getUsername() { return username; }
    public String getUuid() { return uuid; }
    public boolean isOnline() { return online; }
    public void setOnline(boolean online) { this.online = online; }
    public String getCurrentServerSession() { return currentServerSession; }
    public void setCurrentServerSession(String session) { this.currentServerSession = session; }
}
