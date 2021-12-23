package cn.anondata.encryption.service.impl;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.stereotype.Service;

import cn.anondata.encryption.crypto.symmetry.AES;
import cn.anondata.encryption.crypto.symmetry.SymmetryAlg;
import cn.anondata.encryption.domain.req.SymmetryReq;
import cn.anondata.encryption.domain.resp.CommonResp;
import cn.anondata.encryption.exception.EncryptionException;
import cn.anondata.encryption.exception.EncryptionExceptionEnum;
import cn.anondata.encryption.service.SymmetryService;

@Service
public class SymmetryServiceImpl implements SymmetryService {

    @Override
    public CommonResp symmetryEncrypt(SymmetryReq symmetryReq) {
        SymmetryAlg symmetryAlg = parseSymmetryAlg(symmetryReq);
        if (symmetryAlg == null) {
            throw new EncryptionException(EncryptionExceptionEnum.SYMMETRY_NO_PROVIDED);
        }
        String result = null;
        try {
            result = symmetryAlg.encrypt(symmetryReq);
        } catch (InvalidKeyException e) {
            throw new EncryptionException(EncryptionExceptionEnum.SYMMETRY_INVALID_KEY);
        } catch (NoSuchAlgorithmException e) {
            throw new EncryptionException(EncryptionExceptionEnum.SYMMETRY_NO_PROVIDED);
        } catch (NoSuchPaddingException e) {
            throw new EncryptionException(EncryptionExceptionEnum.SYMMETRY_NO_SUCH_PADDING);
        } catch (InvalidAlgorithmParameterException e) {
            throw new EncryptionException(EncryptionExceptionEnum.SYMMETRY_INVALID_PARAMETER);
        } catch (NoSuchProviderException | IllegalBlockSizeException | BadPaddingException e) {
            throw new EncryptionException(EncryptionExceptionEnum.SYMMETRY_INTERNAL_SERVER);
        }
        return CommonResp.builder().errCode("0").errMsg("SUCCESS").result(result).build();
    }

    @Override
    public CommonResp symmetryDecrypt(SymmetryReq symmetryReq) {
        SymmetryAlg symmetryAlg = parseSymmetryAlg(symmetryReq);
        if (symmetryAlg == null) {
            throw new EncryptionException(EncryptionExceptionEnum.SYMMETRY_NO_PROVIDED);
        }
        String result = null;
        try {
            result = symmetryAlg.decrypt(symmetryReq);
        } catch (InvalidKeyException e) {
            throw new EncryptionException(EncryptionExceptionEnum.SYMMETRY_INVALID_KEY);
        } catch (NoSuchAlgorithmException e) {
            throw new EncryptionException(EncryptionExceptionEnum.SYMMETRY_NO_PROVIDED);
        } catch (NoSuchPaddingException e) {
            throw new EncryptionException(EncryptionExceptionEnum.SYMMETRY_NO_SUCH_PADDING);
        } catch (InvalidAlgorithmParameterException e) {
            throw new EncryptionException(EncryptionExceptionEnum.SYMMETRY_INVALID_PARAMETER);
        } catch (NoSuchProviderException | IllegalBlockSizeException | BadPaddingException e) {
            throw new EncryptionException(EncryptionExceptionEnum.SYMMETRY_INTERNAL_SERVER);
        }
        return CommonResp.builder().errCode("0").errMsg("SUCCESS").result(result).build();
    }

    private SymmetryAlg parseSymmetryAlg(SymmetryReq symmetryReq) {
        SymmetryAlg symmetryAlg = null;
        switch (symmetryReq.getSymmetryAlg().toLowerCase()) {
            case "aes":
                symmetryAlg = new AES();
                break;
            case "des":
            case "rabbit":
            case "rc4":
            case "tripledes":
            default:
                break;
        }
        return symmetryAlg;
    }

}
