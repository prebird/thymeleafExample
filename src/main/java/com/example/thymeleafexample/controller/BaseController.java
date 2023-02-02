package com.example.thymeleafexample.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
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

    @GetMapping("date")
    public String date(Model model) {
        model.addAttribute("todayDate", LocalDateTime.now());
        model.addAttribute("todayDateTime", LocalDateTime.now());
        return "date";
    }

    @GetMapping("url")
    public String url(Model model) {
        model.addAttribute("itemId", "ITEM1234");
        model.addAttribute("page", 1);
        return "url";
    }

    @GetMapping("literal")
    public String literal(Model model) {
        model.addAttribute("data", "홍길동");
        return "literal";
    }

    @GetMapping("operator")
    public String operator(Model model) {
        model.addAttribute("nullData", null);
        model.addAttribute("data", "spring!!");
        return "operator";
    }

    @GetMapping("attribute")
    public String attribute() {
        return "attribute";
    }

    @GetMapping("each")
    public String each(Model model) {
        addUsers(model);
        return "each";
    }

    private void addUsers(Model model) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("user1", 10));
        users.add(new User("user2", 30));
        users.add(new User("user3", 40));
        model.addAttribute("users", users);
    }

    @GetMapping("condition")
    public String condition(Model model) {
        addUsers(model);
        return "condition";
    }

}
