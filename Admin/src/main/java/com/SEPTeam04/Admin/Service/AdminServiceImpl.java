package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.AdminAccount;
import com.SEPTeam04.Admin.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public List<AdminAccount> getAllAdminAccount() {
        return adminRepository.findAll();
    }

    @Override
    public void saveAdminAccount(AdminAccount adminAccount) {
        String encodedPassword = this.passwordEncoder.encode(adminAccount.getPassword());
        adminAccount.setPassword(encodedPassword);
        this.adminRepository.save(adminAccount);
    }

    @Override
    public AdminAccount getAdminAccountById(Integer id) {
        Optional<AdminAccount> optional = adminRepository.findById(id);
        AdminAccount adminAccount = null;
        if (optional.isPresent()) {
            adminAccount = optional.get();
        } else {
            throw new RuntimeException("Admin Account not found for id :: " + id);
        }
        return adminAccount;
    }

    @Override
    public void deleteAdminAccountById(Integer id) {
        this.adminRepository.deleteById(id);
    }

}
