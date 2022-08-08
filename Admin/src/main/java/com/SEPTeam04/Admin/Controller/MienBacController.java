package com.SEPTeam04.Admin.Controller;

import com.SEPTeam04.Admin.Entity.KetquaMinhngocT;
import com.SEPTeam04.Admin.Service.MienBacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MienBacController {

    @Autowired
    private MienBacService service;

    @GetMapping("/xosomienbac")
    public String showMienBac(Model model) {

        List<KetquaMinhngocT> listMienBac = service.listAll();
        model.addAttribute("listMienBac", listMienBac);

        return "/index";
    }

}
