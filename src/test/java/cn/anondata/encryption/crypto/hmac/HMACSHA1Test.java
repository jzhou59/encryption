package cn.anondata.encryption.crypto.hmac;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HMACSHA1Test {

    @BeforeAll
    static void addProvider() {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    void testDigest() {
        HMACSHA1 hmacsha1 = new HMACSHA1();
        String digest = hmacsha1.digest("1234", "1234");
        assertEquals(digest, "dd7282f9e186a0a213f7d506fcbf65038ded2b24");
        digest = hmacsha1.digest("", "");
        assertEquals(digest, "fbdb1d1b18aa6c08324b7d64b71fb76370690e1d");
    }

    @AfterAll
    static void removeProvider() {
        Security.removeProvider("BC");
    }
}
