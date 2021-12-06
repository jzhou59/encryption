package cn.anondata.encryption.crypto.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SHA1Test {

    @BeforeAll
    static void addProvider(){
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    void testDigest() {
        SHA1 sha1 = new SHA1();
        assertEquals(sha1.digest("123"), "40bd001563085fc35165329ea1ff5c5ecbdbbeef");
        assertEquals(sha1.digest("password"), "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8");
    }

    @AfterAll
    static void removeProvider(){
        Security.removeProvider("BC");
    }
}
