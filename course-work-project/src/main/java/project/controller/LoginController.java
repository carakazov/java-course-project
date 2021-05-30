package project.controller;


import java.security.Principal;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.dto.RegistrationDto;
import project.dto.ShowIntellectualPropertyDto;
import project.dto.UserDto;
import project.service.PropertyService;
import project.service.RegistrationService;
import project.service.RoleService;
import project.service.UserService;


@RestController
@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class LoginController {
    private final RegistrationService registrationService;
    private final RoleService roleService;
    private final UserService userService;
    private final PropertyService propertyService;
    @Resource(name = "currentUserDto")
    private UserDto currentUserDto;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam(required = false) String error) {
        ModelAndView modelAndView = new ModelAndView("login");
        if(error != null) {
            modelAndView.addObject("error", "Wrong login or password");
        }
        return modelAndView;
    }

    @GetMapping
    public ModelAndView index(Principal principal, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<ShowIntellectualPropertyDto> property = propertyService.getAllForIndex();
        modelAndView.addObject("list", property);
        if(principal != null && !currentUserDto.isEstablished()) {
            currentUserDto = userService.getUserDto(principal.getName());
            currentUserDto.setEstablished(true);
            request.getSession().setAttribute("session", currentUserDto);
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

}
