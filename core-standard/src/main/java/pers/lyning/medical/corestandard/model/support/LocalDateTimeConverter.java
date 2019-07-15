package pers.lyning.medical.corestandard.model.support;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * jpa LocalDateTime date type field convert
 * Created by Blink on 10/19/2018 AD
 *
 * @author Blink
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(final LocalDateTime localDateTime) {
        return Optional.ofNullable(localDateTime)
                .map(Timestamp::valueOf)
                .orElse(null);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(final Timestamp timestamp) {
        return Optional.ofNullable(timestamp)
                .map(Timestamp::toLocalDateTime)
                .orElse(null);
    }
}
