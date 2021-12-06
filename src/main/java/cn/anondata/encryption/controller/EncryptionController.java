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
}
