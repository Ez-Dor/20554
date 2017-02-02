package Mmn16.Q1;

import java.io.Serializable;

/**
 * This class defines the different type of messages that will be exchanged between the
 * Clients and the Server.
 */
public class ChatMessage implements Serializable {

    protected static final long serialVersionUID = 1112122200L;

    static final int WHO_IS_IN = 0, MESSAGE = 1, LOGOUT = 2;
    private int type;
    private String message;

    ChatMessage(int type, String message) {
        this.type = type;
        this.message = message;
    }

    int getType() {
        return type;
    }

    String getMessage() {
        return message;
    }
}
