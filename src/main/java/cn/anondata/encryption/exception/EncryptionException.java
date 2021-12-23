package cn.anondata.encryption.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class EncryptionException extends RuntimeException {
    
    private HttpStatus httpStatus;
    private String exceptionCode;
    private String exceptionDescription;

    public EncryptionException(EncryptionExceptionEnum exception){
        this.httpStatus = exception.getHttpStatus();
        this.exceptionCode = exception.getExceptionCode();
        this.exceptionDescription = exception.getExceptionDescription();
    }
}
