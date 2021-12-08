package cn.anondata.encryption.crypto.hmac;

public interface HMACAlg {
    String digest(String str, String key);
}
