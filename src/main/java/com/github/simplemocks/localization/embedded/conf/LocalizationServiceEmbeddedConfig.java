package com.github.simplemocks.localization.embedded.conf;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.github.simplemocks.error_service.mutable.api.source.ErrorLocalizationsJsonSource;
import org.springframework.context.annotation.Bean;

/**
 * @author sibmaks
 * @since 0.0.3
 */
@ErrorLocalizationsJsonSource(
        systemCode = "LOCALIZATION_SERVICE",
        iso3Code = "eng",
        path = "classpath:/embedded/content/localization/errors/eng.json"
)
@ErrorLocalizationsJsonSource(
        systemCode = "LOCALIZATION_SERVICE",
        iso3Code = "rus",
        path = "classpath:/embedded/content/localization/errors/rus.json"
)
public class LocalizationServiceEmbeddedConfig {

    @Bean("localizationServiceObjectMapper")
    public ObjectMapper localizationServiceObjectMapper() {
        return JsonMapper.builder()
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .addModule(new ParameterNamesModule())
                .addModule(new Jdk8Module())
                .addModule(new JavaTimeModule())
                .build();
    }

}
