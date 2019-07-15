package pers.lyning.medical.ordercontext.gateways.ohs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.lyning.medical.ordercontext.config.ConfigInfoProperties;

/**
 * @author lyning
 */
@RestController
@RequestMapping("/configs")
public class ConfigController {

    private final ConfigInfoProperties configInfoProperties;

    @Autowired
    public ConfigController(final ConfigInfoProperties configInfoProperties) {
        this.configInfoProperties = configInfoProperties;
    }

    @GetMapping
    public String loadConfig() {
        return this.configInfoProperties.getConfig();
    }
}
