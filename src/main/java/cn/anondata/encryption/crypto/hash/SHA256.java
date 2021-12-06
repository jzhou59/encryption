package cn.anondata.encryption.crypto.hash;

import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.util.encoders.Hex;

public class SHA256 {
    public String digest(String str){
        SHA256Digest sha256Digest = new SHA256Digest();
        sha256Digest.update(str.getBytes(), 0, str.getBytes().length);
        byte[] sha256Bytes = new byte[sha256Digest.getDigestSize()];
        sha256Digest.doFinal(sha256Bytes, 0);
        return Hex.toHexString(sha256Bytes);
    }
}
