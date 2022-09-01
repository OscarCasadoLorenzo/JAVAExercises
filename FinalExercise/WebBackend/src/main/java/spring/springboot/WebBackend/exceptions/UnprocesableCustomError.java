package spring.springboot.WebBackend.exceptions;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.FieldError;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Optional;

@NoArgsConstructor
@Getter
public class UnprocesableCustomError{

    private String emailMismatch;
    private String nameMismatch;
    private String surnameMismatch;
    private String passwordMismatch;
    private String phoneMismatch;

    public void setEmailMismatch(FieldError emailMismatch) {
        if(emailMismatch != null)
            this.emailMismatch = emailMismatch.getDefaultMessage();
    }

    public void setNameMismatch(FieldError nameMismatch) {
        if(nameMismatch != null)
            this.nameMismatch = nameMismatch.getDefaultMessage();
    }

    public void setSurnameMismatch(FieldError surnameMismatch) {
        if(surnameMismatch != null)
            this.surnameMismatch = surnameMismatch.getDefaultMessage();
    }

    public void setPasswordMismatch(FieldError passwordMismatch) {
        if(passwordMismatch != null)
            this.passwordMismatch = passwordMismatch.getDefaultMessage();
    }

    public void setPhoneMismatch(FieldError phoneMismatch) {
        if(phoneMismatch != null)
            this.phoneMismatch = phoneMismatch.getDefaultMessage();
    }
}
