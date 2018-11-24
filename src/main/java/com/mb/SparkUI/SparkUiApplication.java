package com.mb.SparkUI;

import com.mb.validate.SQLValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;


import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@RestController
public class SparkUiApplication {


    @RequestMapping("/sqlvalidate")
    public Map<String, Object> SQLValidate(@RequestParam(name="query") String query) {

        Map<String, Object> model = SQLValidator.validate(query);
	    return model;
    }


	public static void main(String[] args) {
		SpringApplication.run(SparkUiApplication.class, args);
	}
}
