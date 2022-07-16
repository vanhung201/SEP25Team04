package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.AdminAccount;

import java.util.List;

public interface AdminService {
    // function get all admin account
    List<AdminAccount> getAllAdminAccount();

    // function add new admin account
    void saveAdminAccount(AdminAccount adminAccount);

    // function get admin account by id
    AdminAccount getAdminAccountById(Integer id);

    // function delete admin account
    void deleteAdminAccountById(Integer id);
}
