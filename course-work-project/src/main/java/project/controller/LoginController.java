package project.controller;


import javax.validation.Valid;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.dto.RegistrationDto;
import project.service.RegistrationService;
import project.service.RoleService;


@RestController
@Data
@RequiredArgsConstructor
public class LoginController {
    private final RegistrationService registrationService;
    private final RoleService roleService;

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index");
    }


    @GetMapping("/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView("registration");
        RegistrationDto registrationDto = new RegistrationDto();
        modelAndView.addObject("registrationDto", registrationDto);
        return modelAndView;
    }

    @PostMapping(value = "/createUser")
    public ModelAndView newUser(
        @RequestBody @ModelAttribute("registrationDto") @Valid RegistrationDto registrationDto,
        BindingResult result
    ) {
        if(result.hasErrors()) {
            return new ModelAndView("registration");
        }
        ModelAndView modelAndView = new ModelAndView("index");
        registrationService.addNewUser(registrationDto);
        return modelAndView;
    }

    @GetMapping("/users/{id}")
    public ModelAndView showUser(@PathVariable(value = "id") int id) {
        return null;
    }
}
