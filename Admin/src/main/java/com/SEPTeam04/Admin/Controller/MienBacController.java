package com.SEPTeam04.Admin.Controller;

import com.SEPTeam04.Admin.Service.DaiPhatService;
import com.SEPTeam04.Admin.Service.MinhNgocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MienBacController {

    @Autowired
    private MinhNgocService minhNgocService;

    @Autowired
    private DaiPhatService daiPhatService;

    @GetMapping("/xosomienbac")
    public String viewListOfMienBac(Model model, @RequestParam("date") String date, @RequestParam("mien") Integer id_mien) {

        model.addAttribute("listMN", minhNgocService.minhNgocResult(date, id_mien));
        model.addAttribute("listDP", daiPhatService.daiPhatResult(date, id_mien));
        return "/index";
    }


}
