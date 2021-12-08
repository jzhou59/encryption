package cn.anondata.encryption.service;

import cn.anondata.encryption.domain.resp.CommonResp;

public interface HMACService {
    CommonResp hmac(String alg, String str, String key);
}
