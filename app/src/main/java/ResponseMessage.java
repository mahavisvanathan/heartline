package com.example.mahalakshumi.fireapp;

public class ResponseMessage {
    String textMessage;
    boolean isme;

    public ResponseMessage(String textMessage, boolean isme) {
        this.textMessage = textMessage;
        this.isme = isme;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public boolean isIsme() {
        return isme;
    }

    public void setIsme(boolean isme) {
        this.isme = isme;
    }


}
