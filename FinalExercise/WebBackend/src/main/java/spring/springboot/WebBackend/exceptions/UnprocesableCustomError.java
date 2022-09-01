package spring.springboot.WebBackend.exceptions;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Optional;

@AllArgsConstructor
@Getter
public class UnprocesableCustomError{

    private Optional<String> emailMismatch;
    private Optional<String> nameMismatch;
    private Optional<String> surnameMismatch;
    private Optional<String> passwordMismatch;
    private Optional<String> phoneMismatch;
}
