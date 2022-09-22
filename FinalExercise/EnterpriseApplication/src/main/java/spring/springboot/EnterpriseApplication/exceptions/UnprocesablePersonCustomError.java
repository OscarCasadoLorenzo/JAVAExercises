package spring.springboot.EnterpriseApplication.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
public class UnprocesablePersonCustomError {
    private String dniMismatch;

    private String emailMismatch;

    private String passwordMismatch;

    private String nameMismatch;

    private String surnameMismatch;

    private String phoneMismatch;

    public UnprocesablePersonCustomError(BindingResult bindingResult) {
        this.dniMismatch = bindingResult.getFieldError("dni").getDefaultMessage();
        this.emailMismatch = bindingResult.getFieldError("email").getDefaultMessage();
        this.passwordMismatch = bindingResult.getFieldError("password").getDefaultMessage();
        this.nameMismatch = bindingResult.getFieldError("name").getDefaultMessage();
        this.surnameMismatch = bindingResult.getFieldError("surname").getDefaultMessage();
        this.phoneMismatch = bindingResult.getFieldError("phone").getDefaultMessage();
    }
}
