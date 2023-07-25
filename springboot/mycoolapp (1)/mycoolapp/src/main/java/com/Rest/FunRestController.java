package com.Rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FunRestController {

    @RequestMapping("/error")
    @ResponseBody
    public String handleError() {
        return "This is a custom error page.";
    }
}