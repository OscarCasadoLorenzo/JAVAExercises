package spring.springboot.EnterpriseApplication.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
public class UnprocesablePersonCustomError {
    private String dni;

    private String email;

    private String password;

    private String name;

    private String surname;

    private String phone;

    public void setDni(FieldError dniMismatch) {
        if(dniMismatch != null)
            this.dni = dniMismatch.getDefaultMessage();
    }

    public void setEmail(FieldError emailMismatch) {
        if(emailMismatch != null)
            this.email = emailMismatch.getDefaultMessage();    }

    public void setPassword(FieldError passwordMismatch) {
        if(passwordMismatch != null)
            this.password = passwordMismatch.getDefaultMessage();    }

    public void setName(FieldError nameMismatch) {
        if(nameMismatch != null)
            this.name = nameMismatch.getDefaultMessage();    }

    public void setSurname(FieldError surnameMismatch) {
        if(surnameMismatch != null)
            this.surname = surnameMismatch.getDefaultMessage();    }

    public void setPhone(FieldError phoneMismatch) {
        if(phoneMismatch != null)
            this.phone = phoneMismatch.getDefaultMessage();    }
}
