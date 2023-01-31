package com.example.thymeleafexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fragment")
public class TemplateController {

    @GetMapping("/footer")
    public String fragmentTest(Model model) {
        return "fragmentMain";
    }

    @GetMapping("/layout")
    public String layoutTest(Model model) {
        return "layoutMain";
    }

}
