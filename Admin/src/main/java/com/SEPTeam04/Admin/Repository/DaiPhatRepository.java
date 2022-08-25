package com.SEPTeam04.Admin.Repository;

import com.SEPTeam04.Admin.Entity.KetquaDaiphat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaiPhatRepository extends JpaRepository<KetquaDaiphat, Integer> {

}
