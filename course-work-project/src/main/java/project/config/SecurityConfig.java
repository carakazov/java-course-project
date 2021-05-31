package project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import project.dao.UserDao;
import project.dao.impl.UserDetailsServiceImpl;
import project.service.SecurityService;
import project.service.impl.SecurityServiceImpl;

@Configuration
@EnableWebSecurity
@ComponentScan("project")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDao userDao;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(userDao);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public SecurityService securityService() throws Exception {
        return new SecurityServiceImpl(
            authenticationManagerBean(),
            userDetailsService()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/admin/**").access("hasRole('admin')")
            .and()
            .exceptionHandling().accessDeniedPage("/error")
            .and()
            .formLogin().loginPage("/login").defaultSuccessUrl("/")
            .failureUrl("/login?error")
            .usernameParameter("login").passwordParameter("password")
            .and()
            .logout().logoutSuccessUrl("/login")
            .and()
            .logout()
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
            .and()
            .csrf().disable();
    }
}
