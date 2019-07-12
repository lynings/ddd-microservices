package pers.lyning.springcloud.gateway.oss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author lyning
 */
@RestController
@RequestMapping("/tokens")
public class OssController {

    private final OssService ossService;

    @Autowired
    public OssController(OssService ossService) {
        this.ossService = ossService;
    }

    @PostMapping
    public Mono<Token> create(@RequestBody ApplyTokenCommand applyTokenCommand) {
        Token token = this.ossService.apply(applyTokenCommand);
        return Mono.just(token);
    }

    @PostMapping("/refresh")
    public Mono<Token> create(@RequestBody Token token) {
        Token newToken = this.ossService.renew(token);
        return Mono.just(newToken);
    }
}
