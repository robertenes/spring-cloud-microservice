package com.gateway.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fb")
public class HystrixController {

    @GetMapping("/customer")
    public String customerFallBack() {
        return "Customer Service is not available";
    }

    @GetMapping("/card")
    public String cardFallBack() {
        return "Card Service is not available";
    }


}
