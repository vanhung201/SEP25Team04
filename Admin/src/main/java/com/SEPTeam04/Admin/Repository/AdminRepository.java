package com.SEPTeam04.Admin.Repository;

import com.SEPTeam04.Admin.Entity.AdminAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AdminAccount, Integer> {

    @Query("SELECT u FROM AdminAccount u WHERE u.username = :username")
    AdminAccount getAdminAccountByUsername(@Param("username") String username);

    Optional<AdminAccount> findAdminAccountByUsername(String userName);
}
