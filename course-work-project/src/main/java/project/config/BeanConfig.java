package project.config;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import project.controller.LoginController;
import project.controller.PropertyController;
import project.controller.UserController;
import project.dao.*;
import project.dao.impl.*;
import project.dto.UserDto;
import project.service.*;
import project.service.impl.*;
import project.support.mapper.AddIntellectualPropertyMapper;
import project.support.mapper.AddIntellectualPropertyMapperImpl;
import project.support.mapper.UserMapper;
import project.support.mapper.UserMapperImpl;

@Configuration
@ComponentScan("project")
@EnableWebMvc
@EnableTransactionManagement
public class BeanConfig {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory());
        transactionManager.setDataSource(dataSource());
        transactionManager.setJpaDialect(new HibernateJpaDialect());
        return transactionManager;
    }

    @Bean
    public DataSource dataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUser("postgres");
        dataSource.setPassword("yfgjktjy1813");
        dataSource.setDatabaseName("content-management-system");
        return dataSource;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("content-management");
    }

    @Bean
    public LoginController loginController() {
        return new LoginController(
            registrationService(),
            roleService(),
            userService()
        );
    }

    @Bean
    public UserController userController() {
        return new UserController(
            userService()
        );
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
    public RoleDao roleDao() {
        return new RoleDaoImpl();
    }

    @Bean
    public RegistrationService registrationService() {
        return new RegistrationServiceImpl(
            userDao(),
            userMapper(),
            roleDao(),
            passwordEncoder
        );
    }

    @Bean
    public RoleService roleService() {
        return new RoleServiceImpl(
            roleDao()
        );
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(
            userDao(),
            userMapper(),
            portfolioService()
        );
    }

    @Bean
    public PortfolioDao portfolioDao() {
        return new PortfolioDaoImpl();
    }

    @Bean
    public PortfolioService portfolioService() {
        return new PortfolioServiceImpl(
            portfolioDao()
        );
    }

    @Bean(name = "currentUserDto")
    @SessionScope
    public UserDto userDto() {
        return new UserDto();
    }

    @Bean
    public PropertyController propertyController() {
        return new PropertyController(
            propertyService()
        );
    }

    @Bean
    public GenreDao genreDao() {
        return new GenreDaoImpl();
    }

    @Bean
    public AddIntellectualPropertyMapper addIntellectualPropertyMapper() {
        return new AddIntellectualPropertyMapperImpl();
    }

    @Bean
    public IntellectualPropertyDao intellectualPropertyDao() {
        return new IntellectualPropertyDaoImpl();
    }

    @Bean
    public PropertyService propertyService() {
        return new PropertyServiceImpl(
            intellectualPropertyDao(),
            genreDao(),
            userService(),
            addIntellectualPropertyMapper()
        );
    }


    @Bean
    public MultipartConfigElement multipartConfigElement() {
        return new MultipartConfigElement("");
    }

    @Bean
    public MultipartResolver multipartResolver() {
        org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver =
            new org.springframework.web.multipart.commons.CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(100000);
        return multipartResolver;
    }
}
