package com.hrm.auth_service.appConfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "currency")
public class CurrencyConfig {

    private List<String> supportedCurrencies;
}
