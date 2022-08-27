package com.SEPTeam04.Admin.Controller;

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

import java.io.IOException;

@Controller
public class CrawlDataController {
    @Autowired
    private CrawlDataServiceMN crawlDataServiceMN;
    @Autowired
    private CrawlDataServiceDP crawlDataServiceDP;
    @Autowired
    private CrawlDataService crawlDataService;
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
    private MinhNgocGetRepository minhNgocGetRepository;
    @PostMapping("crawldata")
    public String CrawlDataMinhNgocNL(@RequestParam(value = "url") String url,@RequestParam(value = "urlDP")String urlDP, RedirectAttributes redirectAttributes) throws IOException {
            crawlDataService.CrawlDataMinhNgoc(url);
            crawlDataService.urll(url);
            crawlDataService.CrawlDataDaiPhat(urlDP);
            redirectAttributes.addFlashAttribute("messageCrawlsc","Crawl Data Successfulyy");
        return "redirect:/crawldetail";
    }


    @PostMapping("getdetail")
    public String viewListOfDetail(Model model, @RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") String date, @RequestParam("mien") Integer mien, @RequestParam("tinhthanhpho") Integer tinhthanhpho, RedirectAttributes redirectAttributes) {
        minhNgocService.minhNgocResult(String.valueOf(date), mien, tinhthanhpho);
        model.addAttribute("listMN", minhNgocService.minhNgocResult(String.valueOf(date), mien,tinhthanhpho));
        daiPhatService.daiPhatResult(String.valueOf(date), mien, tinhthanhpho);
        model.addAttribute("listDP", daiPhatService.daiPhatResult(String.valueOf(date), mien, tinhthanhpho));
        model.addAttribute("listPrizes", giaiThuongService.getAllGiaiThuong());
        Mien getmien = mienService.get(mien);
        model.addAttribute("getmien", getmien);
        model.addAttribute("date", date);
        TinhThanhpho gettinhthanhpho = tinhThanhphoService.get(tinhthanhpho);
        model.addAttribute("getttp", gettinhthanhpho);

        return "detaillottery";
    }

    @GetMapping("/crawldata")
    public String showCrawlurlMN(){
        return "crawldata";
    }

    @GetMapping("/crawldetail")
    public String showCrawlDetail(){
        return "crawldetail";
    }

    @GetMapping("/detaillottery")
    public String showDetailLotery(){
        return "detaillottery";
    }

}
