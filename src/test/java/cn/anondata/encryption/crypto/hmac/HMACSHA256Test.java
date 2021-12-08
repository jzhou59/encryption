package cn.anondata.encryption.crypto.hmac;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HMACSHA256Test {
    @BeforeAll
    static void addProvider() {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    void testDigest() {
        HMACSHA256 hmacsha256 = new HMACSHA256();
        String digest = hmacsha256.digest("", "");
        assertEquals(digest, "b613679a0814d9ec772f95d778c35fc5ff1697c493715653c6c712144292c5ad");
        digest = hmacsha256.digest("123", "123");
        assertEquals(digest, "3cafe40f92be6ac77d2792b4b267c2da11e3f3087b93bb19c6c5133786984b44");
    }

    @AfterAll
    static void removeProvider() {
        Security.removeProvider("BC");
    }
}