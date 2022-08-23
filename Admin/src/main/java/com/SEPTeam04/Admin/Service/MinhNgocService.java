package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.KetquaMinhngoc;
import com.SEPTeam04.Admin.Repository.MinhNgocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MinhNgocService {

    @Autowired
    private MinhNgocRepository repository;

    public MinhNgocService() {

    }

    public MinhNgocService(MinhNgocRepository repository) {
        this.repository = repository;
    }

    public List<KetquaMinhngoc> minhNgocResult(String date, Integer id_mien) {
        return repository.findAllByNgayAndMien_IdOrderByGiaithuongIdAsc(date, id_mien);
    }

}
