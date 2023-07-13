package org.launchcode.HelloSpring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloSpringController {

    @GetMapping("")
    public String index() {
        return "index";
    }
}
