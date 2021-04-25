package project.controller;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/registration")
@Data
public class RegistrationController {
    @PersistenceContext()
    private EntityManager em;

    @Autowired
    public RegistrationController(EntityManager em) {
        this.em = em;
    }

    @GetMapping
    public String test() {
        return "index";
    }
}
