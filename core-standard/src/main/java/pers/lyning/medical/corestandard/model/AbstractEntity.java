package pers.lyning.medical.corestandard.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import pers.lyning.medical.corestandard.model.support.jpa.LocalDateTimeConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Blink on 8/19/2018 AD.
 *
 * @author Blink
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity implements Serializable {

    /**
     * 记录创建时间
     */
    @CreatedDate
    @Column(columnDefinition = "datetime")
    @Convert(converter = LocalDateTimeConverter.class)
    protected LocalDateTime createdDate;

    /**
     * 记录更新时间
     */
    @LastModifiedDate
    @Column(columnDefinition = "datetime")
    @Convert(converter = LocalDateTimeConverter.class)
    protected LocalDateTime modifiedDate;
}
