package com.example.res.custom.demo.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.lang.reflect.Modifier;


public class GsonConfig {
    @Bean
    GsonHttpMessageConverter gsonHttpMessageConverter() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .excludeFieldsWithModifiers(Modifier.PROTECTED)
                .create();
        converter.setGson(gson);
        return converter;
    }
}
