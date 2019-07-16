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
public class TokenController {

    private final TokenService tokenService;

    @Autowired
    public TokenController(final TokenService tokenService) {
        this.tokenService = tokenService;
    }

    /**
     * 申请 token
     *
     * @param applyTokenCommand body 参数
     * @return
     */
    @PostMapping
    public Mono<Token> applyToken(@RequestBody final ApplyTokenCommand applyTokenCommand) {
        final Token token = this.tokenService.apply(applyTokenCommand);
        return Mono.just(token);
    }

    @PostMapping("/refresh")
    public Mono<Token> refreshToken(@RequestBody final Token token) {
        final Token newToken = this.tokenService.renew(token);
        return Mono.just(newToken);
    }
}
