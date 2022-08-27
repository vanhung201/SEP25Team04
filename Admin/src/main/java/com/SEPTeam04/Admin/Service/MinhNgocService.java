package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.KetquaMinhngoc;
import com.SEPTeam04.Admin.Repository.MinhNgocGetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinhNgocService {

    @Autowired
    private MinhNgocGetRepository minhNgocRepository;

    public MinhNgocService() {

    }

    public MinhNgocService(MinhNgocGetRepository repository) {

        this.minhNgocRepository = repository;
    }

    public List<KetquaMinhngoc> minhNgocResult(String date, Integer id_mien, Integer id_tinhthanhpho) {

        return minhNgocRepository.findAllByNgayAndIdMienAndIdTinhthanhphoOrderByIdGiaithuongAsc(date, id_mien, id_tinhthanhpho);
    }
}
