package cn.anondata.encryption.service.impl;

import org.springframework.stereotype.Service;

import cn.anondata.encryption.crypto.hash.HashAlg;
import cn.anondata.encryption.crypto.hash.MD5;
import cn.anondata.encryption.crypto.hash.SHA1;
import cn.anondata.encryption.crypto.hash.SHA224;
import cn.anondata.encryption.crypto.hash.SHA256;
import cn.anondata.encryption.crypto.hash.SHA384;
import cn.anondata.encryption.crypto.hash.SHA512;
import cn.anondata.encryption.domain.resp.CommonResp;
import cn.anondata.encryption.exception.EncryptionException;
import cn.anondata.encryption.exception.EncryptionExceptionEnum;
import cn.anondata.encryption.service.HashService;

@Service
public class HashServiceImpl implements HashService {

    @Override
    public CommonResp hash(String alg, String str) {

        HashAlg hashAlg = null;
        switch (alg) {
            case "md5":
                hashAlg = new MD5();
                break;

            case "sha1":
                hashAlg = new SHA1();
                break;

            case "sha224":
                hashAlg = new SHA224();
                break;

            case "sha256":
                hashAlg = new SHA256();
                break;

            case "sha384":
                hashAlg = new SHA384();
                break;

            case "sha512":
                hashAlg = new SHA512();
                break;

            default:
                break;
        }
        if(hashAlg == null){
            throw new EncryptionException(EncryptionExceptionEnum.HASH_NO_PROVIDED);
        }
        return CommonResp.builder().errCode("0").errMsg("SUCCESS").result(hashAlg.digest(str)).build();
    }

}
