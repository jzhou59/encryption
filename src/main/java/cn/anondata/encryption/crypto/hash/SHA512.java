package cn.anondata.encryption.crypto.hash;

import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.util.encoders.Hex;

public class SHA512 {
    public String digest(String str){
        SHA512Digest sha512Digest = new SHA512Digest();
        sha512Digest.update(str.getBytes(), 0, str.getBytes().length);
        byte[] sha512Bytes = new byte[sha512Digest.getDigestSize()];
        sha512Digest.doFinal(sha512Bytes, 0);
        return Hex.toHexString(sha512Bytes);
    }
}
