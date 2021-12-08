package cn.anondata.encryption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.anondata.encryption.domain.req.HMACReq;
import cn.anondata.encryption.domain.req.HashReq;
import cn.anondata.encryption.domain.resp.CommonResp;
import cn.anondata.encryption.service.HMACService;
import cn.anondata.encryption.service.HashService;

@RestController
@RequestMapping(value = "/encryption")
public class EncryptionController {

    @Autowired
    HashService hashService;

    @Autowired
    HMACService hmacService;

    @PostMapping("/hash")
    public CommonResp hash(@RequestBody HashReq hashReq) {
        return hashService.hash(hashReq.getHashAlg(), hashReq.getMessage());
    }

    @PostMapping("/hmac")
    public CommonResp hmac(@RequestBody HMACReq hmacReq) {
        return hmacService.hmac(hmacReq.getHmacAlg(), hmacReq.getMessage(), hmacReq.getKey());
    }
}
