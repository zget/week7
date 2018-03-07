package com.gech.demo.Controller;



import com.gech.demo.Model.AppRoleRepository;
import com.gech.demo.Model.AppUser;
import com.gech.demo.Model.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {


@Autowired
AppUserRepository userRepository;

@Autowired
AppRoleRepository roleRepository;

    @RequestMapping("/")
    public String home(){

        return "myLoginPage";
    }

    @RequestMapping("/login")
    public String login(){

        return "myLoginPage";
    }
    @RequestMapping("/home")
    public String homePage(){

        return "HOME";
    }
    @RequestMapping("/access-denied")
    public String accessDenied(){

        return "accessDenied";
    }

    @GetMapping("/register")
    public String newUser(Model model){
        model.addAttribute("user", new AppUser());
        return "Registration";
    }



    @PostMapping("/register")
    public String processUser(@Valid @ModelAttribute("user") AppUser user,  BindingResult result, Model model){
        if(result.hasErrors()){
            return "Registration";
        }

        user.addRole(roleRepository.findAppRoleByRoleName("USER"));
        userRepository.save(user);
        model.addAttribute("message", "User account Successfully Created");
        return "redirect:/login";
    }




}
