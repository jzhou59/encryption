package cn.anondata.encryption.crypto.hmac;

import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

public class HMACSHA1 implements HMACAlg {

    @Override
    public String digest(String str, String key) {
        HMac hMac = new HMac(new SHA1Digest());
        hMac.init(new KeyParameter(key.getBytes()));
        byte[] HMACSHA1Bytes = new byte[hMac.getMacSize()];
        hMac.update(str.getBytes(), 0, str.getBytes().length);
        hMac.doFinal(HMACSHA1Bytes, 0);
        return Hex.toHexString(HMACSHA1Bytes);
    }
}
