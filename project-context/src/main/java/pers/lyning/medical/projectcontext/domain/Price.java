package pers.lyning.medical.projectcontext.domain;

import pers.lyning.medical.corestandard.ddd.annotation.domain.ValueObject;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * 价格
 *
 * @author lyning
 */
@ValueObject
@Embeddable
public class Price {

    /**
     * 价格
     */
    private final BigDecimal price = BigDecimal.ZERO;
}
