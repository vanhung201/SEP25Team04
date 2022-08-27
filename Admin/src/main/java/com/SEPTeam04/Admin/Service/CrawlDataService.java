package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.*;
import com.SEPTeam04.Admin.Repository.DaiPhatRepository;
import com.SEPTeam04.Admin.Repository.GiaiThuongRepository;
import com.SEPTeam04.Admin.Repository.MinhNgocRepository;
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
public class CrawlDataService {

    @Autowired
    private DaiPhatRepository daiPhatRepository;

    @Autowired
    private MinhNgocRepository minhNgocRepository;

    //Minh Ngọc------------------------------------------------------
    public String CrawlDataMinhNgoc(String url) throws IOException {
        url = urll(url);
        //Connect URL
        Document doc = Jsoup.connect(url).get();

        //Select Element

        //Get GT && SoTrungThuong
        Element table = doc.getElementsByClass("box_kqxs_content").first();
        Element tbody = table.getElementsByTag("tbody").first();
        List<Element> gtstt = tbody.getElementsByTag("tr");
        //Sotrung thuong
        //Get Ngay
        Element classngay = doc.getElementsByClass("ngay").first();
        List<Element> ngay = classngay.getElementsByTag("a");
        String selectdate = ngay.get(0).text();
        String getdate = selectdate.replace("/", "-");
        String[] slgdate = getdate.split("-", 5);
        String getdatefinal = slgdate[2] + "-" + slgdate[1] + "-" + slgdate[0] + " ";
        String[] tachngay = getdatefinal.split(" ", 3);
        String tachngayfinal = tachngay[0];
        //Get Loại vé
        String classloaive = "";
        String tag = "";
        Element classlv = doc.getElementsByClass(classloaive(classloaive, url)).first();
        List<Element> loaive = classlv.getElementsByTag(tagloaive(tag, url));

        //Get Tinh
        Element classtinh = doc.getElementsByClass("pagetitle").first();
        List<Element> tinh = classtinh.getElementsByTag("h1");
        //Get Mien
        Element classmien = doc.getElementsByClass("box_kqxs").first();
        Element tablemien = classmien.getElementsByTag("div").first();
        List<Element> mien = tablemien.getElementsByClass("content");

        List<KetquaMinhNgocDTO> lotteryMinhNgoc = new ArrayList<>();


        for (Element kqgtstt : gtstt) {
            for (Element kqdate : ngay) {
                for (Element kqtinh : tinh) {
                    for (Element kqmien : mien) {
                        for (Element kqloaive : loaive) {

                            List<Element> resultgt = kqgtstt.getElementsByTag("td");
                            List<Element> resultngay = kqdate.getElementsByTag("a");
                            List<Element> resulttinh = kqtinh.getElementsByTag("h1");
                            List<Element> resultmien = kqmien.getElementsByClass("content");
                            List<Element> resultloaive = kqloaive.getElementsByTag(tagloaive(tag, url));
                            String selectgt = resultgt.get(0).text() + " ";
                            String[] tachgt = selectgt.split(" ", 3);
                            String idgiathuong = tachgt[1];
                            switch (idgiathuong) {
                                case "nhất":
                                    idgiathuong = String.valueOf(2);
                                    break;
                                case "nhì":
                                    idgiathuong = String.valueOf(3);
                                    break;
                                case "ba":
                                    idgiathuong = String.valueOf(4);
                                    break;
                                case "tư":
                                    idgiathuong = String.valueOf(5);
                                    break;
                                case "năm":
                                    idgiathuong = String.valueOf(6);
                                    break;
                                case "sáu":
                                    idgiathuong = String.valueOf(7);
                                    break;
                                case "bảy":
                                    idgiathuong = String.valueOf(8);
                                    break;
                                case "8":
                                    idgiathuong = String.valueOf(9);
                                    break;
                                case "ĐB":
                                    idgiathuong = String.valueOf(1);
                                    break;
                            }

                            String str = null;
                            String idmien = "";

                            KetquaMinhNgocDTO ketquaMinhngoc = new KetquaMinhNgocDTO(
                                    resultmien.get(0).text(mientp(idmien, url)).text(),
                                    resulttinh.get(0).text(tinhthanhpho(str, url)).text(),
                                    resultngay.get(0).text(tachngayfinal).text(),
                                    resultloaive.get(0).text(),
                                    resultgt.get(0).text(idgiathuong).text(),
                                    resultgt.get(1).text()
                            );
                            lotteryMinhNgoc.add(ketquaMinhngoc);
                        }
                    }
                }
            }
        }
        for (KetquaMinhNgocDTO kq : lotteryMinhNgoc) {
            saveDBMN(kq);
        }

        return url;
    }

    // URL
    public static String urll(String url) {
        url = url;
        return url;
    }

    //Class Loại Vé
    private static String classloaive(String classlv, String url) throws IOException {
        url = urll(url);
        //Connect URL
        Document doc = Jsoup.connect(url).get();

        Element classmien = doc.getElementsByClass("title-r").last();
        List<Element> idmien = classmien.getElementsByTag("h1");

        classlv = ((Elements) idmien).text();
        switch (classlv) {
            case "Kết quả xổ số Miền Nam":
                classlv = "loaive";
                break;
            case "Kết quả xổ số Miền Trung":
                classlv = "loaive";
                break;
            case "Kết quả xổ số Miền Bắc":
                classlv = "loaive_content";
                break;
        }
        return classlv;
    }

    //Tag loại vé
    private static String tagloaive(String tag, String url) throws IOException {
        url = urll(url);
        //Connect URL
        Document doc = Jsoup.connect(url).get();

        Element classmien = doc.getElementsByClass("title-r").last();
        List<Element> idmien = classmien.getElementsByTag("h1");

        tag = ((Elements) idmien).text();


        switch (tag) {
            case "Kết quả xổ số Miền Nam":
                tag = "span";
                break;
            case "Kết quả xổ số Miền Trung":
                tag = "span";
                break;
            case "Kết quả xổ số Miền Bắc":
                tag = "div";
                break;
        }
        return tag;
    }

    //Get loaive
    private String loaiverl(String loaivestr, String url) throws IOException {
        url = urll(url);
        //Connect URL
        Document doc = Jsoup.connect(url).get();

        Element tablelv = doc.getElementsByClass("bkqtinhmiennam").first();
        Element classlv = tablelv.getElementsByClass("loaive").first();
        List<Element> loaive = classlv.getElementsByTag("span");
        String selectlv = loaive.get(0).text();
        char[] chars = new char[5];
        selectlv.getChars(16, 21, chars, 0);
        loaivestr = String.valueOf(chars);
        return loaivestr;
    }

    //SWITCH CASE MIEN
    private static String mientp(String mien, String url) throws IOException {

        url = urll(url);

        Document doc = Jsoup.connect(url).get();
        Element classmien = doc.getElementsByClass("title-r").last();
        List<Element> idmien = classmien.getElementsByTag("h1");

        mien = ((Elements) idmien).text();
        switch (mien) {
            case "Kết quả xổ số Miền Nam":
                mien = String.valueOf(3);
                break;
            case "Kết quả xổ số Miền Bắc":
                mien = String.valueOf(1);
                break;
            case "Kết quả xổ số Miền Trung":
                mien = String.valueOf(2);
                break;
        }
        return mien;
    }

    // SWITCH CASE TINH THANH PHO
    private String tinhthanhpho(String tinhtp, String url) throws IOException {
        url = urll(url);
        //Connect URL
        Document doc = Jsoup.connect(url).get();

        Element tinh = doc.getElementsByClass("pagetitle").first();
        List<Element> lottery3 = tinh.getElementsByTag("h1");

        tinhtp = ((Elements) lottery3).text();
        switch (tinhtp) {
            case "KẾT QUẢ XỔ SỐ Hà Nội":
                tinhtp = String.valueOf(1);
                break;
            case "KẾT QUẢ XỔ SỐ Quảng Ninh":
                tinhtp = String.valueOf(2);
                break;
            case "KẾT QUẢ XỔ SỐ Bắc Ninh":
                tinhtp = String.valueOf(3);
                break;
            case "KẾT QUẢ XỔ SỐ Hải Phòng":
                tinhtp = String.valueOf(4);
                break;
            case "KẾT QUẢ XỔ SỐ Nam Định":
                tinhtp = String.valueOf(5);
                break;
            case "KẾT QUẢ XỔ SỐ Thái Bình":
                tinhtp = String.valueOf(6);
                break;
            case "KẾT QUẢ XỔ SỐ Thừa T. Huế":
                tinhtp = String.valueOf(7);
                break;
            case "KẾT QUẢ XỔ SỐ Phú Yên":
                tinhtp = String.valueOf(8);
                break;
            case "KẾT QUẢ XỔ SỐ Đắk Lắk":
                tinhtp = String.valueOf(9);
                break;
            case "KẾT QUẢ XỔ SỐ Quảng Nam":
                tinhtp = String.valueOf(10);
                break;
            case "KẾT QUẢ XỔ SỐ Đà Nẵng":
                tinhtp = String.valueOf(11);
                break;
            case "KẾT QUẢ XỔ SỐ Khánh Hòa":
                tinhtp = String.valueOf(12);
                break;
            case "KẾT QUẢ XỔ SỐ Bình Định":
                tinhtp = String.valueOf(13);
                break;
            case "KẾT QUẢ XỔ SỐ Quảng Trị":
                tinhtp = String.valueOf(14);
                break;
            case "KẾT QUẢ XỔ SỐ Quảng Bình":
                tinhtp = String.valueOf(15);
                break;
            case "KẾT QUẢ XỔ SỐ Gia Lai":
                tinhtp = String.valueOf(16);
                break;
            case "KẾT QUẢ XỔ SỐ Ninh Thuận":
                tinhtp = String.valueOf(17);
                break;
            case "KẾT QUẢ XỔ SỐ Quảng Ngãi":
                tinhtp = String.valueOf(18);
                break;
            case "KẾT QUẢ XỔ SỐ Đắk Nông":
                tinhtp = String.valueOf(19);
                break;
            case "KẾT QUẢ XỔ SỐ Kon Tum":
                tinhtp = String.valueOf(20);
                break;
            case "KẾT QUẢ XỔ SỐ TP. HCM":
                tinhtp = String.valueOf(21);
                break;
            case "KẾT QUẢ XỔ SỐ Đồng Tháp":
                tinhtp = String.valueOf(22);
                break;
            case "KẾT QUẢ XỔ SỐ Cà Mau":
                tinhtp = String.valueOf(23);
                break;
            case "KẾT QUẢ XỔ SỐ Bến Tre":
                tinhtp = String.valueOf(24);
                break;
            case "KẾT QUẢ XỔ SỐ Vũng Tàu":
                tinhtp = String.valueOf(25);
                break;
            case "KẾT QUẢ XỔ SỐ Bạc Liêu":
                tinhtp = String.valueOf(26);
                break;
            case "KẾT QUẢ XỔ SỐ Đồng Nai":
                tinhtp = String.valueOf(27);
                break;
            case "KẾT QUẢ XỔ SỐ Cần Thơ":
                tinhtp = String.valueOf(28);
                break;
            case "KẾT QUẢ XỔ SỐ Sóc Trăng":
                tinhtp = String.valueOf(29);
                break;
            case "KẾT QUẢ XỔ SỐ Tây Ninh":
                tinhtp = String.valueOf(30);
                break;
            case "KẾT QUẢ XỔ SỐ An Giang":
                tinhtp = String.valueOf(31);
                break;
            case "KẾT QUẢ XỔ SỐ Bình Thuận":
                tinhtp = String.valueOf(32);
                break;
            case "KẾT QUẢ XỔ SỐ Vĩnh Long":
                tinhtp = String.valueOf(33);
                break;
            case "KẾT QUẢ XỔ SỐ Bình Dương":
                tinhtp = String.valueOf(34);
                break;
            case "KẾT QUẢ XỔ SỐ Trà Vinh":
                tinhtp = String.valueOf(35);
                break;
            case "KẾT QUẢ XỔ SỐ Long An":
                tinhtp = String.valueOf(36);
                break;
            case "KẾT QUẢ XỔ SỐ Bình Phước":
                tinhtp = String.valueOf(37);
                break;
            case "KẾT QUẢ XỔ SỐ Hậu Giang":
                tinhtp = String.valueOf(38);
                break;
            case "KẾT QUẢ XỔ SỐ Tiền Giang":
                tinhtp = String.valueOf(39);
                break;
            case "KẾT QUẢ XỔ SỐ Kiên Giang":
                tinhtp = String.valueOf(40);
                break;
            case "KẾT QUẢ XỔ SỐ Đà Lạt":
                tinhtp = String.valueOf(41);
                break;


        }
        return tinhtp;
    }

    //SaveDBMinhNgoc
    public void saveDBMN(@RequestBody KetquaMinhNgocDTO crl) {
        KetquaMinhngoc ketquaMinhngoc = new KetquaMinhngoc();

        ketquaMinhngoc.setIdGiaithuong(crl.getGiaithuong());
        ketquaMinhngoc.setSotrungthuong(crl.getSotrungthuong());
        ketquaMinhngoc.setNgay(crl.getNgay());
        ketquaMinhngoc.setKyhieuve(crl.getLoaive());
        ketquaMinhngoc.setIdTinhthanhpho(crl.getTinh());
        ketquaMinhngoc.setIdMien(crl.getMien());
        minhNgocRepository.save(ketquaMinhngoc);
    }

    //Đại Phát--------------------------------------------------------
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
            saveDBDP(kq);
        }

        return url;
    }

    //SaveDBDaiPhat
    public void saveDBDP(@RequestBody KetquaDaiPhatDTO crl) {
        KetquaDaiphat ketquaDaiphat = new KetquaDaiphat();
        ketquaDaiphat.setIdGiaithuong(crl.getGiaithuong());
        ketquaDaiphat.setSotrungthuong(crl.getSotrungthuong());
        ketquaDaiphat.setNgay(crl.getNgay());
        ketquaDaiphat.setKyhieuve(crl.getLoaive());
        ketquaDaiphat.setIdTinhthanhpho(Integer.valueOf(crl.getTinh()));
        ketquaDaiphat.setIdMien(Integer.valueOf(crl.getMien()));
        daiPhatRepository.save(ketquaDaiphat);
    }
    //Flame-------------------------------------
}
