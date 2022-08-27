package com.SEPTeam04.Admin.Controller;

import com.SEPTeam04.Admin.Entity.Ketquadoso;
import com.SEPTeam04.Admin.Entity.Mien;
import com.SEPTeam04.Admin.Entity.TinhThanhpho;
import com.SEPTeam04.Admin.Repository.MinhNgocGetRepository;
import com.SEPTeam04.Admin.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MienTrungController {
    @Autowired
    private MinhNgocService minhNgocService;

    @Autowired
    private DaiPhatService daiPhatService;

    @Autowired
    private GiaiThuongService giaiThuongService;

    @Autowired
    private FlameService flameService;

    @Autowired
    private MienService mienService;

    @Autowired
    private TinhThanhphoService tinhThanhphoService;

    @Autowired
    private MinhNgocGetRepository minhNgocGetRepository;

    @PostMapping("xosomientrung")
    public String viewListOfMienNam(Model model, @RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") String date, @RequestParam("mien") Integer mien, @RequestParam("tinhthanhpho") Integer tinhthanhpho) {
        var ketquadosoList = minhNgocGetRepository.findAllByNgayAndIdMienAndIdTinhthanhphoOrderByIdGiaithuongAsc(date, mien, tinhthanhpho);
        minhNgocService.minhNgocResult(String.valueOf(date), mien, tinhthanhpho);
        model.addAttribute("listMN", minhNgocService.minhNgocResult(String.valueOf(date), 2, tinhthanhpho));
        daiPhatService.daiPhatResult(String.valueOf(date), mien, tinhthanhpho);
        model.addAttribute("listDP", daiPhatService.daiPhatResult(String.valueOf(date), 2, tinhthanhpho));
        model.addAttribute("listPrizes", giaiThuongService.getAllGiaiThuong());
        model.addAttribute("listFlame", flameService.flameminhNgocResult(date, 2, tinhthanhpho));
        Mien getmien = mienService.get(2);
        model.addAttribute("mien", getmien);
        model.addAttribute("date", date);
        TinhThanhpho gettinhthanhpho = tinhThanhphoService.get(tinhthanhpho);
        model.addAttribute("getttp", gettinhthanhpho);

        return "/xosomientrung";
    }

    @GetMapping("/xosomientrung")
    public String showXosomientrung() {
        return "xosomientrung";
    }

    @GetMapping("/mientrung")
    public String showMientrung() {
        return "mientrung";
    }

    @GetMapping("/editLotteryNumber/{id}")
    public String editLotteryNumber(@PathVariable(value = "id") Integer id, Model model) {
        // get Lottery Number from service
        Ketquadoso ketquadoso = flameService.getKetquaId(id);

        //set Admin Account as a model attribute to pre-populate the form
        model.addAttribute("lotteryNumber", ketquadoso);

        return "/editxosomientrung";
    }

    @PostMapping("/saveEditLotteryNumber/{id}")
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

        return "redirect:/mientrung";
    }
}