package cn.anondata.encryption.crypto.hmac;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HMACSHA512Test {
    @BeforeAll
    static void addProvider() {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    void testDigest() {
        HMACSHA512 hmacsha512 = new HMACSHA512();
        String digest = hmacsha512.digest("", "");
        assertEquals(digest,
                "b936cee86c9f87aa5d3c6f2e84cb5a4239a5fe50480a6ec66b70ab5b1f4ac6730c6c515421b327ec1d69402e53dfb49ad7381eb067b338fd7b0cb22247225d47");
        digest = hmacsha512.digest("123", "123");
        assertEquals(digest,
                "0634fd04380bbaf5069c8c46a74c7d21df7414888d980c27a16d5e262cb8c9059139c212d0926000faf026e483904cefae2f5e9d9bd5f51fbc2ac4c4de518115");
    }

    @AfterAll
    static void removeProvider() {
        Security.removeProvider("BC");
    }
}
