package com.BitirmeProjesi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CustomDateValidator implements ConstraintValidator<CustomDateConstraint, LocalDate> {
    private static final String DATE_PATTERN = "dd-MM-yyyy";

    @Override
    public void initialize(CustomDateConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        try
        {
            sdf.setLenient(false);
            Date d = sdf.parse(String.valueOf(value));
            return true;
        }
        catch (ParseException e)
        {
            return false;
        }
    }
}
