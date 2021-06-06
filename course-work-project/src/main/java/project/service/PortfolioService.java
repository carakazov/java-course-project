package project.service;

import java.io.IOException;

import project.model.Portfolio;
import project.model.User;

public interface PortfolioService {
    Portfolio getByUser(User user);

    void add(String userLogin, byte[] file) throws IOException;
}
