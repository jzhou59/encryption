package cn.anondata.encryption.crypto.hash;

import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.util.encoders.Hex;

public class SHA1 {
    public String digest(String str) {
        SHA1Digest sha1Digest = new SHA1Digest();
        sha1Digest.update(str.getBytes(), 0, str.getBytes().length);
        byte[] sha1Bytes = new byte[sha1Digest.getDigestSize()];
        sha1Digest.doFinal(sha1Bytes, 0);
        return Hex.toHexString(sha1Bytes);
    }
}
