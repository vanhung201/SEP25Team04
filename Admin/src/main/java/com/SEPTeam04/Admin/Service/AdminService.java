package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Config.AdminNotFound;
import com.SEPTeam04.Admin.Entity.AdminAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repo;

    public List<AdminAccount> listAll(){
        return (List<AdminAccount>) repo.findAll();
    }

    public void save(AdminAccount account) {
        repo.save(account);
    }

    public AdminAccount get(Integer id) throws AdminNotFound {
        Optional<AdminAccount> result = repo.findById(id);
        if (result.isPresent() ){
            return  result.get();
        }

        throw new AdminNotFound("Could not find any admin with ID" + id);
    }

    public void delete (Integer id) throws AdminNotFound {
        Integer count = repo.countById(id);
        if ((count == null || count == 0)) {
            throw  new AdminNotFound("Could not find any admin with ID" + id);
        }

        repo.deleteById(id);
    }
}
