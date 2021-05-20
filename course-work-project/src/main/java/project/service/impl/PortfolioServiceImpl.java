package project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.dao.PortfolioDao;
import project.model.Portfolio;
import project.model.User;
import project.service.PortfolioService;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {
    private final PortfolioDao portfolioDao;

    @Override
    public Portfolio getByUser(User user) {
        return portfolioDao.findPortfolioOfUser(user);
    }
}
