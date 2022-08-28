package com.SEPTeam04.User.Controller;

import com.SEPTeam04.User.Entity.Mien;
import com.SEPTeam04.User.Entity.TinhThanhpho;
import com.SEPTeam04.User.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MienBacController {

    @Autowired
    private GiaiThuongService giaiThuongService;

    @Autowired
    private MienService mienService;

    @Autowired
    private TinhThanhphoService tinhThanhphoService;

    @Autowired
    private FlameService flameService;

    @PostMapping("xosomienbac")
    public String viewListOfMienBac(Model model, @RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") String date, @RequestParam("mien") Integer mien, @RequestParam("tinhthanhpho") Integer tinhthanhpho) {

        model.addAttribute("listPrizes", giaiThuongService.getAllGiaiThuong());
        model.addAttribute("listFlame", flameService.flameResult(date, 1, tinhthanhpho));
        Mien getmien = mienService.get(1);
        model.addAttribute("mien", getmien);
        model.addAttribute("date", date);
        TinhThanhpho gettinhthanhpho = tinhThanhphoService.get(tinhthanhpho);
        model.addAttribute("getttp", gettinhthanhpho);

        return "xosomienbac";
    }

    @GetMapping("/xosomienbac")
    public String showXoSoMienBac() {
        return "xosomienbac";
    }

    @GetMapping("/mienbac")
    public String showMienBac() {
        return "mienbac";
    }

    @GetMapping("/")
    public String showIndex() {
        return "mienbac";
    }

}