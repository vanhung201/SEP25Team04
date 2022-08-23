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

    // function get admin account by userName
    AdminAccount getAdminAccountByUsername(String userName);

    // function update admin account
    AdminAccount updateAdminAccount(AdminAccount adminAccount);

    // function save change password admin account
    AdminAccount saveChangePasswordAdminAccount(AdminAccount adminAccount);

    // function delete admin account
    void deleteAdminAccountById(Integer id);
}
