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
import project.controller.*;
import project.dao.*;
import project.dao.impl.*;
import project.dto.UserDto;
import project.service.*;
import project.service.impl.*;
import project.support.mapper.*;

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
            userService(),
            propertyService()
        );
    }

    @Bean
    public UserController userController() {
        return new UserController(
            userService(),
            accessBuyerProfileService()
        );
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl(
            accessBuyerProfileDao()
        );
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
            propertyService(),
            accessBuyerProfileService()
        );
    }

    @Bean
    public GenreDao genreDao() {
        return new GenreDaoImpl();
    }

    @Bean
    public IntellectualPropertyMapper addIntellectualPropertyMapper() {
        return new IntellectualPropertyMapperImpl();
    }

    @Bean
    public IntellectualPropertyDao intellectualPropertyDao() {
        return new IntellectualPropertyDaoImpl(
            userDao(),
            accessBuyerProfileDao()
        );
    }

    @Bean
    public PropertyService propertyService() {
        return new PropertyServiceImpl(
            intellectualPropertyDao(),
            genreDao(),
            userService(),
            addIntellectualPropertyMapper(),
            portfolioDao(),
            buyRequestDao()
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
        multipartResolver.setMaxUploadSize(100000000);
        return multipartResolver;
    }

    @Bean
    public ModeratorService moderatorService() {
        return new ModeratorServiceImpl(
            intellectualPropertyDao(),
            addIntellectualPropertyMapper()
        );
    }

    @Bean
    public ModeratorController moderatorController() {
        return new ModeratorController(
            moderatorService()
        );
    }

    @Bean
    public AccessBuyerProfileDao accessBuyerProfileDao() {
        return new AccessBuyerProfileDaoImpl();
    }

    @Bean
    public AccessBuyerProfileService accessBuyerProfileService() {
        return new AccessBuyerProfileServiceImpl(
            userService(),
            propertyService(),
            accessBuyerProfileDao()
        );
    }

    @Bean
    public BuyRequestMapper buyRequestMapper() {
        return new BuyRequestMapperImpl();
    }

    @Bean
    public BuyRequestDao buyRequestDao() {
        return new BuyRequestDaoImpl();
    }

    @Bean
    public BuyRequestService buyRequestService() {
        return new BuyRequestServiceImpl(
            buyRequestDao(),
            userService(),
            propertyService(),
            buyRequestMapper()
        );
    }

    @Bean
    public BuyRequestController buyRequestController() {
        return new BuyRequestController(
            buyRequestService(),
            propertyService()
        );
    }

    @Bean
    public ReviewDao reviewDao() {
        return new ReviewDaoImpl();
    }

    @Bean
    public ReviewMapper reviewMapper() {
        return new ReviewMapperImpl();
    }

    @Bean
    public ReviewDetailsMapper reviewDetailsMapper() {
        return new ReviewDetailsMapperImpl();
    }

    @Bean
    public ReviewService reviewService() {
        return new ReviewServiceImpl(
            reviewDao(),
            intellectualPropertyDao(),
            userService(),
            reviewMapper(),
            reviewDetailsMapper()
        );
    }

    @Bean
    public ReviewController reviewController() {
        return new ReviewController(
            reviewService()
        );
    }

    @Bean
    public ProfessionDao professionDao() {
        return new ProfessionDaoImpl();
    }

    @Bean
    public VacancyDao vacancyDao() {
        return new VacancyDaoImpl();
    }

    @Bean
    public ProfessionService professionService() {
        return new ProfessionServiceImpl(professionDao());
    }

    @Bean
    public VacancyService vacancyService() {
        return new VacancyServiceImpl(
            vacancyDao(),
            professionDao(),
            userDao(),
            vacancyMapper(),
            vacancyDetailsMapper()
        );
    }

    @Bean
    public VacancyDetailsMapper vacancyDetailsMapper() {
        return new VacancyDetailsMapperImpl();
    }

    @Bean
    public VacancyMapper vacancyMapper() {
        return new VacancyMapperImpl();
    }

    @Bean
    public VacancyController vacancyController() {
        return new VacancyController(
            vacancyService(),
            professionService()
        );
    }
}
