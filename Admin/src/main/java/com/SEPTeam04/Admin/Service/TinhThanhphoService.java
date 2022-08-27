package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.TinhThanhpho;
import com.SEPTeam04.Admin.Repository.TinhThanhPhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TinhThanhphoService {

    @Autowired
    TinhThanhPhoRepository tinhThanhPhoRepository;

    public List<TinhThanhpho> getAllTinhThanhpho() {

        return tinhThanhPhoRepository.findAll();
    }

    public TinhThanhpho get(Integer id) {

        Optional<TinhThanhpho> result = tinhThanhPhoRepository.findById(id);
        return result.get();
    }
}
