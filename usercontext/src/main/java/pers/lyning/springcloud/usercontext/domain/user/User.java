package pers.lyning.springcloud.usercontext.domain.user;

import lombok.Getter;

/**
 * @author lyning
 */
@Getter
public class User {
    private final Long id;
    private final String username;

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
