package pers.lyning.springcloud.gateway.oss;

import lombok.Getter;

import java.util.Optional;

/**
 * @author lyning
 */
@Getter
public class Token {

    private final static String TOKEN_PREFIX = "Bearer ";

    private final String value;

    private Token(String value) {
        this.value = value;
    }

    /**
     * 填充前缀
     *
     * @param value
     * @return
     */
    public static Token fillPrefix(String value) {
        return new Token(TOKEN_PREFIX + value);
    }

    public static Token of(String value) {
        return new Token(value);
    }

    /**
     * 提纯，去掉非 token 部分
     *
     * @return
     */
    String refining() {
        return Optional.of(this.value)
                .map(o -> o.replaceAll(TOKEN_PREFIX, ""))
                .get();
    }
}
