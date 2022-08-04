package com.SEPTeam04.Admin.Controller;

import com.SEPTeam04.Admin.Entity.AdminAccount;
import com.SEPTeam04.Admin.Repository.AdminRepository;
import com.SEPTeam04.Admin.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AccountController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/account")
    public String viewListOfAdminAccount(Model model) {
        model.addAttribute("listAdmins", adminService.getAllAdminAccount());

        return "/account";
    }

    @GetMapping("/addAccount")
    public String showAddNewAdminAccountForm(Model model) {
        // create model attribute to bind form data
        AdminAccount adminAccount = new AdminAccount();
        model.addAttribute("account", adminAccount);

        return "/add-account";
    }

    @PostMapping("/saveAccount")
    public String saveAdminAccount(@ModelAttribute("account") AdminAccount adminAccount, RedirectAttributes attributes) {
        // save admin account to database
        adminService.saveAdminAccount(adminAccount);
        attributes.addFlashAttribute("message", "Add new account successfully.");

        return "redirect:/account";
    }

    @GetMapping("/editAccount/{id}")
    public String editAdminAccount(@PathVariable (value = "id") Integer id, Model model) {
        // get Admin Account from service
        AdminAccount adminAccount = adminService.getAdminAccountById(id);

        //set Admin Account as a model attribute to pre-populate the form
        model.addAttribute("account", adminAccount);

        return "/edit-account";
    }

    @GetMapping("/deleteAccount/{id}")
    public String deleteAdminAccount(@PathVariable (value = "id") Integer id, RedirectAttributes attributes) {
        // call delete Admin Account method
        this.adminService.deleteAdminAccountById(id);
        attributes.addFlashAttribute("message", "Delete account successfully.");

        return "redirect:/account";
    }

    @GetMapping("/change-password")
    public String showChangePassword(Model model) {

        return "/change-password";
    }
}
