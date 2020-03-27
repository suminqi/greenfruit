package com.monster.greenfruit.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;


@Configuration
public class GreenFruitFastJsonConfig {


    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter =
                new FastJsonHttpMessageConverter();

        FastJsonConfig config = new FastJsonConfig();

        config.setDateFormat("yyyy-MM-dd");

        config.setCharset(StandardCharsets.UTF_8);

        config.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.PrettyFormat
        );
        converter.setFastJsonConfig(config);

        return converter;
    }

}
