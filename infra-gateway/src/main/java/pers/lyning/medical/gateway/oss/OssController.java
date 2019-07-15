package pers.lyning.medical.gateway.oss;

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
    public OssController(final OssService ossService) {
        this.ossService = ossService;
    }

    @PostMapping
    public Mono<Token> create(@RequestBody final ApplyTokenCommand applyTokenCommand) {
        final Token token = this.ossService.apply(applyTokenCommand);
        return Mono.just(token);
    }

    @PostMapping("/refresh")
    public Mono<Token> create(@RequestBody final Token token) {
        final Token newToken = this.ossService.renew(token);
        return Mono.just(newToken);
    }
}
