package mancala;

import java.io.Serializable;

public class InvalidMoveException extends Exception implements Serializable {
    public InvalidMoveException(String message) {
        super(message);
    }
}

