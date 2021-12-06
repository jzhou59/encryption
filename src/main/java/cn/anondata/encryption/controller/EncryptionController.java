package cn.anondata.encryption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.anondata.encryption.response.CommonResponse;
import cn.anondata.encryption.service.EncryptionService;

@Controller
@RequestMapping(value = "/encryption")
public class EncryptionController {
    
    @Autowired
    EncryptionService encryptionService;

    @GetMapping("/md5")
    public ResponseEntity<CommonResponse> md5(@RequestParam("plainStr") String plainStr){
        CommonResponse md5Resp = encryptionService.md5(plainStr);
        return ResponseEntity.ok(md5Resp);
    }

    @GetMapping("/sha1")
    public ResponseEntity<CommonResponse> sha1(@RequestParam("plainStr") String plainStr){
        //todo sha1
        CommonResponse sha1Resp = CommonResponse.builder().errCode("0").errMsg("no error").result(plainStr).build();
        return ResponseEntity.ok(sha1Resp);
    }

    @GetMapping("/sha256")
    public ResponseEntity<CommonResponse> sha256(@RequestParam("plainStr") String plainStr){
        //todo sha256
        CommonResponse sha256Resp = CommonResponse.builder().errCode("0").errMsg("no error").result(plainStr).build();
        return ResponseEntity.ok(sha256Resp);
    }

    @GetMapping("sha512")
    public ResponseEntity<CommonResponse> sha512(@RequestParam("planStr") String plainStr){
        //todo sha512
        CommonResponse sha512Resp = CommonResponse.builder().errCode("0").errMsg("no error").result(plainStr).build();
        return ResponseEntity.ok(sha512Resp);
    }
}
