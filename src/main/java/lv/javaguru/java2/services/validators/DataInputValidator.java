package lv.javaguru.java2.services.validators;

/**
 * Created by Yekaterina Savelyeva
 * on 16.07.2018
 */

public interface DataInputValidator {

    void validateInput(String input);

    void validateData(Long userId, String input);
}
