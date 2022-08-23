package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.KetquaDaiphat;
import com.SEPTeam04.Admin.Repository.DaiPhatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaiPhatService {

    @Autowired
    private DaiPhatRepository repository;

    public DaiPhatService() {
    }

    public DaiPhatService(DaiPhatRepository repository) {
        this.repository = repository;
    }

    public List<KetquaDaiphat> daiPhatResult(String date, Integer id_mien) {
        return repository.findAllByNgayAndMien_IdOrderByGiaithuongIdAsc(date, id_mien);
    }

}
