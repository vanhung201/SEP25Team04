package com.SEPTeam04.Admin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    @GetMapping("/account")
    public  String showAccount(Model model){
        return "account";
    }
    @GetMapping("/gtxs")
    public String showGTXS(Model model){
        return "gtxs";
    }
}
