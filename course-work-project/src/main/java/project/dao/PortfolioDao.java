package project.dao;

import project.model.Portfolio;
import project.model.User;

public interface PortfolioDao {
    Portfolio findPortfolioOfUser(User user);
}
