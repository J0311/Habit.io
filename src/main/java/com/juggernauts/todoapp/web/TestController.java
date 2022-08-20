package com.juggernauts.todoapp.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @PostMapping("/setCatName")
    public String setCatName(@RequestParam("cat") String cat, HttpServletRequest request) {
        if (!StringUtils.hasText(cat)) cat = "no cat";
        request.getSession().setAttribute("catName", cat);
        return String.format("your cat is: %s", cat);
    }

    @GetMapping("/getCatName")
    public String getCatName(HttpSession session) {
        String cat = (String) session.getAttribute("catName");

        if (cat == null) {
            return "you do not have a cat :(";
        } else {
            return String.format("your cat is: %s", cat);
        }
    }
}
