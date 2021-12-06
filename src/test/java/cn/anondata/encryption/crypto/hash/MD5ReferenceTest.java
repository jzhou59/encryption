package cn.anondata.encryption.crypto.hash;

import org.junit.jupiter.api.Test;

public class MD5ReferenceTest {
    @Test
    void testDigest() {
        MD5Reference md5Reference = new MD5Reference();
        System.out.println(md5Reference.digest("a"));
    }
}
