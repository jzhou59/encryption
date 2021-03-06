package cn.anondata.encryption.crypto.hmac;

import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

public class HMACMD5 implements HMACAlg {

    @Override
    public String digest(String str, String key) {
        HMac hMac = new HMac(new MD5Digest());
        hMac.init(new KeyParameter(key.getBytes()));
        byte[] HMACMD5Bytes = new byte[hMac.getMacSize()];
        hMac.update(str.getBytes(), 0, str.getBytes().length);
        hMac.doFinal(HMACMD5Bytes, 0);
        return Hex.toHexString(HMACMD5Bytes);
    }

}
