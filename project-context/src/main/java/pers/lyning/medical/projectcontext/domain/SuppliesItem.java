package pers.lyning.medical.projectcontext.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pers.lyning.medical.corestandard.ddd.annotation.domain.ValueObject;

/**
 * @author lyning
 */
@Setter
@Getter
@ValueObject
@NoArgsConstructor
public class SuppliesItem {

    private String name;

    private Integer amount;

    public SuppliesItem(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }
}
