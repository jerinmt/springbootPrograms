package com.example.formsProject2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = MailValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } ) 
@Retention(RetentionPolicy.RUNTIME) 
public @interface GmailOnly {
     
    public String message() default "Your email must be from Gmail"; 
    public Class<?>[] groups() default {}; 
    public Class<? extends Payload>[] payload() default {}; 
} 