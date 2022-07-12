package com.SEPTeam04.Admin.Controller;

import com.SEPTeam04.Admin.Config.AdminNotFound;
import com.SEPTeam04.Admin.Entity.AdminAccount;
import com.SEPTeam04.Admin.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Controller
public class AccountController {
    @Autowired
    private AdminService service;

    @GetMapping("/account")
    public String showAcount(Model model) {
        List<AdminAccount> listAdmins = service.listAll();
        model.addAttribute("listAdmins", listAdmins);

        return "account";
    }

    @GetMapping("/account/new")
    public String showNewForm(Model model) {
        model.addAttribute("account", new AdminAccount());
        model.addAttribute("pageTitle", "Add New User");

        return "account_form";
    }


    @PostMapping("/account/save")
    public String SaveAccount(AdminAccount account, RedirectAttributes ra) {
        service.save(account);
        ra.addAttribute("message", "The admin has been saved successfully");

        return "redirect:/account";
    }

    @GetMapping("/account/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            AdminAccount account = service.get(id);
            model.addAttribute("account", account);
            model.addAttribute("pageTitle", "Edit User(ID: " + id + ")");

            return "account_form";
        } catch (AdminNotFound e) {
            ra.addAttribute("message", "The admin has been saved successfully");

            return "redirect:/account";
        }
    }

    @GetMapping("/account/delete/{id}")
    public String deleteAdmin(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addAttribute("message", "The admin ID" + id + "has been deleted");
        } catch (AdminNotFound e) {
            ra.addAttribute("message", "Delete Complete");
        }

        return "redirect:/account";
    }
}
