package com.SEPTeam04.Admin.Service;

import com.SEPTeam04.Admin.Entity.AdminAccount;

import java.util.List;

public interface AdminService {
    // function get all admin account
    public List<AdminAccount> getAllAdminAccount();

    // function add new admin account
    public void saveAdminAccount(AdminAccount adminAccount);

    // function get admin account by id
    public AdminAccount getAdminAccountById(Integer id);

    // function delete admin account
    public void deleteAdminAccountById(Integer id);
}
