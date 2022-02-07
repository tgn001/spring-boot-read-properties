package com.techgeeknext.controller;

import com.techgeeknext.config.Configurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestPropertyValController {

    @Value("${spring.application.name}")
    String applicationName;


    @Autowired
    private Environment env;

    @Autowired
    private Configurations config;


    @GetMapping("/get-values")
    public Map<String, String> getAppNameVal() {
        Map<String,String> values= new HashMap();
        values.put("using @Value--",applicationName);
        values.put("using Environment--",env.getProperty("spring.application.name"));
        values.put("using @ConfigurationProperties--",config.getUsername());
        values.put("using @ConfigurationProperties 2--",config.getPassword());
        values.put("using @ConfigurationProperties 3--",config.getPlatform());

        return values;
    }

}
