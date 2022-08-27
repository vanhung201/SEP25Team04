package com.SEPTeam04.Admin.Repository;

import com.SEPTeam04.Admin.Entity.Giaithuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiaiThuongRepository extends JpaRepository<Giaithuong, Integer> {

}
