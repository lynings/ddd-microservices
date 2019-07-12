package pers.lyning.springcloud.gateway.oss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.lyning.springcloud.gateway.gateway.acl.user.User;
import pers.lyning.springcloud.gateway.gateway.acl.user.UserClient;

/**
 * @author lyning
 */
@Service
public class OssService {

    private final JwtProvider jwtProvider;
    private final UserClient userClient;

    @Autowired
    public OssService(JwtProvider jwtProvider, UserClient userClient) {
        this.jwtProvider = jwtProvider;
        this.userClient = userClient;
    }

    /**
     * 申请
     *
     * @param createCommand
     * @return
     */
    public Token apply(CreateCommand createCommand) {
        User user = this.userClient.findByUsername(createCommand.getUsername());
        Payload payload = new Payload(user);
        return this.jwtProvider.generate(payload);
    }

    /**
     * 续租
     *
     * @param token
     * @return
     */
    public Token renew(Token token) {
        return this.jwtProvider.renew(token);
    }
}
