package com.bw.f22920.Models.MessagingModels;

public class MultiViewTypeModel {

    public static final int BOT_FIRST_MESSAGE_AUTOMATED = 0;
    public static final int USER_REPLY_MINICART_AUTOMATED = 1;
    public static final int BOT_REPLY_AUTOMATED_PERSONALIZE = 2;
    public static final int BOT_REPLY_TWOOPTIONS = 3;
    public static final int DELIVERER_JOINED = 4;
    public static final int PROFILE_PREVIEW = 5;
    public static final int DELIVERER_REPLY = 6;
    public static final int USER_REPLY_SEND = 7;
    public static final int DELIVERER_TRACK_ME = 8;

    public int type;
    public int data;
    public String text;

    public MultiViewTypeModel(int type,String text, int data) {
        this.type = type;
        this.data = data;
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
