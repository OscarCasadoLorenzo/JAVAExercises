package spring.springboot.EnterpriseApplication.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

@NoArgsConstructor
@Getter
public class UnprocesableTicketCustomError {
    private String dniMismatch;
    private String emailMismatch;
    private String nameMismatch;
    private String surnameMismatch;
    private String passwordMismatch;
    private String phoneMismatch;

    public void setDniMismatch(FieldError dniMismatch) {
        if(dniMismatch != null)
            this.dniMismatch = dniMismatch.getDefaultMessage();
    }

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
