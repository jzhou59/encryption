# a standalone encryption web service

## Intro
This is a standalone web service providing encryption service. The target is providing the implementations of hash\hmac\symmetry\exchange etc. Completed and undergoing encryption algorithm concludes:
- hash：SHA1、SHA224、SHA256、SHA384、SHA512、MD5
- mac：HmacSHA1、HmacSHA224、HmacSHA256、HmacSHA384、HmacSHA512、HmacMD5
- symmetric：AES、DES、TripleDES、Rabbit、RC4
- asymmetric：RSA
- code：UrlEncode、UrlDecode、base64

## startup
prerequisite: java-17, maven

```git clone [this repo]```

```cd encryption```

```.mvnw spring-boot:run```

## use case

## LICENSE