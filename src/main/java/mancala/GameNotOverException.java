package mancala;

import java.io.Serializable;

//AI Generated
public class GameNotOverException extends Exception implements Serializable {
    public GameNotOverException(String message) {
        super(message);
    }
}
