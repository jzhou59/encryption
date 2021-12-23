package cn.anondata.encryption.domain.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class SymmetryResp extends CommonResp {

    protected String encryptionMode;

    protected String paddingMode;
}
