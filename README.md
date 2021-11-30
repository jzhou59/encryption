# 在线加密web项目

## 项目内容
这是一个用于提供加密服务的web项目，设想提供hash、对称加密、非对称加密、密钥交换等实现
具体支持的算法包括
SHA1
SHA224
SHA256
SHA384
SHA512
MD5
HmacSHA1
HmacSHA224
HmacSHA256
HmacSHA384
HmacSHA512
HmacMD5
UrlEncode
UrlDecode
AES
DES
Rabbit
RC4
TripleDES
base64

## 接口形式
请求地址：http://[域名:端口]/encryption/[加密算法名称]
请求方式：POST

## 通信内容形式
请求体：明文，密钥，对称加密加密模式，对称加密拓展模式，密钥拓展模式
返回体：状态码，状态信息，密文