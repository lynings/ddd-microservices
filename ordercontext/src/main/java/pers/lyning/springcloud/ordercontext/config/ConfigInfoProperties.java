package pers.lyning.springcloud.ordercontext.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author lyning
 */
@RefreshScope
@Component
@ConfigurationProperties(prefix = "cn.springcloud.medical")
@Setter
@Getter
public class ConfigInfoProperties {

    /**
     * config info
     */
    private String config;
}
