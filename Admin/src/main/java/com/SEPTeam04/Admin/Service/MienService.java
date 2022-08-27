package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.Mien;
import com.SEPTeam04.Admin.Repository.MienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MienService {

    @Autowired
    private MienRepository mienRepository;

    public List<Mien> getAllmien() {

        return mienRepository.findAll();
    }

    public Mien get(Integer id) {

        Optional<Mien> result = mienRepository.findById(id);
        return result.get();
    }
}
