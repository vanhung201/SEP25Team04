package com.SEPTeam04.Admin.Repository;

import com.SEPTeam04.Admin.Entity.KetquaMinhngocT;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MienBacRepository extends CrudRepository<KetquaMinhngocT, Integer> {

}
