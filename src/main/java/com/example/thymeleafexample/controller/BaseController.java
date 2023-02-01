package com.example.thymeleafexample.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/base")
public class BaseController {

    @GetMapping("text")
    public String text(Model model) {

        model.addAttribute("data", "Spring 시작했습니다.");
        model.addAttribute("udata", "<b>스프링</b>시작했습니다.");

        return "text";
    }

    @GetMapping("springEL")
    public String springEL(Model model) {

        User user = new User("이승철", 30);
        List<User> userList = List.of(new User("김진만", 44),
                new User("김중기", 40));

        Map<String, User> userMap = Map.of("식객", new User("이주빈", 29));


        model.addAttribute("user", user);
        model.addAttribute("userList", userList);
        model.addAttribute("userMap", userMap);

        return "springEL";
    }

    @GetMapping("basicObject")
    public String basicObject(HttpSession session) {
        session.setAttribute("sessionData", "iopen");
        return "basic-object";
    }

    @Component("helloBean")
    public class HelloBean {
        public String hello(String text) {
            return "HI MY NAME IS " + text;
        }
    }

}
