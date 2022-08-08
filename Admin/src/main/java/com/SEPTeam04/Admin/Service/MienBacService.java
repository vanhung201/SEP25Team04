package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.KetquaMinhngocT;
import com.SEPTeam04.Admin.Repository.MienBacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MienBacService {

    @Autowired
    private MienBacRepository repo;


    public List<KetquaMinhngocT> listAll(){
        return (List<KetquaMinhngocT>) repo.findAll();


    }
}
