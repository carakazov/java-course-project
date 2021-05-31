package project.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.dto.SubscribeDto;
import project.dto.UserDto;
import project.service.AccessBuyerProfileService;
import project.service.UserService;

@RestController
@RequiredArgsConstructor
@Accessors(chain = true)
@Data
public class UserController {
    private final UserService userService;
    private final AccessBuyerProfileService accessBuyerProfileService;

    @Resource(name = "currentUserDto")
    private UserDto currentUserDto;

    @PostMapping("/description")
    public ModelAndView addDescription(@RequestBody @ModelAttribute(name = "user") UserDto userDto) {
        ModelAndView modelAndView = new ModelAndView("redirect:/users/" + userDto.getLogin());
        userService.addUserDescription(userDto.getLogin(), userDto.getDescription());
        return modelAndView;
    }

    @GetMapping("/users/{login}")
    public ModelAndView showUser(@PathVariable(value = "login") String login) {
        ModelAndView modelAndView = new ModelAndView("user");
        UserDto user = userService.getUserDto(login);
        modelAndView.addObject("user", user);
        modelAndView.addObject("session", currentUserDto.getLogin());
        modelAndView.addObject("description", "");
        return modelAndView;
    }

    @PostMapping("/subscribe")
    public ModelAndView subscribe(@RequestBody @ModelAttribute(name = "subscribeDto") SubscribeDto subscribeDto) {
        userService.subscribe(subscribeDto.getBloggerLogin(), subscribeDto.getSubscriberLogin());
        accessBuyerProfileService
            .addAccessToAllCompositionsOfBlogger(subscribeDto.getBloggerLogin(), subscribeDto.getSubscriberLogin());
        return new ModelAndView("redirect:property/details/" + subscribeDto.getPropertyId());
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        request.getSession().setAttribute("session", null);
        return new ModelAndView("redirect:/index");
    }
}
