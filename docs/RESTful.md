
# REST接口定义
## 0 公共参数
### 0.0 公共返回体
```JSON
{
    "errCode":"1234",
    "errMsg":"something goes wrong",
    "result": {}
}
```
### 0.1 异常状态码
异常状态码共7位，分为三个部分，前2位表示类别（hash/hmac/symmtry/...），中间三位表示http(s)状态码，后2位表示类别内的异常码编号。
0表示一切正常。

| 序号 | 子类 | 状态码 | 类别内编号 | 异常码 | 描述 |
| --- | --- | --- | --- | --- | --- | 
| 1 | 01 | 404 | 01 | 0140401 | Requested hash algorithm is not supported. Please check parameters or create a pr/issue. |
| 2 | 02 | 404 | 01 | 0240401 | Requested hmac algorithm is not supported. Please check parameters or create a pr/issue. |
| 3 | 03 | 404 | 01 | 0340401 | Requested symmetric encryption algorithm is not supported. Please check parameters or create a pr/issue. |
| 4 | ^ | 422 | 02 | 0342202 | Requested key is invalid(invalid encoding, wrong length, uninitialized, etc). Please check parameters or create a pr/issue. |
| 5 | ^ | ^ | 03 | 0342203 | Requested padding mechanism is not available in the environment. Please check parameters or create a pr/issue. |
| 6 | ^ | ^ | 04 | 0342204 | Requested algorithm parameters is in appropriate. Please check parameters or create a pr/issue. |
| 7 | ^ | 500 | 05 | 0350005 | Internal server comes across an error(provider not existed, illegal block size, bad padding, etc). Please check parameters or create a pr/issue. |



## 1 hash相关接口
### 1.0 hash介绍
目前提供MD5、SHA1、SHA224、SHA256、SHA384、SHA512六种hash算法，```docs```目录下的相关介绍文档正在完善中。。。

项目中，六种hash算法和名称对应如下为 ```MD5 - "md5"```、```SHA1 - "sha1"```、```SHA224 - "sha224"```、```SHA256 - "sha256"```、```SHA384 - "sha384"```、```SHA512 - "sha512"```，大小写不敏感，可以随意替换大小写。
包含get和post请求，

### 1.1 获取某个字符串的hash值
- URL
    - GET ```/encryption/hash?hashAlg={String:hashAlg}&message={String:message}```
    - POST ```/encryption/hash```
- 请求参数
    | 参数名称 | 参数类型 | 是否必须 | 参数说明 |
    | --- | --- | --- | --- |
    | hashAlg | String | 是 | 指示需要使用的hash算法，具体参照hash算法和名称对应 |
    | message | String | 否 | 需要被计算hash值的字符串，不指定即为空字符串 |
- 响应参数
    | 参数名称 | 参数类型 | 参数说明 | 
    | --- | --- | --- |
    | errCode | String | 异常码 |
    | errMsg | String | 异常码描述 |
    | result | String | hash结果 |
- 可能存在的错误码
    - 0140401
    

## 2 hmac相关接口
### 2.0 hmac介绍
目前提供HmacSHA1、HmacSHA224、HmacSHA256、HmacSHA384、HmacSHA512、HmacMD5六种hmac算法，```docs```目录下的相关介绍文档正在完善中。。。

项目中，六种hmac算法和名称对应如下为 ```HmacMD5 - "Hmacmd5"```、```HmacSHA1 - "Hmacsha1"```、```HmacSHA224 - "Hmacsha224"```、```HmacSHA256 - "Hmacsha256"```、```HmacSHA384 - "Hmacsha384"```、```HmacSHA512 - "Hmacsha512"```，大小写不敏感，可以随意替换大小写。
包含get和post请求，

### 2.1 获取某个字符串的hmac值
- URL
    - GET ```/encryption/hmac?hashAlg={String:hashAlg}&message={String:message}&key={String:key}```
    - POST ```/encryption/hmac```
- 请求参数
    | 参数名称 | 参数类型 | 是否必须 | 参数说明 |
    | --- | --- | --- | --- |
    | hmacAlg | String | 是 | 指示需要使用的hmac算法，具体参照hmac算法和名称对应 |
    | message | String | 否 | 需要被计算hmac值的字符串，不指定即为空字符串 |
    | key | String | 否 | 用于计算hmac的密钥字符串，不指定即为空字符串 | 
- 响应参数
    | 参数名称 | 参数类型 | 参数说明 | 
    | --- | --- | --- |
    | errCode | String | 异常码 |
    | errMsg | String | 异常码描述 |
    | result | String | hmac结果
- 可能存在的错误码
    - 0240401 

## 3 symmetric相关接口
### 3.0 symmetric介绍
从对称加密模式、填充模式、角度进行介绍
目前提供aes一种对称加密算法，```docs```目录下的相关介绍文档正在完善中。。。

项目中，symmetric encryption算法和名称对应如下为```"aes"-"aes"```，大小写不敏感，可以随意替换大小写。

#### 3.0.0 对称加密的模式
目前支持以下四种，大小写不敏感
- ECB
- CBC
- CFB
- OFB

#### 3.0.1 Padding的方式
对称加密中为了对齐块加密的块所提出的填充方式，支持以下八种，**大小写敏感**。
- NoPadding：当明文正好是块的倍数，可以不填充
- PKCS5Padding：将明文长度填充到块的倍数，每个byte填充的数字为填充的块数，只支持块的大小为8bytes
- PKCS7Padding：与PKCS5Padding相似，最长能支持到255bytes
- ISO10126-2Padding：最后一个填充的byte表示填充byte的数量，其余填充的byte为随机数
- ISO7816-4Padding：第一个填充的byte为0x80，其余为0
- X9.23Padding：最后一个填充的byte表示填充byte的数量，其余填充的byte为随机数或者0
- TBCPadding：根据明文最后一个bit决定如何填充，如果最后一个bit为0，则全部填充1；如果最后一个bit为1，则全部填充0
- ZeroBytePadding：仅仅填充0，不推荐使用

### 3.1 获取经过AES加密/解密的结果
- URL
    - POST ```加密：/encryption/symmetry/encrypt```、```解密：/encryption/symmetry/decrypt```
- 请求参数
    | 参数名称 | 参数类型 | 是否必须 | 参数说明 |
    | --- | --- | --- | --- |
    | symmetryAlg | String | 是 | aes |
    | encryptionMode | String | 是 | 加解密模式 |
    | paddingMode | String | 是 | 将message扩充到block倍数的方式 | 
    | iv | String | depends | 除ECB加解密模式外均需要一个iv |
    | message | String | 否 | 需要被aes加解密的字符串，不指定即为空字符串 |
    | key | String | 否 | 加解密密钥，不指定即为空字符串 | 
- 响应参数
    | 参数名称 | 参数类型 | 参数说明 | 
    | --- | --- | --- |
    | errCode | String | 异常码 |
    | errMsg | String | 异常码描述 |
    | result | String | aes加解密结果
- 可能存在的错误码
    - 0340401
    - 0342202
    - 0342203
    - 0342204
    - 0350005