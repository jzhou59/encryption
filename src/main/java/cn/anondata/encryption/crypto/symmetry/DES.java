package cn.anondata.encryption.crypto.symmetry;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.util.encoders.Hex;

import cn.anondata.encryption.domain.req.SymmetryReq;

public class DES implements SymmetryAlg {

    @Override
    public String encrypt(SymmetryReq symmetryReq) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        String message = symmetryReq.getMessage();
        
        byte[] result = digest(symmetryReq, true, message.getBytes());

        return Hex.toHexString(result);
    }

    @Override
    public String decrypt(SymmetryReq symmetryReq) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] cipherText = Hex.decode(symmetryReq.getMessage());

        byte[] result = digest(symmetryReq, false, cipherText);

        return new String(result, StandardCharsets.UTF_8);
    }

    public byte[] digest(SymmetryReq symmetryReq, boolean encrypt, byte[] message) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(symmetryReq.getSymmetryAlg().toUpperCase()).append("/")
                .append(symmetryReq.getEncryptionMode().toUpperCase()).append("/").append(symmetryReq.getPaddingMode());

        byte[] result = new byte[1];
        Cipher cipher = null;
        SecretKeySpec secretKeySpec = new SecretKeySpec(symmetryReq.getKey().getBytes(),
                symmetryReq.getSymmetryAlg().toUpperCase());
        IvParameterSpec ivParameterSpec = new IvParameterSpec(symmetryReq.getIv().getBytes());
        switch (symmetryReq.getEncryptionMode().toUpperCase().substring(0,3)) {
            case "ECB":
                cipher = Cipher.getInstance(sBuffer.toString(), "BC");
                cipher.init(encrypt ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE, secretKeySpec);
                break;
            case "CFB":
            case "OFB":
            case "CBC":
                cipher = Cipher.getInstance(sBuffer.toString(), "BC");
                cipher.init(encrypt ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
                break;
            default:
                throw new NoSuchAlgorithmException(
                        "Provided encryption mode for symmetric encryption is not supported.");
        }
        result = new byte[cipher.getOutputSize(message.length)];
        result = cipher.doFinal(message);

        return result;
    }

}
