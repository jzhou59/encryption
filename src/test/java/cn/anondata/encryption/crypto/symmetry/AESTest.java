package cn.anondata.encryption.crypto.symmetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import cn.anondata.encryption.domain.req.SymmetryReq;

public class AESTest {
    @BeforeAll
    static void addProvider() {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    void testAESECBDigest() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        AES aes = new AES();
        // aes ecb pkcs7padding(pkcs5padding)
        SymmetryReq req_aes_ecb_pkcs7_encrypt = SymmetryReq.builder().symmetryAlg("AES").encryptionMode("ECB")
                .paddingMode("PKCS7Padding").key("wordlessthanfour").iv("").message("1234").build();
        assertEquals("8be28402eaa5556b5f1e7be8bb92bbd1", aes.encrypt(req_aes_ecb_pkcs7_encrypt));
        SymmetryReq req_aes_ecb_pkcs7_decrypt = SymmetryReq.builder().symmetryAlg("AES").encryptionMode("ECB")
                .paddingMode("PKCS7Padding").key("wordlessthanfour").iv("").message("8be28402eaa5556b5f1e7be8bb92bbd1")
                .build();
        assertEquals("1234", aes.decrypt(req_aes_ecb_pkcs7_decrypt));

        // aes ecb zerobytepadding
        SymmetryReq req_aes_ecb_zero_encrypt = SymmetryReq.builder().symmetryAlg("AES").encryptionMode("ECB")
                .paddingMode("ZeroBytePadding").key("wordlessthanfour").iv("").message("1234").build();
        assertEquals("980687725f0d0cfd8ccc175a2f741308", aes.encrypt(req_aes_ecb_zero_encrypt));
        SymmetryReq req_aes_ecb_zero_decrypt = SymmetryReq.builder().symmetryAlg("AES").encryptionMode("ECB")
                .paddingMode("ZeroBytePadding").key("wordlessthanfour").iv("")
                .message("980687725f0d0cfd8ccc175a2f741308")
                .build();
        assertEquals("1234", aes.decrypt(req_aes_ecb_zero_decrypt));

        // aes ecb iso10126-2padding
        SymmetryReq req_aes_ecb_iso10126d2_encrypt = SymmetryReq.builder().symmetryAlg("AES").encryptionMode("ECB")
                .paddingMode("ISO10126-2Padding").key("wordlessthanfour").iv("").message("1234").build();
        assertTrue(aes.encrypt(req_aes_ecb_iso10126d2_encrypt).matches("[0-f]{32}"));

        // aes ecb iso7816-4padding
        SymmetryReq req_aes_ecb_iso7816d4_encrypt = SymmetryReq.builder().symmetryAlg("AES").encryptionMode("ECB")
                .paddingMode("ISO7816-4Padding").key("wordlessthanfour").iv("").message("1234").build();
        assertEquals("1be0d1bb201704ba2d11bbe3a25d1a74", aes.encrypt(req_aes_ecb_iso7816d4_encrypt));
        SymmetryReq req_aes_ecb_iso7816d4_decrypt = SymmetryReq.builder().symmetryAlg("AES").encryptionMode("ECB")
                .paddingMode("ISO7816-4Padding").key("wordlessthanfour").iv("")
                .message("1be0d1bb201704ba2d11bbe3a25d1a74").build();
        assertEquals("1234", aes.decrypt(req_aes_ecb_iso7816d4_decrypt));

        // aes ecb x9.23padding
        SymmetryReq req_aes_ecb_x923_encrypt = SymmetryReq.builder().symmetryAlg("AES").encryptionMode("ECB")
                .paddingMode("X9.23Padding").key("wordlessthanfour").iv("").message("1234").build();
        assertTrue(aes.encrypt(req_aes_ecb_x923_encrypt).matches("[0-f]{32}"));

        // aes ecb tbcpadding
        SymmetryReq req_aes_ecb_tbc_encrypt = SymmetryReq.builder().symmetryAlg("AES").encryptionMode("ECB")
                .paddingMode("TBCPadding").key("wordlessthanfour").iv("").message("1234").build();
        assertEquals("6aa19f31382e2b57fed70865d24dd6e4", aes.encrypt(req_aes_ecb_tbc_encrypt));
        SymmetryReq req_aes_ecb_tbc_decrypt = SymmetryReq.builder().symmetryAlg("AES").encryptionMode("ECB")
                .paddingMode("TBCPadding").key("wordlessthanfour").iv("")
                .message("6aa19f31382e2b57fed70865d24dd6e4").build();
        assertEquals("1234", aes.decrypt(req_aes_ecb_tbc_decrypt));
    }

    @Test
    void testAESCBCDigest() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        AES aes = new AES();

        // aes cbc pkcs7padding(pkcs5padding)
        SymmetryReq req_aes_cbc_pkcs7_encrypt = SymmetryReq.builder().symmetryAlg("AES").encryptionMode("CBC")
                .paddingMode("PKCS7Padding").key("wordlessthanfour").iv("wordlessthanfour").message("1234").build();
        assertEquals("3a0263fe9b80256907490fd6b4a9e5bf", aes.encrypt(req_aes_cbc_pkcs7_encrypt));
        SymmetryReq req_aes_cbc_pkcs7_decrypt = SymmetryReq.builder().symmetryAlg("AES").encryptionMode("CBC")
                .paddingMode("PKCS7Padding").key("wordlessthanfour").iv("wordlessthanfour")
                .message("3a0263fe9b80256907490fd6b4a9e5bf").build();
        assertEquals("1234", aes.decrypt(req_aes_cbc_pkcs7_decrypt));
    }

    @Test
    void testAESCFBDigest() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
        AES aes = new AES();

        // aes cfb pkcs7padding(pkcs5padding)
        SymmetryReq req_aes_cfb_pkcs7_encrypt = SymmetryReq.builder().symmetryAlg("AES").encryptionMode("CFB8")
                .paddingMode("PKCS7Padding").key("wordlessthanfour").iv("wordlessthanfour").message("1234").build();
        assertEquals("730f8d3fd8", aes.encrypt(req_aes_cfb_pkcs7_encrypt));
        SymmetryReq req_aes_cfb_pkcs7_decrypt = SymmetryReq.builder().symmetryAlg("AES").encryptionMode("CFB8")
                .paddingMode("PKCS7Padding").key("wordlessthanfour").iv("wordlessthanfour")
                .message("730f8d3fd8").build();
        assertEquals("1234", aes.decrypt(req_aes_cfb_pkcs7_decrypt));
    }

    @Test
    void testAESOFBDigest() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
        AES aes = new AES();

        // aes ofb pkcs7padding(pkcs5padding)
        SymmetryReq req_aes_ofb_pkcs7_encrypt = SymmetryReq.builder().symmetryAlg("AES").encryptionMode("OFB8")
                .paddingMode("PKCS7Padding").key("wordlessthanfour").iv("wordlessthanfour").message("1234").build();
        assertEquals("737e25f845", aes.encrypt(req_aes_ofb_pkcs7_encrypt));
        SymmetryReq req_aes_ofb_pkcs7_decrypt = SymmetryReq.builder().symmetryAlg("AES").encryptionMode("OFB8")
                .paddingMode("PKCS7Padding").key("wordlessthanfour").iv("wordlessthanfour")
                .message("737e25f845").build();
        assertEquals("1234", aes.decrypt(req_aes_ofb_pkcs7_decrypt));
    }

    @AfterAll
    static void removeProvider() {
        Security.removeProvider("BC");
    }
}
