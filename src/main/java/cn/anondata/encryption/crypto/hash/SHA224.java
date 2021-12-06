package cn.anondata.encryption.crypto.hash;

import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.util.encoders.Hex;

public class SHA224 {
    public String digest(String str){
        SHA224Digest sha224Digest = new SHA224Digest();
        sha224Digest.update(str.getBytes(), 0, str.getBytes().length);
        byte[] sha224Bytes = new byte[sha224Digest.getDigestSize()];
        sha224Digest.doFinal(sha224Bytes, 0);
        return Hex.toHexString(sha224Bytes);
    }
    
}
