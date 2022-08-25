package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.Giaithuong;
import com.SEPTeam04.Admin.Entity.KetquaMinhngoc;
import com.SEPTeam04.Admin.Entity.Ketquadoso;
import com.SEPTeam04.Admin.Repository.FlameRepository;
import com.SEPTeam04.Admin.Repository.MinhNgocGetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlameService {
    private FlameRepository flameRepository;

    public FlameService(FlameRepository repository) {
        this.flameRepository = repository;
    }
    public List<Ketquadoso> flameminhNgocResult(String date, Integer id_mien, Integer id_tinhthanhpho) {
        return flameRepository.findAllByNgayAndIdMienAndIdTinhthanhphoOrderByIdGiaithuongAsc(date, id_mien, id_tinhthanhpho);
    }

    public  Ketquadoso getKetquaId(Integer id) {
        Optional<Ketquadoso> optional = flameRepository.findById(id);
        Ketquadoso ketquadoso = null;

        if (optional.isPresent()) {
           ketquadoso = optional.get();
        } else {
            throw new RuntimeException("Prize not found for id :: " + id);
        }
        return ketquadoso;
    }
}
