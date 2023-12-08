package com.crypto.Recommender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
//@ComponentScan({"com.crypto.Recommender"})
public class RecommenderApplication {
    public static void main(String[] args) {
		SpringApplication.run(RecommenderApplication.class, args);
	}
    @RequestMapping(value="/get",method= RequestMethod.GET)
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
