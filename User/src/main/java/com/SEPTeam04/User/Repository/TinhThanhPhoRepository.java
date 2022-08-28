package com.SEPTeam04.User.Repository;

import com.SEPTeam04.User.Entity.TinhThanhpho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinhThanhPhoRepository extends JpaRepository<TinhThanhpho, Integer> {
}
