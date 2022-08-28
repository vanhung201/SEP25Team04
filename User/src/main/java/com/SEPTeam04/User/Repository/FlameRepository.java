package com.SEPTeam04.User.Repository;

import com.SEPTeam04.User.Entity.Ketquadoso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlameRepository extends JpaRepository<Ketquadoso, Integer> {
    List<Ketquadoso> findAllByNgayAndIdMienAndIdTinhthanhphoOrderByIdGiaithuongAsc(String date, Integer id_mien, Integer id_tinhthanhpho);
}
