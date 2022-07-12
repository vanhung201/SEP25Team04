package com.SEPTeam04.Admin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MienBacController {
    @GetMapping("/mienbac")
    public String showMienBac(@PathVariable("url") String url) {

        return url;
    }
}
