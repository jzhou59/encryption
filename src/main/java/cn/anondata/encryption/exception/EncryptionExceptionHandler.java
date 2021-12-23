package cn.anondata.encryption.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cn.anondata.encryption.domain.resp.CommonResp;

@ControllerAdvice
public class EncryptionExceptionHandler {

    @ExceptionHandler(value = { EncryptionException.class })
    public ResponseEntity<CommonResp> exceptionHandler(EncryptionException exception) {
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(CommonResp.builder().errCode(exception.getExceptionCode())
                        .errMsg(exception.getExceptionDescription()).build());
    }

}
