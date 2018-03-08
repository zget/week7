package com.gech.demo.Security;



import com.gech.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    AppRoleRepository roleRepository;

    @Autowired
    NewsProfileRepository newsProfileRepository;

    @Override
    public void run(String... strings) throws Exception{
        System.out.println("Loading data....");

        roleRepository.save(new AppRole("USER")) ;
        roleRepository.save(new AppRole("ADMIN")) ;

        UserProfile cnn= new UserProfile("cnn");
        newsProfileRepository.save(cnn);
        UserProfile bbc= new UserProfile("bbc");
        newsProfileRepository.save(bbc);
        AppUser user= new AppUser("admin", "password", roleRepository.findAppRoleByRoleName("ADMIN"));
        user.addNews(cnn);
        userRepository.save(user);


        user=  new AppUser("user", "password", roleRepository.findAppRoleByRoleName("USER"));
        user.addNews(bbc);
        userRepository.save(user);

    }
}
