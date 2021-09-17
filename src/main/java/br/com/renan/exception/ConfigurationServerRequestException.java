package br.com.renan.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ConfigurationServerRequestException extends Exception{

    private static final long serialVersionUID = 1L;

    public ConfigurationServerRequestException(final String message) {
        super(message);
    }
}
