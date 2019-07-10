package pers.lyning.springcloud.usercontext.domain;

import lombok.Getter;

/**
 * @author lyning
 */
@Getter
public class User {
    private final Long id;

    public User(final Long id) {
        this.id = id;
    }
}
