package com.SEPTeam04.Admin.Controller;

import com.SEPTeam04.Admin.Entity.Giaithuong;
import com.SEPTeam04.Admin.Service.GiaiThuongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GiaiThuongController {

    @Autowired
    private GiaiThuongService giaiThuongService;

    @GetMapping("/prize")
    public String viewListPrize(Model model) {
        model.addAttribute("listPrizes", giaiThuongService.getAllGiaiThuong());

        return "/prize";
    }

    @GetMapping("/addPrize")
    public String addPrize(Model model) {
        // create model attribute to bind form data
        Giaithuong giaithuong = new Giaithuong();
        model.addAttribute("prize", giaithuong);

        return "/add-prize";
    }

    @PostMapping("/savePrize")
    public String savePrize(@ModelAttribute("prize") Giaithuong giaithuong, RedirectAttributes attributes) {
        // save admin account to database
        giaiThuongService.saveGiaiThuong(giaithuong);
        attributes.addFlashAttribute("message", "Add new prize successfully.");

        return "redirect:/prize";
    }

    @GetMapping("/editPrize/{id}")
    public String editPrize(@PathVariable(value = "id") Integer id, Model model) {
        // get Admin Account from service
        Giaithuong giaithuong = giaiThuongService.getGiaiThuongById(id);

        //set Admin Account as a model attribute to pre-populate the form
        model.addAttribute("prize", giaithuong);

        return "/edit-prize";
    }

    @GetMapping("/deletePrize/{id}")
    public String deletePrize(@PathVariable (value = "id") Integer id, RedirectAttributes attributes) {
        // call delete Admin Account method
        this.giaiThuongService.deleteGiaiThuongById(id);
        attributes.addFlashAttribute("message", "Delete prize successfully.");

        return "redirect:/prize";
    }
}
