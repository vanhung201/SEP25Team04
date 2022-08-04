package com.SEPTeam04.Admin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TinhThanhPhoController {

    @GetMapping("/xosotinhthanhpho")
    public String showTinhThanhPho(Model model) {

        return "/xosotinhthanhpho";
    }
}
