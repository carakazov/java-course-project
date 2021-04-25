package project.support.validation.validators;
/*
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import project.dao.UserDao;
import project.support.validation.annotations.UniqueLogin;

public class UniqueLoginValidator implements
    ConstraintValidator<UniqueLogin, String> {
    private final UserDao userDao;
    @Autowired
    public UniqueLoginValidator(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void initialize(UniqueLogin uniqueLogin) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !userDao.getAllLogins().contains(s);
    }
}
*/