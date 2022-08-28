package com.SEPTeam04.User.Repository;

import com.SEPTeam04.User.Entity.Mien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MienRepository extends JpaRepository<Mien, Integer> {
}
