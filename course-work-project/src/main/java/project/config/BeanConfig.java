package project.config;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import project.controller.LoginController;
import project.dao.RoleDao;
import project.dao.UserDao;
import project.dao.impl.RoleDaoImpl;
import project.dao.impl.UserDaoImpl;
import project.dto.UserDto;
import project.service.RegistrationService;
import project.service.RoleService;
import project.service.UserService;
import project.service.impl.RegistrationServiceImpl;
import project.service.impl.RoleServiceImpl;
import project.service.impl.UserServiceImpl;
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
            userMapper()
        );
    }

    @Bean(name = "currentUserDto")
    @SessionScope
    public UserDto userDto() {
        return new UserDto();
    }
}
