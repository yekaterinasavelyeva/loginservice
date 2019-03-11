package lv.javaguru.java2.services.user.validators.impls;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by user
 * on 04.03.2019
 */

public class ValidationUtils {


    public static Set<ConstraintViolation<Object>> validate(Object object, Validator validator) {
       Set<ConstraintViolation<Object>> constraintViolations = validator
                .validate(object);
       return constraintViolations;
    }

    public static String printErrorMessages(Set<ConstraintViolation<Object>> constraintViolations){
        String text = "";
        for (ConstraintViolation<Object> cv : constraintViolations) {
            text += String.format(
                    "Warning! %s",
                    cv.getMessage()) + "\n";
        }
        return text;
    }

    public static String printErrorForUsername(Set<ConstraintViolation<Object>> constraintViolations){
        for (ConstraintViolation<Object> cv : constraintViolations) {
            return (cv.getPropertyPath().equals("firstName"))? String.format("Warning! %s",
                        cv.getMessage()) + "\n": "";
        }
        return "";
    }

    public static String printErrorForLastName(Set<ConstraintViolation<Object>> constraintViolations){
        for (ConstraintViolation<Object> cv : constraintViolations) {
            return (cv.getPropertyPath().equals("lastName"))? String.format("Warning! %s",
                    cv.getMessage()) + "\n": "";
        }
        return "";
    }

}
