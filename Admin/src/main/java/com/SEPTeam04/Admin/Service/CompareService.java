package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.KetquaDaiphat;
import com.SEPTeam04.Admin.Entity.KetquaMinhngoc;
import com.SEPTeam04.Admin.Entity.Ketquadoso;
import com.SEPTeam04.Admin.Repository.DaiPhatGetRepository;
import com.SEPTeam04.Admin.Repository.FlameRepository;
import com.SEPTeam04.Admin.Repository.MinhNgocGetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Service
public class CompareService {
    @Autowired
    private DaiPhatGetRepository daiPhatGetRepository;

    @Autowired
    private MinhNgocGetRepository minhNgocGetRepository;
    @Autowired
    MinhNgocService minhNgocService;
    @Autowired
    private FlameRepository flameRepository;
    @Autowired
    private GiaiThuongService giaiThuongService;
    // @Autowired
    // private KetquaMapper ketquaMapper;

    private KetquaMinhngoc comPare(KetquaMinhngoc ketquaMinhngoc, KetquaDaiphat ketquaDaiphat) {
        return ketquaMinhngoc.getSotrungthuong().equals(ketquaDaiphat.getSotrungthuong()) ? ketquaMinhngoc : null;
    }

    public void saveFlame(String date, Integer id_mien, Integer id_tinhthanhpho, RedirectAttributes redirectAttributes) {
        List<KetquaMinhngoc> minhngocList = minhNgocGetRepository.findAllByNgayAndIdMienAndIdTinhthanhphoOrderByIdGiaithuongAsc(date, id_mien, id_tinhthanhpho);
        List<KetquaDaiphat> daiphatList = daiPhatGetRepository.findAllByNgayAndIdMienAndIdTinhthanhphoOrderByIdGiaithuongAsc(date, id_mien, id_tinhthanhpho);

        for (int i = 0; i < minhngocList.size(); i++) {
            var ketqua = comPare(minhngocList.get(i), daiphatList.get(i));
            if (ketqua != null) {
                // goi ham save
                var ketquadoso = new Ketquadoso();
                //var ketquadoso = ketquaMapper.toMapper(ketqua);
                ketquadoso.setIdMien(ketqua.getIdMien());
                ketquadoso.setIdTinhthanhpho(ketqua.getIdTinhthanhpho());
                ketquadoso.setIdGiaithuong(ketqua.getIdGiaithuong());
                ketquadoso.setKyhieuve(ketqua.getKyhieuve());
                ketquadoso.setNgay(ketqua.getNgay());
                ketquadoso.setSotrungthuong(ketqua.getSotrungthuong());
                flameRepository.save(ketquadoso);
            } else {
                var ketquadoso = new Ketquadoso();
                ketquadoso.setIdMien(id_mien);
                ketquadoso.setIdTinhthanhpho(id_tinhthanhpho);
                ketquadoso.setNgay(date);
                ketquadoso.setSotrungthuong("null");
                redirectAttributes.addFlashAttribute("messageError", "Convert Faild Because Lottery Does Not Match");
                flameRepository.save(ketquadoso);
            }
        }
    }
}