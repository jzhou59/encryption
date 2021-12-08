package cn.anondata.encryption.crypto.hmac;

import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

public class HMACSHA512 implements HMACAlg {

    @Override
    public String digest(String str, String key) {
        HMac hMac = new HMac(new SHA512Digest());
        hMac.init(new KeyParameter(key.getBytes()));
        hMac.update(str.getBytes(), 0, str.getBytes().length);
        byte[] HMACSHA512Bytes = new byte[hMac.getMacSize()];
        hMac.doFinal(HMACSHA512Bytes, 0);
        return Hex.toHexString(HMACSHA512Bytes);
    }

}