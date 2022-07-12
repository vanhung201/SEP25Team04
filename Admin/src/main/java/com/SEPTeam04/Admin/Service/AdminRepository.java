package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.AdminAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminAccount, Integer> {

    Integer countById(Integer id);
}
