package com.SEPTeam04.Admin.Controller;

import com.SEPTeam04.Admin.Repository.FlameRepository;
import com.SEPTeam04.Admin.Service.CompareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class FlameController {
    @Autowired
    private CompareService compareService;
    @Autowired
    private FlameRepository flameRepository;
    @PostMapping("insertflame")
    public String viewListOfMienNam(Model model, @RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") String date, @RequestParam("mien") Integer mien, @RequestParam("tinhthanhpho") Integer tinhthanhpho, RedirectAttributes redirectAttributes) {
        var ketquadosoList = flameRepository.findAllByNgayAndIdMienAndIdTinhthanhphoOrderByIdGiaithuongAsc(date, mien, tinhthanhpho);
        if (ketquadosoList.size() == 0 || ketquadosoList == null) {
            compareService.saveFlame(date, mien, tinhthanhpho, redirectAttributes);
            redirectAttributes.addFlashAttribute("message","Convert Successfulyy");
        }else if (ketquadosoList.size() != 0 || ketquadosoList != null) {
            redirectAttributes.addFlashAttribute("messagedataal","Convert Failed Because Data Already Exists");
        } else {
            redirectAttributes.addFlashAttribute("messageError","Convert Faild Because Lottery Does Not Match");
        }

        return "redirect:/crawldetail";
    }
}
