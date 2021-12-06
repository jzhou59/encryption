package cn.anondata.encryption.crypto.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SHA224Test {

    @BeforeAll
    static void addProvider(){
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    void testDigest() {
        SHA224 sha224 = new SHA224();
        assertEquals(sha224.digest(""), "d14a028c2a3a2bc9476102bb288234c415a2b01f828ea62ac5b3e42f");
        assertEquals(sha224.digest("123"), "78d8045d684abd2eece923758f3cd781489df3a48e1278982466017f");
        assertEquals(sha224.digest("password"), "d63dc919e201d7bc4c825630d2cf25fdc93d4b2f0d46706d29038d01");
    }

    @AfterAll
    static void removeProvider(){
        Security.removeProvider("BC");
    }
}