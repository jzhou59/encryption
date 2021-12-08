package cn.anondata.encryption.crypto.hmac;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HMACSHA224Test {

    @BeforeAll
    static void addProvider() {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    void testDigest() {
        HMACSHA224 hmacsha224 = new HMACSHA224();
        String digest = hmacsha224.digest("", "");
        assertEquals(digest, "5ce14f72894662213e2748d2a6ba234b74263910cedde2f5a9271524");
        digest = hmacsha224.digest("123", "123");
        assertEquals(digest, "f92d8e071adeae514c1ac0f94502e75bb5c28b817e0e0a01e762348f");
    }

    @AfterAll
    static void removeProvider() {
        Security.removeProvider("BC");
    }
}
