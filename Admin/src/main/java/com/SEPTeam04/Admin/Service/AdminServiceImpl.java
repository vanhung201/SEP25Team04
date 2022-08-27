package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.AdminAccount;
import com.SEPTeam04.Admin.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public AdminServiceImpl() {

    }

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<AdminAccount> getAllAdminAccount() {
        return adminRepository.findAll();
    }

    @Override
    public void saveAdminAccount(AdminAccount adminAccount) {
        AdminAccount account = new AdminAccount();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        account.setUsername(adminAccount.getUsername());
        account.setPassword(passwordEncoder.encode(adminAccount.getPassword()));
        account.setHovaten(adminAccount.getHovaten());
        account.setRole("Admin");
        account.setTrangthaitaikhoan(true);

        adminRepository.save(account);
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
    public AdminAccount getAdminAccountByUsername(String userName) {
        Optional<AdminAccount> optional = adminRepository.findAdminAccountByUsername(userName);
        AdminAccount adminAccount = null;
        if (optional.isPresent()) {
            adminAccount = optional.get();
        } else {
            throw new RuntimeException("Admin Account not found for Username :: " + userName);
        }
        return adminAccount;
    }

    @Override
    public AdminAccount updateAdminAccount(AdminAccount adminAccount) {

        return adminRepository.save(adminAccount);
    }

    @Override
    public AdminAccount saveChangePasswordAdminAccount(AdminAccount adminAccount) {

        return adminRepository.save(adminAccount);
    }

    @Override
    public void deleteAdminAccountById(Integer id) {
        adminRepository.deleteById(id);
    }

    @Override
    public String getUsername(String username) {
        return adminRepository.getUsername(username);
    }

}
