package cn.anondata.encryption.crypto.hmac;

import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

public class HMACSHA384 implements HMACAlg {

    @Override
    public String digest(String str, String key) {
        HMac hMac = new HMac(new SHA384Digest());
        hMac.init(new KeyParameter(key.getBytes()));
        hMac.update(str.getBytes(), 0, str.getBytes().length);
        byte[] HMACSHA384Bytes = new byte[hMac.getMacSize()];
        hMac.doFinal(HMACSHA384Bytes, 0);
        return Hex.toHexString(HMACSHA384Bytes);
    }

}
