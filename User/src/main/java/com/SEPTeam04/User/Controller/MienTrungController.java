package com.SEPTeam04.User.Controller;

import com.SEPTeam04.User.Entity.Ketquadoso;
import com.SEPTeam04.User.Entity.Mien;
import com.SEPTeam04.User.Entity.TinhThanhpho;
import com.SEPTeam04.User.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MienTrungController {

    @Autowired
    private GiaiThuongService giaiThuongService;

    @Autowired
    private FlameService flameService;

    @Autowired
    private MienService mienService;

    @Autowired
    private TinhThanhphoService tinhThanhphoService;

    @PostMapping("xosomientrung")
    public String viewListOfMienTrung(Model model, @RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") String date, @RequestParam("mien") Integer mien, @RequestParam("tinhthanhpho") Integer tinhthanhpho) {

        model.addAttribute("listPrizes", giaiThuongService.getAllGiaiThuong());
        model.addAttribute("listFlame", flameService.flameResult(date, 2, tinhthanhpho));
        Mien getmien = mienService.get(2);
        model.addAttribute("mien", getmien);
        model.addAttribute("date", date);
        TinhThanhpho gettinhthanhpho = tinhThanhphoService.get(tinhthanhpho);
        model.addAttribute("getttp", gettinhthanhpho);

        return "/xosomientrung";
    }

    @GetMapping("/xosomientrung")
    public String showXoSoMienTrung() {

        return "xosomientrung";
    }

    @GetMapping("/mientrung")
    public String showMienTrung() {

        return "mientrung";
    }

}