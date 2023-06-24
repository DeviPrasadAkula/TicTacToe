package TicTocToe.Exceptions;
import java.lang.Exception;

public class InvalidGameException extends Exception{

    public InvalidGameException(String Message){
        super(Message);
    }
}
