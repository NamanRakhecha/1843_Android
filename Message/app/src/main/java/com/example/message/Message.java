package com.example.message;

import java.io.Serializable;

public class Message implements Serializable {

    String message;
    String sentby;

    public Message(String message, String sentby) {
        this.message = message;
        this.sentby = sentby;
    }

}
