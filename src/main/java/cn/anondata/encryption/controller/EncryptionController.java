package cn.anondata.encryption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.anondata.encryption.response.CommonResponse;
import cn.anondata.encryption.service.EncryptionService;

@RestController
@RequestMapping(value = "/encryption")
public class EncryptionController {

    @Autowired
    EncryptionService encryptionService;

    @GetMapping("/md5")
    public CommonResponse md5(@RequestParam("plainStr") String plainStr) {
        CommonResponse md5Resp = encryptionService.md5(plainStr);
        return md5Resp;
    }

    @GetMapping("/sha1")
    public CommonResponse sha1(@RequestParam("plainStr") String plainStr){
        CommonResponse sha1Resp = encryptionService.sha1(plainStr);
        return sha1Resp;
    }

    @GetMapping("/sha224")
    public CommonResponse sha224(@RequestParam("plainStr") String plainStr){
        CommonResponse sha224Resp = encryptionService.sha224(plainStr);
        return sha224Resp;
    }

    @GetMapping("/sha256")
    public CommonResponse sha256(@RequestParam("plainStr") String plainStr){
        CommonResponse sha256Resp = encryptionService.sha256(plainStr);
        return sha256Resp;
    }
    @GetMapping("/sha384")
    public CommonResponse sha384(@RequestParam("plainStr") String plainStr){
        CommonResponse sha384Resp = encryptionService.sha384(plainStr);
        return sha384Resp;
    }
    @GetMapping("/sha512")
    public CommonResponse sha512(@RequestParam("plainStr") String plainStr){
        CommonResponse sha512Resp = encryptionService.sha512(plainStr);
        return sha512Resp;
    }
}
