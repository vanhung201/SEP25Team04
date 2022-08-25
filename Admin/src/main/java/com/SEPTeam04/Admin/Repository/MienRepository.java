package com.SEPTeam04.Admin.Repository;

import com.SEPTeam04.Admin.Entity.Mien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MienRepository extends JpaRepository<Mien, Integer> {
}
