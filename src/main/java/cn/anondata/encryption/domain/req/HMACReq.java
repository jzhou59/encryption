package cn.anondata.encryption.domain.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HMACReq {

    private String hmacAlg;

    private String message;

    private String key;
}
