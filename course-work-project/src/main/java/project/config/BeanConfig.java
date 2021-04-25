package project.config;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import project.controller.LoginController;
import project.dao.UserDao;
import project.dao.impl.UserDaoImpl;
import project.service.RegistrationService;
import project.service.impl.RegistrationServiceImpl;
import project.support.mapper.UserMapper;
import project.support.mapper.UserMapperImpl;

@Configuration
@ComponentScan("project")
@EnableWebMvc
@EnableTransactionManagement
public class BeanConfig {

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("content-management");
    }

    @Bean
    public LoginController loginController() {
        return new LoginController(registrationService());
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

    @Bean
    public RegistrationService registrationService() {
        return new RegistrationServiceImpl(
            userDao(),
            userMapper()
        );
    }
}
