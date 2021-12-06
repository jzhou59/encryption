package cn.anondata.encryption.crypto.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SHA384Test {
    
    @BeforeAll
    static void addProvider(){
        Security.addProvider(new BouncyCastleProvider());
    }
    
    @Test
    void testDigest() {
        SHA384 sha384 = new SHA384();
        assertEquals(sha384.digest(""), "38b060a751ac96384cd9327eb1b1e36a21fdb71114be07434c0cc7bf63f6e1da274edebfe76f65fbd51ad2f14898b95b");
        assertEquals(sha384.digest("123"), "9a0a82f0c0cf31470d7affede3406cc9aa8410671520b727044eda15b4c25532a9b5cd8aaf9cec4919d76255b6bfb00f");
        assertEquals(sha384.digest("password"), "a8b64babd0aca91a59bdbb7761b421d4f2bb38280d3a75ba0f21f2bebc45583d446c598660c94ce680c47d19c30783a7");
    }

    @AfterAll
    static void removeProvider(){
        Security.removeProvider("BC");
    }
}
