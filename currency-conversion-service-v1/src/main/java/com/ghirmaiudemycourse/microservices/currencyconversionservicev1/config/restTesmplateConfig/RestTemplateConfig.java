package com.ghirmaiudemycourse.microservices.currencyconversionservicev1.config.restTesmplateConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//@Configuration
@Configuration()
public class RestTemplateConfig {



    @Bean
@LoadBalanced
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();

    }



// private    RestTemplate restemplate(RestTemplateBuilder builder){
//
//        return  builder.build();
//    }

}
//@Configuration(proxyBeanMethods = false)
//class RestTemplateConfiguration{
//    @Bean

//    RestTemplate getRestemplate(RestTemplateBuilder builder){
//
//        return  builder.build();
//    }
//
//}


