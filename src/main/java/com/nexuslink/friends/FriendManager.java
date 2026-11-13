package com.nexuslink.friends;

import java.util.ArrayList;
import java.util.List;

public class FriendManager {
    private static final List<Friend> friendsList = new ArrayList<>();

    public static void addFriend(String username, String uuid) {
        friendsList.add(new Friend(username, uuid, true));
    }

    public static void removeFriend(String uuid) {
        friendsList.removeIf(f -> f.getUuid().equals(uuid));
    }

    public static List<Friend> getFriendsList() {
        return friendsList;
    }
}
