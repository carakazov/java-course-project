package project.controller;


import java.security.Principal;
import javax.annotation.Resource;
import javax.validation.Valid;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.dto.RegistrationDto;
import project.dto.UserDto;
import project.service.RegistrationService;
import project.service.RoleService;
import project.service.UserService;


@RestController
@Data
@RequiredArgsConstructor
public class LoginController {
    private final RegistrationService registrationService;
    private final RoleService roleService;
    private final UserService userService;

    @Resource(name = "currentUserDto")
    private UserDto userDto;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(required = false) String error) {
        ModelAndView modelAndView = new ModelAndView("login");
        if(error != null) {
            modelAndView.addObject("error", "Wrong login or password");
        }
        return modelAndView;
    }

    @GetMapping
    public ModelAndView index(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("index");
        if(principal != null && !userDto.isEstablished()) {
            userDto = userService.getUserDto(principal.getName());
            modelAndView.addObject("session", userDto);
            userDto.setEstablished(true);
        }
        return modelAndView;
    }

    @GetMapping("/error")
    public ModelAndView error() {
        return new ModelAndView("403");
    }

    @GetMapping(value = "/admin/page")
    public ModelAndView adminPage() {
        return new ModelAndView("adminPage");
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
        ModelAndView modelAndView = new ModelAndView("login");
        registrationService.addNewUser(registrationDto);
        return modelAndView;
    }

    @GetMapping("/users/{id}")
    public ModelAndView showUser(@PathVariable(value = "id") int id) {
        return null;
    }
}
