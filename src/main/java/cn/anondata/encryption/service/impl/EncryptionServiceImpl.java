package cn.anondata.encryption.service.impl;

import org.springframework.stereotype.Service;

import cn.anondata.encryption.crypto.hash.MD5;
import cn.anondata.encryption.response.CommonResponse;
import cn.anondata.encryption.service.EncryptionService;

@Service
public class EncryptionServiceImpl implements EncryptionService{

    @Override
    public CommonResponse md5(String str) {
        MD5 md5 = new MD5();
        String digest = md5.digest(str);
        return CommonResponse.builder().errCode("0").errMsg("success").result(digest).build();
    }
    
}
