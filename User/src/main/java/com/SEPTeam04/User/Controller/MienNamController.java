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
public class MienNamController {

    @Autowired
    private GiaiThuongService giaiThuongService;

    @Autowired
    private MienService mienService;

    @Autowired
    private TinhThanhphoService tinhThanhphoService;

    @Autowired
    private FlameService flameService;

    @PostMapping("getdateMN")
    public String viewListOfMienNam(Model model, @RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") String date, @RequestParam("mien") Integer mien, @RequestParam("tinhthanhpho") Integer tinhthanhpho) {

        model.addAttribute("listPrizes", giaiThuongService.getAllGiaiThuong());
        model.addAttribute("listFlame", flameService.flameResult(date, 3, tinhthanhpho));
        Mien getmien = mienService.get(3);
        model.addAttribute("mien", getmien);
        model.addAttribute("date", date);
        TinhThanhpho gettinhthanhpho = tinhThanhphoService.get(tinhthanhpho);
        model.addAttribute("getttp", gettinhthanhpho);

        return "xosomiennam";
    }

    @GetMapping("/xosomiennam")
    public String showXoSoMienNam() {

        return "xosomiennam";
    }

    @GetMapping("/miennam")
    public String showMienNam() {

        return "miennam";
    }

}