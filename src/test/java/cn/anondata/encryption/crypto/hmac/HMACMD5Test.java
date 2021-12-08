package cn.anondata.encryption.crypto.hmac;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HMACMD5Test {

    @BeforeAll
    static void addProvider() {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    void testDigest() {
        HMACMD5 hmacmd5 = new HMACMD5();
        String digest = hmacmd5.digest("1234", "1234");
        assertEquals(digest, "7b43300d83a6fc4b79b750acb2332fe0");
    }

    @AfterAll
    static void removeProvider() {
        Security.removeProvider("BC");
    }
}
