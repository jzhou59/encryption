package cn.anondata.encryption.service.impl;

import org.springframework.stereotype.Service;

import cn.anondata.encryption.crypto.hash.MD5;
import cn.anondata.encryption.crypto.hash.SHA1;
import cn.anondata.encryption.crypto.hash.SHA224;
import cn.anondata.encryption.crypto.hash.SHA256;
import cn.anondata.encryption.crypto.hash.SHA384;
import cn.anondata.encryption.crypto.hash.SHA512;
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

    @Override
    public CommonResponse sha1(String str) {
        SHA1 sha1 = new SHA1();
        String digest = sha1.digest(str);
        return CommonResponse.builder().errCode("0").errMsg("success").result(digest).build();
    }

    @Override
    public CommonResponse sha224(String str) {
        SHA224 sha224 = new SHA224();
        String digest = sha224.digest(str);
        return CommonResponse.builder().errCode("0").errMsg("success").result(digest).build();
    }

    @Override
    public CommonResponse sha256(String str) {
        SHA256 sha256 = new SHA256();
        String digest = sha256.digest(str);
        return CommonResponse.builder().errCode("0").errMsg("success").result(digest).build();
    }

    @Override
    public CommonResponse sha384(String str) {
        SHA384 sha384 = new SHA384();
        String digest = sha384.digest(str);
        return CommonResponse.builder().errCode("0").errMsg("success").result(digest).build();
    }

    @Override
    public CommonResponse sha512(String str) {
        SHA512 sha512 = new SHA512();
        String digest = sha512.digest(str);
        return CommonResponse.builder().errCode("0").errMsg("success").result(digest).build();
    }
}
