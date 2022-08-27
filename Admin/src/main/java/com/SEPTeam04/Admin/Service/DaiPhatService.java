package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.KetquaDaiphat;
import com.SEPTeam04.Admin.Repository.DaiPhatGetRepository;
import com.SEPTeam04.Admin.Repository.DaiPhatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DaiPhatService {

    @Autowired
    private DaiPhatGetRepository repository;

    public DaiPhatService() {

    }

    public DaiPhatService(DaiPhatGetRepository repository) {
        this.repository = repository;
    }

    public List<KetquaDaiphat> daiPhatResult(String date, Integer id_mien, Integer id_tinhthanhpho) {

        return repository.findAllByNgayAndIdMienAndIdTinhthanhphoOrderByIdGiaithuongAsc(date, id_mien, id_tinhthanhpho);
    }
}
