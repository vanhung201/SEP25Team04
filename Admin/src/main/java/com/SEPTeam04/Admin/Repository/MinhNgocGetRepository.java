package com.SEPTeam04.Admin.Repository;

import com.SEPTeam04.Admin.Entity.KetquaMinhngoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MinhNgocGetRepository extends JpaRepository<KetquaMinhngoc, Integer> {
    List<KetquaMinhngoc> findAllByNgayAndIdMienAndIdTinhthanhphoOrderByIdGiaithuongAsc(String date, Integer id_mien, Integer id_tinhthanhpho);
}
