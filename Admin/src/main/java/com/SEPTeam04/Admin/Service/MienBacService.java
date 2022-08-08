package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.KetquaMinhngocT;
import com.SEPTeam04.Admin.Repository.MienBacRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MienBacService {
    @Autowired
    private MienBacRepository repo;


    public List<KetquaMinhngocT> listAll(){
        return (List<KetquaMinhngocT>) repo.findAll();


    }
}
