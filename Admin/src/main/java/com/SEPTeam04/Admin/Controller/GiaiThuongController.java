package com.SEPTeam04.Admin.Controller;

import com.SEPTeam04.Admin.Entity.AdminAccount;
import com.SEPTeam04.Admin.Entity.Giaithuong;
import com.SEPTeam04.Admin.Service.GiaiThuongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GiaiThuongController {

    @Autowired
    private GiaiThuongService giaiThuongService;

    @GetMapping("/gtxs")
    public String viewListOfAdminAccount(Model model) {
        model.addAttribute("listPrizes", giaiThuongService.getAllGiaiThuong());

        return "/gtxs";
    }

    @GetMapping("/prize/newPrize")
    public String showAddNewPrizeForm(Model model) {
        // create model attribute to bind form data
        Giaithuong giaithuong = new Giaithuong();
        model.addAttribute("prize", giaithuong);

        return "/new_gtxs";
    }

    @PostMapping("/prize/savePrize")
    public String saveAdminAccount(@ModelAttribute("prize") Giaithuong giaithuong) {
        // save admin account to database
        giaiThuongService.saveGiaiThuong(giaithuong);

        return "redirect:/gtxs";
    }

    @GetMapping("/prize/editPrize/{id}")
    public String editAdminAccount(@PathVariable(value = "id") Integer id, Model model) {
        // get Admin Account from service
        Giaithuong giaithuong = giaiThuongService.getGiaiThuongById(id);

        //set Admin Account as a model attribute to pre-populate the form
        model.addAttribute("prize", giaithuong);

        return "/edit_gtxs";
    }

    @GetMapping("/prize/deletePrize/{id}")
    public String deleteAdminAccount(@PathVariable (value = "id") Integer id, Model model) {
        // call delete Admin Account method
        this.giaiThuongService.deleteGiaiThuongById(id);

        return "redirect:/gtxs";
    }
}
