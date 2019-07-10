package pers.lyning.springcloud.ordercontext.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author lyning
 */
@RefreshScope
@Component
@Setter
@Getter
public class ConfigInfoProperties {

    /**
     * config info
     */
    @Value("${cn.springcloud.medical.config}")
    private String config;
}
