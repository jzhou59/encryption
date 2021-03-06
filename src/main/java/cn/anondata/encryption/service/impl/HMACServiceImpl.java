package cn.anondata.encryption.service.impl;

import org.springframework.stereotype.Service;

import cn.anondata.encryption.crypto.hmac.HMACAlg;
import cn.anondata.encryption.crypto.hmac.HMACMD5;
import cn.anondata.encryption.crypto.hmac.HMACSHA1;
import cn.anondata.encryption.crypto.hmac.HMACSHA224;
import cn.anondata.encryption.crypto.hmac.HMACSHA256;
import cn.anondata.encryption.crypto.hmac.HMACSHA384;
import cn.anondata.encryption.crypto.hmac.HMACSHA512;
import cn.anondata.encryption.domain.resp.CommonResp;
import cn.anondata.encryption.exception.EncryptionException;
import cn.anondata.encryption.exception.EncryptionExceptionEnum;
import cn.anondata.encryption.service.HMACService;

@Service
public class HMACServiceImpl implements HMACService {

    @Override
    public CommonResp hmac(String alg, String str, String key) {
        HMACAlg hmacAlg = null;
        switch (alg) {
            case "hmac-md5":
                hmacAlg = new HMACMD5();
                break;

            case "hmac-sha1":
                hmacAlg = new HMACSHA1();
                break;

            case "hmac-sha224":
                hmacAlg = new HMACSHA224();
                break;

            case "hmac-sha256":
                hmacAlg = new HMACSHA256();
                break;

            case "hmac-sha384":
                hmacAlg = new HMACSHA384();
                break;

            case "hmac-sha512":
                hmacAlg = new HMACSHA512();
                break;

            default:
                break;
        }
        if(hmacAlg == null){
            throw new EncryptionException(EncryptionExceptionEnum.HMAC_NO_PROVIDED);
        }
        return CommonResp.builder().errCode("0").errMsg("SUCCESS").result(hmacAlg.digest(str, key)).build();
    }

}
