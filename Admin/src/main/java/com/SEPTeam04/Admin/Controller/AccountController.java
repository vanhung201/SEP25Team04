package com.SEPTeam04.Admin.Controller;

import com.SEPTeam04.Admin.Entity.AdminAccount;
import com.SEPTeam04.Admin.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/account")
    public String viewListOfAdminAccount(Model model) {
        model.addAttribute("listAdmins", adminService.getAllAdminAccount());

        return "/account";
    }

    @GetMapping("/account/newAdminAccount")
    public String showAddNewAdminAccountForm(Model model) {
        // create model attribute to bind form data
        AdminAccount adminAccount = new AdminAccount();
        model.addAttribute("account", adminAccount);

        return "/new_account";
    }

    @PostMapping("/account/saveAdminAccount")
    public String saveAdminAccount(@ModelAttribute("account") AdminAccount adminAccount) {
        // save admin account to database
        adminService.saveAdminAccount(adminAccount);

        return "redirect:/account";
    }

    @GetMapping("/account/editAdminAccount/{id}")
    public String editAdminAccount(@PathVariable (value = "id") Integer id, Model model) {
        // get Admin Account from service
        AdminAccount adminAccount = adminService.getAdminAccountById(id);

        //set Admin Account as a model attribute to pre-populate the form
        model.addAttribute("account", adminAccount);

        return "/edit_account";
    }

    @GetMapping("/account/deleteAdminAccount/{id}")
    public String deleteAdminAccount(@PathVariable (value = "id") Integer id, Model model) {
        // call delete Admin Account method
        this.adminService.deleteAdminAccountById(id);

        return "redirect:/account";
    }
}
