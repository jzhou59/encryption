package cn.anondata.encryption.crypto.hash;

import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.util.encoders.Hex;

public class SHA384 {
    public String digest(String str){
        SHA384Digest sha384Digest = new SHA384Digest();
        sha384Digest.update(str.getBytes(), 0, str.getBytes().length);
        byte[] sha384Bytes = new byte[sha384Digest.getDigestSize()];
        sha384Digest.doFinal(sha384Bytes, 0);
        return Hex.toHexString(sha384Bytes);
    }
}
