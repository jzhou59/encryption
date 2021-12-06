package cn.anondata.encryption.service.impl;

import org.springframework.stereotype.Service;
import cn.anondata.encryption.crypto.hash.MD5Reference;
import cn.anondata.encryption.response.CommonResponse;
import cn.anondata.encryption.service.EncryptionService;

@Service
public class EncryptionServiceImpl implements EncryptionService{

    @Override
    public CommonResponse md5(String str) {
        MD5Reference md5Reference = new MD5Reference();
        String digest = md5Reference.digest(str);
        return CommonResponse.builder().errCode("0").errMsg("success").result(digest).build();
    }
    
}
