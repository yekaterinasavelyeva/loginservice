package lv.javaguru.java2.services.user.validators.impls;

import lv.javaguru.java2.services.user.validators.DataInputValidator;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by user Yekaterina Savelyeva
 * on 04.03.2019
 */

@Named("input_validator")
public class DataInputValidatorImpl implements DataInputValidator {


    public Set<ConstraintViolation<Object>> validate(Object object, Validator validator) {
       Set<ConstraintViolation<Object>> constraintViolations = validator
                .validate(object);
       return constraintViolations;
    }

    public String printErrorMessages(Set<ConstraintViolation<Object>> constraintViolations){
        String text = "";
        for (ConstraintViolation<Object> cv : constraintViolations) {
            text += String.format(
                    "Warning! %s",
                    cv.getMessage()) + "\n";
        }
        return text;
    }

    public String printErrorForSpecificField(Set<ConstraintViolation<Object>> constraintViolations, String field){
        String text = "";
        for (ConstraintViolation<Object> cv : constraintViolations) {
            if(cv.getPropertyPath().toString().equals(field)){
                text +=String.format("Warning! %s",
                        cv.getMessage()) + "\n";
            }
        }
        return text;
    }
}
