package com.example.imagebackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootTest
@ImportAutoConfiguration(exclude = {
        SpringDataRestConfiguration.class,
        Swagger2DocumentationConfiguration.class
})
class ImageBackendApplicationTests {

    @Test
    void contextLoads() {
    }

}