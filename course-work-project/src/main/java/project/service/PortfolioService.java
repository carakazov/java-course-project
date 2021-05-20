package project.service;

import project.model.Portfolio;
import project.model.User;

public interface PortfolioService {
    Portfolio getByUser(User user);
}
