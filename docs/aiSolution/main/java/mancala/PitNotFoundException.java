package mancala;

import java.io.Serializable;

public class PitNotFoundException extends Exception implements Serializable {
    public PitNotFoundException(String message) {
        super(message);
    }
}
