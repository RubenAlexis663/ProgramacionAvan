package com.microservices.mifirstmicroservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class controller {

    @GetMapping("/hola")
    public String holamundo(){
        return "Hola mundo, como va todoooooo XD";
    }

}
