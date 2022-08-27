package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.KetquaDaiPhatDTO;
import com.SEPTeam04.Admin.Entity.KetquaDaiphat;
import com.SEPTeam04.Admin.Repository.DaiPhatRepository;
import com.SEPTeam04.Admin.Repository.GiaiThuongRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CrawlDataServiceDP {

    @Autowired
    private DaiPhatRepository daiPhatRepository;

    public String CrawlDataDaiPhat(String url) throws IOException {

        //Connect URL
        Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
        //Get GT & STT
        Element table = doc.getElementsByClass("table table-bordered table-striped table-xsmb").first();
        //System.out.println(table.text());
        Elements gtstt = table.getElementsByTag("tr").next();
        //GetNgay
        Element classh2 = doc.getElementsByClass("class-title-list-link").first();
        Element taga = classh2.getElementsByClass("u-line").last();
        List<Element> ngay = taga.getElementsByTag("a");
        String selectdate = ngay.get(0).text();
        String a = selectdate.replace("/", "-");
        String[] slgdate = a.split(" ", 3);
        String getdatefisrt = slgdate[1];
        String[] splitdate = getdatefisrt.split("-", 3);
        String getdate = splitdate[2] + "-" + splitdate[1] + "-" + splitdate[0] + " ";
        String[] getdatenext = getdate.split(" ", 3);
        String tachngayfinal = getdatenext[0];
        System.out.println(tachngayfinal);
        String[] tachngay = selectdate.split(" ", 2);
        //GetMien
        String idmien = tachngay[0];
        switch (idmien) {
            case "XSMN":
                idmien = String.valueOf(3);
                break;
            case "XSMB":
                idmien = String.valueOf(1);
                break;
            case "XSMT":
                idmien = String.valueOf(2);
                break;

        }

        //GetTinh
        Element classtinh2 = doc.getElementsByClass("block-main-heading").last();
        List<Element> tinh = classtinh2.getElementsByTag("h1");
        String selecttinh = tinh.get(0).text();

        String[] tachtinh = selecttinh.split(" ", 3);
        String idtinh = tachtinh[0];

        switch (idtinh) {
            case "XSTD":
                idtinh = String.valueOf(1);
                break;
            case "XSQN":
                idtinh = String.valueOf(2);
                break;
            case "XSBN":
                idtinh = String.valueOf(3);
                break;
            case "XSHP":
                idtinh = String.valueOf(4);
                break;
            case "XSND":
                idtinh = String.valueOf(5);
                break;
            case "XSTB":
                idtinh = String.valueOf(6);
                break;
            case "XSTTH":
                idtinh = String.valueOf(7);
                break;
            case "XSPY":
                idtinh = String.valueOf(8);
                break;
            case "XSDLK":
                idtinh = String.valueOf(9);
                break;
            case "XSQNA":
                idtinh = String.valueOf(10);
                break;
            case "XSDNA":
                idtinh = String.valueOf(11);
                break;
            case "XSKH":
                idtinh = String.valueOf(12);
                break;
            case "XSBDI":
                idtinh = String.valueOf(13);
                break;
            case "XSQT":
                idtinh = String.valueOf(14);
                break;
            case "XSQB":
                idtinh = String.valueOf(15);
                break;
            case "XSGL":
                idtinh = String.valueOf(16);
                break;
            case "XSNT":
                idtinh = String.valueOf(17);
                break;
            case "XSQNG":
                idtinh = String.valueOf(18);
                break;
            case "XSDNO":
                idtinh = String.valueOf(19);
                break;
            case "XSKT":
                idtinh = String.valueOf(20);
                break;
            case "XSHCM":
                idtinh = String.valueOf(21);
                break;
            case "XSDT":
                idtinh = String.valueOf(22);
                break;
            case "XSCM":
                idtinh = String.valueOf(23);
                break;
            case "XSBTR":
                idtinh = String.valueOf(24);
                break;
            case "XSVT":
                idtinh = String.valueOf(25);
                break;
            case "XSBL":
                idtinh = String.valueOf(26);
                break;
            case "XSDN":
                idtinh = String.valueOf(27);
                break;
            case "XSCT":
                idtinh = String.valueOf(28);
                break;
            case "XSST":
                idtinh = String.valueOf(29);
                break;
            case "XSTN":
                idtinh = String.valueOf(30);
                break;
            case "XSAG":
                idtinh = String.valueOf(31);
                break;
            case "XSBT":
                idtinh = String.valueOf(32);
                break;
            case "XSVL":
                idtinh = String.valueOf(33);
                break;
            case "XSBD":
                idtinh = String.valueOf(34);
                break;
            case "XSTV":
                idtinh = String.valueOf(35);
                break;
            case "XSLA":
                idtinh = String.valueOf(36);
                break;
            case "XSBP":
                idtinh = String.valueOf(37);
                break;
            case "XSHG":
                idtinh = String.valueOf(38);
                break;
            case "XSTG":
                idtinh = String.valueOf(39);
                break;
            case "XSKG":
                idtinh = String.valueOf(40);
                break;
            case "XSDL":
                idtinh = String.valueOf(41);
                break;
        }

        List<KetquaDaiPhatDTO> lotteryDaiPhat = new ArrayList<>();
        for (Element kqgtstt : gtstt) {
            for (Element kqdate : ngay) {
                for (Element kqtinh : tinh) {
                    for (Element kqmien : ngay) {
                        List<Element> resultgt = kqgtstt.getElementsByTag("td");
                        List<Element> resultngay = kqdate.getElementsByTag("a");
                        List<Element> resulttinh = kqtinh.getElementsByTag("h1");
                        List<Element> resultmien = kqmien.getElementsByTag("a");
                        String selectgt = resultgt.get(0).text() + " ";
                        String[] tachgt = selectgt.split(" ", 3);
                        String idgiathuong = tachgt[0];
                        switch (idgiathuong) {
                            case "G.1":
                                idgiathuong = String.valueOf(2);
                                break;
                            case "G.2":
                                idgiathuong = String.valueOf(3);
                                break;
                            case "G.3":
                                idgiathuong = String.valueOf(4);
                                break;
                            case "G.4":
                                idgiathuong = String.valueOf(5);
                                break;
                            case "G.5":
                                idgiathuong = String.valueOf(6);
                                break;
                            case "G.6":
                                idgiathuong = String.valueOf(7);
                                break;
                            case "G.7":
                                idgiathuong = String.valueOf(8);
                                break;
                            case "G.8":
                                idgiathuong = String.valueOf(9);
                                break;
                            case "ĐB":
                                idgiathuong = String.valueOf(1);
                                break;
                            case "G.ĐB":
                                idgiathuong = String.valueOf(1);
                                break;
                            case "G.DB":
                                idgiathuong = String.valueOf(1);
                                break;
                        }

                        KetquaDaiPhatDTO ketquaDaiphat = new KetquaDaiPhatDTO(
                                resultgt.get(0).text(idgiathuong).text(),
                                resultgt.get(1).text(),
                                resultngay.get(0).text(tachngayfinal).text(),
                                resulttinh.get(0).text(idtinh).text(),
                                resultmien.get(0).text(idmien).text()
                        );
                        lotteryDaiPhat.add(ketquaDaiphat);
                    }
                }
            }
        }
        for (KetquaDaiPhatDTO kq : lotteryDaiPhat) {
            saveDB(kq);
        }

        return url;
    }

    public void saveDB(KetquaDaiPhatDTO crl) {
        KetquaDaiphat ketquaDaiphat = new KetquaDaiphat();
        ketquaDaiphat.setIdGiaithuong(crl.getGiaithuong());
        ketquaDaiphat.setSotrungthuong(crl.getSotrungthuong());
        ketquaDaiphat.setNgay(crl.getNgay());
        ketquaDaiphat.setKyhieuve(crl.getLoaive());
        ketquaDaiphat.setIdTinhthanhpho(Integer.valueOf(crl.getTinh()));
        ketquaDaiphat.setIdMien(Integer.valueOf(crl.getMien()));
        daiPhatRepository.save(ketquaDaiphat);
    }

}
