package com.SEPTeam04.Admin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MienTrungController {

    @GetMapping("/xosomientrung")
    public String showMienTrung(Model model) {

        return "/xosomientrung";
    }
}
