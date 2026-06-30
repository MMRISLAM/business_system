package com.business_system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/wallet")
    public String wallet(){
        return "wallet";
    }

    @GetMapping("/tree")
    public String tree(){
        return "tree";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
}
