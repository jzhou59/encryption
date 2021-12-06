package cn.anondata.encryption.crypto.hash;

import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.util.encoders.Hex;

public class MD5 {
    public String digest(String str) {
        MD5Digest md5Digest = new MD5Digest();
        md5Digest.update(str.getBytes(), 0, str.getBytes().length);
        byte[] md5Bytes = new byte[md5Digest.getDigestSize()];
        md5Digest.doFinal(md5Bytes, 0);
        return Hex.toHexString(md5Bytes);
    }
}
