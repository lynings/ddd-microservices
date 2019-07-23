package pers.lyning.medical.projectcontext.domain;

import lombok.Getter;
import org.springframework.util.CollectionUtils;
import pers.lyning.medical.corestandard.ddd.annotation.domain.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 护理耗材详情
 *
 * @author lyning
 */
@Getter
@Embeddable
@ValueObject
public class SuppliesDetail {

    @Column(length = 500, columnDefinition = "comment '详细的耗材信息'")
    private String suppliesItems;

    public void setSuppliesItems(List<SuppliesItem> suppliesItems) {
        if (!CollectionUtils.isEmpty(suppliesItems)) {
            this.suppliesItems = suppliesItems
                    .stream()
                    .map(o -> o.getName() + "：" + o.getAmount())
                    .reduce((prev, next) -> prev + "、" + next)
                    .get();
        }
    }

    public List<SuppliesItem> getSuppliesItems() {
        return Optional.ofNullable(this.suppliesItems)
                .map(o -> o.split("、"))
                .map(this::asSuppliesItems)
                .orElse(new ArrayList<>());
    }

    private List<SuppliesItem> asSuppliesItems(String[] itemsArr) {
        return Stream.of(itemsArr)
                .map(item -> {
                    String[] itemArr = item.split("：");
                    return new SuppliesItem(itemArr[0], Integer.valueOf(itemArr[1]));
                })
                .collect(toList());
    }
}
