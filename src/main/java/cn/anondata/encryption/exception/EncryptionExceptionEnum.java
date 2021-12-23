package cn.anondata.encryption.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EncryptionExceptionEnum {
    OK(HttpStatus.OK,"0","SUCCESS"),

    HASH_NO_PROVIDED(HttpStatus.NOT_FOUND, "40401", "Requested hash algorithm is not supported. Please check parameters or create a pr/issue."),

    HMAC_NO_PROVIDED(HttpStatus.NOT_FOUND, "40402", "Requested hmac algorithm is not supported. Please check parameters or create a pr/issue."),

    SYMMETRY_NO_PROVIDED(HttpStatus.NOT_FOUND, "4040301", "Requested symmetric encryption algorithm is not supported. Please check parameters or create a pr/issue."),

    SYMMETRY_INVALID_KEY(HttpStatus.UNPROCESSABLE_ENTITY, "4220302", "Requested key is invalid(invalid encoding, wrong length, uninitialized, etc). Please check parameters or create a pr/issue."),

    SYMMETRY_NO_SUCH_PADDING(HttpStatus.UNPROCESSABLE_ENTITY, "4220303", "Requested padding mechanism is not available in the environment. Please check parameters or create a pr/issue."),

    SYMMETRY_INVALID_PARAMETER(HttpStatus.UNPROCESSABLE_ENTITY, "4220304", "Requested algorithm parameters is in appropriate. Please check parameters or create a pr/issue."),

    SYMMETRY_INTERNAL_SERVER(HttpStatus.INTERNAL_SERVER_ERROR, "5000305", "Internal server comes across an error(provider not existed, illegal block size, bad padding, etc). Please check parameters or create a pr/issue.");


    private HttpStatus httpStatus;
    private String exceptionCode;
    private String exceptionDescription;
}
