package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.Giaithuong;

import java.util.List;

public interface GiaiThuongService {
    // function get all prize
    List<Giaithuong> getAllGiaiThuong();

    // function add new prize
    void saveGiaiThuong(Giaithuong giaithuong);

    // function get prize by id
    Giaithuong getGiaiThuongById(Integer id);

    // function delete prize
    void deleteGiaiThuongById(Integer id);
}
