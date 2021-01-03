package com.panji.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author guang
 * @since 2021/1/1 12:16 下午
 */
@Configuration
public class AdminConfig {
    /**
     * Customizing
     * http://docs.spring.io/spring-boot/docs/current/reference/html/howto-spring-mvc.html
     * <p>
     * Defining a @Bean of type Jackson2ObjectMapperBuilder will allow you to customize both default ObjectMapper and XmlMapper (used in MappingJackson2HttpMessageConverter and MappingJackson2XmlHttpMessageConverter respectively).
     *
     * @return
     */
    @Bean
    public SimpleModule jsonMapperJava8DateTimeModule() {
        SimpleModule bean = new SimpleModule();

        bean.addDeserializer(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                return LocalDateTime.parse(jsonParser.getValueAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            }
        });

        bean.addSerializer(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
            @Override
            public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                jsonGenerator.writeString(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime));
            }
        });
        
        bean.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        bean.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        bean.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));

        return bean;
    }

}
