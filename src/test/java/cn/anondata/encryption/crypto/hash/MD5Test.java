package cn.anondata.encryption.crypto.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MD5Test {

    @BeforeAll
    static void addProvider() {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    void testDigest() {
        MD5 md5 = new MD5();
        assertEquals(md5.digest("password"), "5f4dcc3b5aa765d61d8327deb882cf99");
        assertEquals(md5.digest("123"), "202cb962ac59075b964b07152d234b70");
    }

    @AfterAll
    static void removeProvider() {
        Security.removeProvider("BC");
    }
}
