package lv.javaguru.java2.services.exceptions;

/**
 * Created by Yekaterina Savelyeva
 * on 16.07.2018
 */

public class UserEditException extends RuntimeException {

    public  UserEditException(String message){
        super(message);
    }
}
