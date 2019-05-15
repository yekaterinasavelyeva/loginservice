package lv.javaguru.java2.services.user.validators;

import lv.javaguru.java2.domain.UserState;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by user
 * on 01.03.2019
 */

public interface DataInputValidator {

    Set<ConstraintViolation<Object>> validate(Object object, Validator validator);
    String printErrorMessages(Set<ConstraintViolation<Object>> constraintViolations);
    String printErrorForSpecificField(Set<ConstraintViolation<Object>> constraintViolations, String field);

}
