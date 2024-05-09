package mancala;

import java.io.Serializable;

public class NoSuchPlayerException extends Exception implements Serializable {
    public NoSuchPlayerException(String message) {
        super(message);
    }
}
