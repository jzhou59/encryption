package cn.anondata.encryption.service;

import cn.anondata.encryption.domain.resp.CommonResp;

public interface HashService {
    CommonResp hash(String alg, String str);
}
