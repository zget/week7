package com.gech.demo.Security;



import com.gech.demo.Model.AppRole;
import com.gech.demo.Model.AppRoleRepository;
import com.gech.demo.Model.AppUser;
import com.gech.demo.Model.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    AppRoleRepository roleRepository;



    @Override
    public void run(String... strings) throws Exception{
        System.out.println("Loading data....");

        roleRepository.save(new AppRole("USER")) ;
        roleRepository.save(new AppRole("ADMIN")) ;



        AppUser user= new AppUser("admin", "password", roleRepository.findAppRoleByRoleName("ADMIN"));
        userRepository.save(user);


        user=  new AppUser("user", "password", roleRepository.findAppRoleByRoleName("USER"));
        userRepository.save(user);

    }
}
