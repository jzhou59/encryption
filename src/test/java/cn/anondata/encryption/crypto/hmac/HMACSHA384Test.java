package cn.anondata.encryption.crypto.hmac;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HMACSHA384Test {

    @BeforeAll
    static void addProvider() {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    void testDigest() {
        HMACSHA384 hmacsha384 = new HMACSHA384();
        String digest = hmacsha384.digest("123", "123");
        assertEquals(digest,
                "6f68b5279ee4569a70f9d0b4ef51a4db97d77cb90199c20b637f2090e39780f8eec84f302be2ee3fec36a734d9e6da5b");
        digest = hmacsha384.digest("", "");
        assertEquals(digest,
                "6c1f2ee938fad2e24bd91298474382ca218c75db3d83e114b3d4367776d14d3551289e75e8209cd4b792302840234adc");
    }

    @AfterAll
    static void removeProvider() {
        Security.removeProvider("BC");
    }
}
