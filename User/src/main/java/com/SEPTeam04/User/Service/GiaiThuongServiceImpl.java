package com.SEPTeam04.User.Service;

import com.SEPTeam04.User.Entity.Giaithuong;
import com.SEPTeam04.User.Repository.GiaiThuongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiaiThuongServiceImpl implements GiaiThuongService {

    @Autowired
    private GiaiThuongRepository giaiThuongRepository;

    public GiaiThuongServiceImpl() {

    }

    public GiaiThuongServiceImpl(GiaiThuongRepository giaiThuongRepository) {
        this.giaiThuongRepository = giaiThuongRepository;
    }

    @Override
    public List<Giaithuong> getAllGiaiThuong() {

        return giaiThuongRepository.findAll();
    }

    @Override
    public void saveGiaiThuong(Giaithuong giaithuong) {

        giaiThuongRepository.save(giaithuong);
    }

    @Override
    public Giaithuong getGiaiThuongById(Integer id) {

        Optional<Giaithuong> optional = giaiThuongRepository.findById(id);
        Giaithuong giaithuong = null;

        if (optional.isPresent()) {
            giaithuong = optional.get();
        } else {
            throw new RuntimeException("Prize not found for id :: " + id);
        }
        return giaithuong;
    }

    @Override
    public Giaithuong updateGiaiThuong(Giaithuong giaithuong) {

        return giaiThuongRepository.save(giaithuong);
    }

    @Override
    public void deleteGiaiThuongById(Integer id) {

        giaiThuongRepository.deleteById(id);
    }
}
