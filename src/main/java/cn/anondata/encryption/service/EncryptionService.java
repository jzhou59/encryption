package cn.anondata.encryption.service;

import cn.anondata.encryption.response.CommonResponse;

public interface EncryptionService {

    CommonResponse md5(String str);
    
    CommonResponse sha1(String str);
}
