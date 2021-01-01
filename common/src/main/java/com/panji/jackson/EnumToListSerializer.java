package com.panji.jackson;

import com.esotericsoftware.reflectasm.MethodAccess;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@JsonComponent
@SuppressWarnings("all")
public class EnumToListSerializer extends JsonSerializer<Enum<?>> {

    @Override
    public void serialize(Enum<?> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value == null) {
            return;
        }
        try {
            Object[] array = new Object[3];
            MethodAccess access = MethodAccess.get(value.getClass());
            String[] names = access.getMethodNames();
            
            List<String> strings =
                    Stream.of(names).filter(name -> "getName".equals(name) || "getValue".equals(name) || "getCode".equals(name))
                            .collect(Collectors.toList());
            array[0] = value.name();
            strings.forEach(name -> {
                        if ("getName".equals(name)) {
                            array[1] = access.invoke(value, name);
                        }
                        if ("getValue".equals(name) || "getCode".equals(name)) {
                            array[2] = access.invoke(value, name);
                        }
                    }
            );

            gen.writeObject(array);
        } catch (Exception e) {
            log.error("枚举值序列化异常,Enum value = " + value, e);
        }
    }
}
