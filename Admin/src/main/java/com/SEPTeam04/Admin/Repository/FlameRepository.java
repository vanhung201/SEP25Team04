package com.SEPTeam04.Admin.Repository;

import com.SEPTeam04.Admin.Entity.KetquaMinhngoc;
import com.SEPTeam04.Admin.Entity.Ketquadoso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlameRepository extends JpaRepository<Ketquadoso, Integer> {
    List<Ketquadoso> findAllByNgayAndIdMienAndIdTinhthanhphoOrderByIdGiaithuongAsc(String date, Integer id_mien, Integer id_tinhthanhpho);
}
