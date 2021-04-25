package project.controller;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import project.dto.RegistrationDto;
import project.service.RegistrationService;


@Controller
@Data
public class LoginController {
    @PersistenceContext
    private EntityManager em;
    private RegistrationService registrationService;

    @Autowired
    public LoginController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String test() {
        return "index";
    }

    @GetMapping("/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView("registration");
        RegistrationDto registrationDto = new RegistrationDto();
        modelAndView.addObject("registrationDto", registrationDto);
        return modelAndView;
    }

    @PostMapping("/createUser")
    public ModelAndView newUser(@RequestBody /*@Valid*/ RegistrationDto registrationDto) {
        ModelAndView modelAndView = new ModelAndView("redirect:/index");
        registrationService.addNewUser(registrationDto);
        return modelAndView;
    }

    @GetMapping("/users/{id}")
    public ModelAndView showUser(@PathVariable(value = "id") int id) {
        return null;
    }
}
