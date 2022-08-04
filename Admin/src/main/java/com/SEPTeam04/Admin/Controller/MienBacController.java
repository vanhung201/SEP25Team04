package com.SEPTeam04.Admin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MienBacController {

    @GetMapping("/xosomienbac")
    public String showMienBac(Model model) {

        return "/index";
    }
}
