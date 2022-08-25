package com.SEPTeam04.Admin.Repository;

import com.SEPTeam04.Admin.Entity.KetquaMinhngoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinhNgocRepository extends JpaRepository<KetquaMinhngoc, Integer> {
}
