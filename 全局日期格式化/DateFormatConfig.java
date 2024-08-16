package com.example.springsecuritybase.config.dateTimeFormat;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * 全局日期格式化 如果某个字段不使用该格式
 * 依旧可以使用 @JsonFormat 和 @DataTimeFormat 覆盖全局配置
 */
@JsonComponent
@Configuration
public class DateFormatConfig {

    @Value("${spring.mvc.format.date-time}")
    private String dateTimePattern;

    @Value("${spring.mvc.format.date}")
    private String datePattern;

    @Value("${spring.mvc.format.time}")
    private String timePattern;

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> {
            TimeZone tz = TimeZone.getTimeZone("GMT+8");

            builder.failOnEmptyBeans(false)
                    .failOnUnknownProperties(false)
                    .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                    .timeZone(tz)
                    .serializers(
                            new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimePattern)),
                            new LocalDateSerializer(DateTimeFormatter.ofPattern(datePattern)),
                            new LocalTimeSerializer(DateTimeFormatter.ofPattern(timePattern))
                    )
                    .deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(dateTimePattern)))
                    .deserializerByType(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(datePattern)))
                    .deserializerByType(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(timePattern)));
        };
    }
}
