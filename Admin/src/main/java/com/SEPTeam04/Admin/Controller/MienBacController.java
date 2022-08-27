package com.SEPTeam04.Admin.Controller;

import com.SEPTeam04.Admin.Entity.Ketquadoso;
import com.SEPTeam04.Admin.Entity.Mien;
import com.SEPTeam04.Admin.Entity.TinhThanhpho;
import com.SEPTeam04.Admin.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MienBacController {

    @Autowired
    private MinhNgocService minhNgocService;

    @Autowired
    private DaiPhatService daiPhatService;

    @Autowired
    private GiaiThuongService giaiThuongService;

    @Autowired
    private MienService mienService;

    @Autowired
    private TinhThanhphoService tinhThanhphoService;

    @Autowired
    private FlameService flameService;

    @PostMapping("xosomienbac")
    public String viewListOfMienNam(Model model, @RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") String date, @RequestParam("mien") Integer mien, @RequestParam("tinhthanhpho") Integer tinhthanhpho) {
        minhNgocService.minhNgocResult(String.valueOf(date), mien, tinhthanhpho);
        model.addAttribute("listMN", minhNgocService.minhNgocResult(String.valueOf(date), 1, tinhthanhpho));
        daiPhatService.daiPhatResult(String.valueOf(date), mien, tinhthanhpho);
        model.addAttribute("listDP", daiPhatService.daiPhatResult(String.valueOf(date), 1, tinhthanhpho));
        model.addAttribute("listPrizes", giaiThuongService.getAllGiaiThuong());
        model.addAttribute("listFlame", flameService.flameminhNgocResult(date, 1, tinhthanhpho));
        Mien getmien = mienService.get(3);
        model.addAttribute("mien", getmien);
        model.addAttribute("date", date);
        TinhThanhpho gettinhthanhpho = tinhThanhphoService.get(tinhthanhpho);
        model.addAttribute("getttp", gettinhthanhpho);
        return "xosomienbac";
    }

    @GetMapping("/xosomienbac")
    public String showXosomienbac() {
        return "xosomienbac";
    }

    @GetMapping("/mienbac")
    public String showMienbac() {
        return "mienbac";
    }

    @GetMapping("/editLotteryNumberMB/{id}")
    public String editLotteryNumber(@PathVariable(value = "id") Integer id, Model model) {
        // get Lottery Number from service
        Ketquadoso ketquadoso = flameService.getKetquaId(id);

        //set Admin Account as a model attribute to pre-populate the form
        model.addAttribute("lotteryNumber", ketquadoso);

        return "/editxosomienbac";
    }

    @PostMapping("/saveEditLotteryNumberMB/{id}")
    public String saveEditAdminAccount(@PathVariable(value = "id") Integer id,
                                       @ModelAttribute("lotteryNumber") Ketquadoso ketquadoso, RedirectAttributes attributes) {
        // get Lottery Number from service
        Ketquadoso existingLotteryNumber = flameService.getKetquaId(id);

        existingLotteryNumber.setId(id);
        existingLotteryNumber.setSotrungthuong(ketquadoso.getSotrungthuong());
        existingLotteryNumber.setIdMien(Integer.valueOf(ketquadoso.getIdMien()));
        existingLotteryNumber.setIdTinhthanhpho(Integer.valueOf(ketquadoso.getIdTinhthanhpho()));
        existingLotteryNumber.setIdGiaithuong(Integer.valueOf(ketquadoso.getIdGiaithuong()));
        existingLotteryNumber.setKyhieuve(ketquadoso.getKyhieuve());
        existingLotteryNumber.setNgay(ketquadoso.getNgay());

        // save lottery number into database
        flameService.saveChangeLotteryNumber(ketquadoso);
        attributes.addFlashAttribute("message", "Update Lottery Number successfully.");

        return "redirect:/mienbac";
    }

}