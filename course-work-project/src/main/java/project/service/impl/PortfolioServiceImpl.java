package project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.PortfolioDao;
import project.dao.UserDao;
import project.model.Portfolio;
import project.model.User;
import project.service.PortfolioService;


@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {
    private final PortfolioDao portfolioDao;
    private final UserDao userDao;

    @Override
    public Portfolio getByUser(User user) {
        return portfolioDao.findPortfolioOfUser(user);
    }

    @Override
    @Transactional
    public void add(String userLogin, byte[] file) {
        User user = userDao.getByLogin(userLogin);
        Portfolio existingPortfolio = portfolioDao.findPortfolioOfUser(user);
        if(existingPortfolio == null) {
            portfolioDao.add(
                new Portfolio().setPortfolio(file)
                    .setUser(userDao.getByLogin(userLogin))
            );
        } else {
            existingPortfolio.setPortfolio(file);
            portfolioDao.add(existingPortfolio);
        }
    }
}
