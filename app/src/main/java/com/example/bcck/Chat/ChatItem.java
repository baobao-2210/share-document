package com.example.bcck.Chat;

public class ChatItem {
    private String chatName;
    private String lastMessage;
    private String time;
    private String avatarText;
    private boolean isGroup;

    public ChatItem(String chatName, String lastMessage, String time, String avatarText, boolean isGroup) {
        this.chatName = chatName;
        this.lastMessage = lastMessage;
        this.time = time;
        this.avatarText = avatarText;
        this.isGroup = isGroup;
    }

    // Getters
    public String getChatName() { return chatName; }
    public String getLastMessage() { return lastMessage; }
    public String getTime() { return time; }
    public String getAvatarText() { return avatarText; }
    public boolean isGroup() { return isGroup; }
}