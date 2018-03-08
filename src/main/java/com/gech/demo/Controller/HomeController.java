package com.gech.demo.Controller;



import com.gech.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;

@Controller
public class HomeController {


@Autowired
AppUserRepository userRepository;

@Autowired
AppRoleRepository roleRepository;

//    @RequestMapping("/")
//    public String home(){
//
//        return "myLoginPage";
//    }

    @RequestMapping("/login")
    public String login(){

        return "myLoginPage";
    }
    @RequestMapping("/home")
    public String homePage(){

        return "index";
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

    @RequestMapping("/")
    public String showIndex(Model model){
        RestTemplate restTemplate=new RestTemplate();
        NewsApi newsApi=restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=5be29bcdc5d64b6d867ff362c0a3c597", NewsApi.class);
        model.addAttribute("Articles", newsApi.getArticles());
        return "index";
    }

    @RequestMapping("/{userpage}")
    public String showUserpage(Model model){
        RestTemplate restTemplate=new RestTemplate();
        NewsApi newsApi=restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=5be29bcdc5d64b6d867ff362c0a3c597", NewsApi.class);
        model.addAttribute("Articles", newsApi.getArticles());
        return "index";
    }




}
