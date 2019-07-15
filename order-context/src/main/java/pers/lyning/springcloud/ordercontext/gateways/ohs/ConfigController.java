package pers.lyning.springcloud.ordercontext.gateways.ohs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.lyning.springcloud.ordercontext.config.ConfigInfoProperties;

/**
 * @author lyning
 */
@RestController
@RequestMapping("/configs")
public class ConfigController {

    private final ConfigInfoProperties configInfoProperties;

    @Autowired
    public ConfigController(ConfigInfoProperties configInfoProperties) {
        this.configInfoProperties = configInfoProperties;
    }

    @GetMapping
    public String loadConfig() {
        return this.configInfoProperties.getConfig();
    }
}
