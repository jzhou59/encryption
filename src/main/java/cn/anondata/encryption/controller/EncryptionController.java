package cn.anondata.encryption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/hash")
    public CommonResp hash(@RequestParam("hashAlg") String hashAlg, @RequestParam("message") String message){
        return hashService.hash(hashAlg, message);
    }

    @PostMapping("/hmac")
    public CommonResp hmac(@RequestBody HMACReq hmacReq) {
        return hmacService.hmac(hmacReq.getHmacAlg(), hmacReq.getMessage(), hmacReq.getKey());
    }

    @GetMapping("/hmac")
    public CommonResp hmac(@RequestParam("hmacAlg") String hmacAlg, @RequestParam("message") String message, @RequestParam("key") String key){
        return hmacService.hmac(hmacAlg, message, key);
    }
}
