package com.gech.demo.Security;

import com.gech.demo.Model.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired

    AppUserRepository userRepository;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new SSUDS(userRepository);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder pE = passwordEncoder();

//        auth.inMemoryAuthentication().withUser("username").password(pE.encode("password")).authorities("USER")
//                .and().withUser("admin").password(pE.encode("password")).authorities("ADMIN");

        auth.userDetailsService(userDetailsServiceBean());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/home","/css/**","/js/**","/img/**","/fonts/**",
                        "/register","/login","/technology","/business","/health","/entertainment",
                        "/sport","@{/selectcategory}","/static/**","/templates/**"
                        ,"/css/regcss.css").permitAll()
                .antMatchers("/showtopics","@{/getchoiceform}" ).access("hasAnyAuthority('USER', 'ADMIN')")
                .anyRequest().authenticated()

        .and()
        .formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/showtopics")
        .and()
        .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");

        http.headers().frameOptions().disable();
        http.csrf().disable();
    }
}
