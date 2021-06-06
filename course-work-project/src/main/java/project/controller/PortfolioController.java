package project.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import project.dto.UserDto;
import project.service.PortfolioService;

@RestController
@RequiredArgsConstructor
public class PortfolioController {
    private final PortfolioService portfolioService;

    @PostMapping("/portfolio/add")
    public ModelAndView modelAndView(
        @RequestParam("portfolio") MultipartFile portfolio,
        HttpServletRequest request
    ) throws IOException {
        String login = ((UserDto) request.getSession().getAttribute("session")).getLogin();
        portfolioService.add(login, portfolio.getBytes());
        return new ModelAndView("redirect:/users/" + login);
    }
}
