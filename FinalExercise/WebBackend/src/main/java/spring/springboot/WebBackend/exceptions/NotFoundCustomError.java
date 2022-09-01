package spring.springboot.WebBackend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class NotFoundCustomError {
    private Date timestamp;
    private String message;
    private int HttpCode;
}
