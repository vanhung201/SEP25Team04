package com.SEPTeam04.Admin.Controller;

import com.SEPTeam04.Admin.Service.DaiPhatService;
import com.SEPTeam04.Admin.Service.GiaiThuongService;
import com.SEPTeam04.Admin.Service.MinhNgocService;
import com.SEPTeam04.Admin.Service.TinhThanhphoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TinhThanhPhoController {

    @Autowired
    private TinhThanhphoService tinhThanhphoService;
    @Autowired
    private MinhNgocService minhNgocService;

    @Autowired
    private DaiPhatService daiPhatService;

    @Autowired
    private GiaiThuongService giaiThuongService;

    @PostMapping("getttpadate")
    public String viewListOfMienBac(Model model, @RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") String date, @RequestParam("mien") Integer mien, @RequestParam("tinhthanhpho") Integer tinhthanhpho) {

        model.addAttribute("listTTP", tinhThanhphoService.getAllTinhThanhpho());
        minhNgocService.minhNgocResult(String.valueOf(date), mien, tinhthanhpho);

        model.addAttribute("listMN", minhNgocService.minhNgocResult(String.valueOf(date), mien, tinhthanhpho));

        daiPhatService.daiPhatResult(String.valueOf(date), mien, tinhthanhpho);
        model.addAttribute("listDP", daiPhatService.daiPhatResult(String.valueOf(date), mien, tinhthanhpho));

        model.addAttribute("listPrizes", giaiThuongService.getAllGiaiThuong());

        return "xosotinhthanhpho";
    }

    @GetMapping("/xosotinhthanhpho")
    public String showCrawlurlDP() {

        return "xosotinhthanhpho";
    }
}
