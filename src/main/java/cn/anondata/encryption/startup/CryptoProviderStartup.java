package cn.anondata.encryption.startup;

import java.security.Security;

import javax.annotation.PostConstruct;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CryptoProviderStartup {
    
    @PostConstruct
    public void addProvider(){
        Security.addProvider(new BouncyCastleProvider());
        log.info("Bouncycastle provider has been added");
        if(Security.getProvider("BC")!=null){
            log.info("Bouncycastle checker passed");
        }else{
            log.info("Bouncycastle checker failed");
        }
    }
}
