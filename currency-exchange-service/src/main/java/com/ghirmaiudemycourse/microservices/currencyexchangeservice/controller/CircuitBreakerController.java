package com.ghirmaiudemycourse.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1")
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);


// to see how @Retry  feaure of Resiliance4j works
    @GetMapping("/ram/taram/param/ram")
    @Retry(name = "sample-api" ,fallbackMethod = "fallingDown")
    public String sample_API(){
logger.info(" sample-api call received");
 ResponseEntity<String> str = new RestTemplate().getForEntity("http://localhost:8001/dummy/hello",String.class);
        return str.getBody();
    }




    // to see @Circuit breaker  feature of Resiliance4j does when subsequest request made to slow or down service
    @GetMapping("/ram/bam/bam")
    @CircuitBreaker(name = "curicuit-api",fallbackMethod = "theOtherEndFalls")
    public  String circuit_Api(){

        logger.info("circuit_Api call received");
      ResponseEntity<String> st =  new RestTemplate().getForEntity("http://localhost:8080/sleepy/api", String.class);
        return st.getBody();
    }

    //to see @RateLimiter features of Resiliance4j
    @GetMapping("/shat/shat")
    @RateLimiter(name = "sample-rate-api",fallbackMethod = "rate_lim")
    // it is all about at 10s the maximum amount of calls should be made to this api and that is configured in the application.properties

    public String rate_limiter_api(){
        logger.info("rate-limiter-call received");

        return " welcome to rate_limiter_api";
    }

    //to see the @Bulkhead feature of Resiliance4j  ,, this is the maximum amount of conccurent call that the api can recieved
    @GetMapping("/bulk/bulk")
    @Bulkhead(name = "bal-bal-abila-atawedi",fallbackMethod = "bucky")
    public String bulk(){

        return "welcome to bulkhead feature of Resiliance4j";
    }
    private String theOtherEndFalls(Throwable throwable){

        return " the service you trying call is slow or down!";
    }
    private String fallingDown(Exception ex){
        return "oooo lala we are out of service!!!";
    }
private String rate_lim(Throwable throwable){
        return " the rate_limter_api test";
}
private String bucky(Throwable throwable){

        return "oops ! the number of concurrent calls to the epi exceeded more that is should accept in the application.properties";
}

}
