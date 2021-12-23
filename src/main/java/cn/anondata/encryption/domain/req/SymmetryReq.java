package cn.anondata.encryption.domain.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SymmetryReq {

    private String symmetryAlg;

    private String encryptionMode;

    private String paddingMode;

    private String iv;

    private String message;

    private String key;
}
