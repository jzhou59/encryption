package cn.anondata.encryption.crypto.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SHA512Test {

    @BeforeAll
    static void addProvider(){
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    void testDigest() {
        SHA512 sha512 = new SHA512();
        assertEquals(sha512.digest(""), "cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e");
        assertEquals(sha512.digest("123"), "3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2");
        assertEquals(sha512.digest("password"), "b109f3bbbc244eb82441917ed06d618b9008dd09b3befd1b5e07394c706a8bb980b1d7785e5976ec049b46df5f1326af5a2ea6d103fd07c95385ffab0cacbc86");
    }

    @AfterAll
    static void removeProvider(){
        Security.removeProvider("BC");
    }
}
