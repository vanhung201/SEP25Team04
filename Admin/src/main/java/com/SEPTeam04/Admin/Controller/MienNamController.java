package com.SEPTeam04.Admin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MienNamController {
    @GetMapping("/miennam")
    public String showMiennam(Model model){
        return "miennam";
    }
    @GetMapping("miennam/baclieu")
    public String showBacLieu(Model model){
        return "baclieu";
    }
}
