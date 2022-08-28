package com.SEPTeam04.User.Controller;

import com.SEPTeam04.User.Service.GiaiThuongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GiaiThuongController {

    @Autowired
    private GiaiThuongService giaiThuongService;

    public GiaiThuongController() {

    }

    public GiaiThuongController(GiaiThuongService giaiThuongService) {
        this.giaiThuongService = giaiThuongService;
    }

    @GetMapping("/prize")
    public String viewListPrize(Model model) {
        model.addAttribute("listPrizes", giaiThuongService.getAllGiaiThuong());

        return "/prize";
    }



}
