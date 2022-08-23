package com.SEPTeam04.Admin.Repository;

import com.SEPTeam04.Admin.Entity.KetquaMinhngoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MinhNgocRepository extends JpaRepository<KetquaMinhngoc, Integer> {

    List<KetquaMinhngoc> findAllByNgayAndMien_IdOrderByGiaithuongIdAsc(String date, Integer id_mien);
}
