package spring.restful.crud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class FiledDoesNotException extends RuntimeException{
    public FiledDoesNotException(String fieldName) {
        super(String.format("Field %s does not exists.",fieldName));
    }
}
