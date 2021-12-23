package cn.anondata.encryption.service;

import cn.anondata.encryption.domain.req.SymmetryReq;
import cn.anondata.encryption.domain.resp.CommonResp;

public interface SymmetryService {
    CommonResp symmetryEncrypt(SymmetryReq symmetryReq);

    CommonResp symmetryDecrypt(SymmetryReq symmetryReq);
}
