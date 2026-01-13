package com.example.formsProject2;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MailValidator implements ConstraintValidator<GmailOnly, String> {
	@Override
    public boolean isValid(String s, ConstraintValidatorContext cvc) {
        s = s.toLowerCase();
        boolean result = s.contains("@gmail.com");
        return result;
    }
}
