package com.SEPTeam04.Admin.Controller;

import com.SEPTeam04.Admin.Entity.AdminAccount;
import com.SEPTeam04.Admin.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class AccountController {

    @Autowired
    private AdminService adminService;

    public AccountController() {

    }

    public AccountController(AdminService adminService) {
        this.adminService = adminService;
    }

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
    public String saveAdminAccount(@RequestParam("username") String username,
                                   @ModelAttribute("account") AdminAccount adminAccount,
                                   RedirectAttributes attributes) {

        if (username.equals(adminService.getUsername(username))) {
            attributes.addFlashAttribute("messageError", "This username already exist!!!");
        } else {
            // save admin account to database
            adminService.saveAdminAccount(adminAccount);
            attributes.addFlashAttribute("message", "Add new account successfully.");
        }

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

    @PostMapping("/saveEditAccount/{id}")
    public String saveEditAdminAccount(@PathVariable (value = "id") Integer id,
                                       @ModelAttribute("account") AdminAccount adminAccount, RedirectAttributes attributes) {
        // get Admin Account from service
        AdminAccount existingAdminAccount = adminService.getAdminAccountById(id);

        existingAdminAccount.setId(id);
        existingAdminAccount.setHovaten(adminAccount.getHovaten());

        adminService.updateAdminAccount(existingAdminAccount);
        attributes.addFlashAttribute("message", "Update account successfully.");

        return "redirect:/account";
    }

    @GetMapping("/deleteAccount/{id}")
    public String deleteAdminAccount(@PathVariable (value = "id") Integer id, RedirectAttributes attributes) {
        // call delete Admin Account method
        this.adminService.deleteAdminAccountById(id);
        attributes.addFlashAttribute("message", "Delete account successfully.");

        return "redirect:/account";
    }

    @GetMapping("/change-password")
    public String showChangePassword() {

        return "/change-password";
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam("currentPassword") String currentPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 @RequestParam("reNewPassword") String reNewPassword,
                                 Principal principal,
                                 RedirectAttributes attributes) {

        String userName = principal.getName();
        AdminAccount curentUser = adminService.getAdminAccountByUsername(userName);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (passwordEncoder.matches(currentPassword, curentUser.getPassword())) {
            if (passwordEncoder.matches(newPassword, curentUser.getPassword())) {
                attributes.addFlashAttribute("messageError", "New password same with current password.");
            } else {
                if (reNewPassword.equals(newPassword)) {

                    curentUser.setUsername(userName);
                    curentUser.setPassword(passwordEncoder.encode(newPassword));

                    adminService.saveChangePasswordAdminAccount(curentUser);

                    attributes.addFlashAttribute("messageSuccess", "Change password successfully.");
                } else {
                    attributes.addFlashAttribute("messageError", "The password confirmation does not match.");
                }
            }
        } else {
            attributes.addFlashAttribute("messageError", "Current password is incorrect.");
        }

        return "redirect:/change-password";
    }
}
