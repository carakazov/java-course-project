package project.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import project.dto.*;
import project.model.GenreTypeEnum;
import project.service.AccessBuyerProfileService;
import project.service.PropertyService;

@RestController
@RequiredArgsConstructor
@Data
@RequestMapping("/property")
public class PropertyController {
    private final PropertyService propertyService;
    private final AccessBuyerProfileService accessBuyerProfileService;
    @Resource(name = "currentUserDto")
    private UserDto currentUserDto;

    @GetMapping
    public ModelAndView addForm() {
        ModelAndView modelAndView = new ModelAndView("property");
        AddIntellectualPropertyDto property = new AddIntellectualPropertyDto();
        GenreTypeEnum[] genres = GenreTypeEnum.values();
        modelAndView.addObject("property", property);
        modelAndView.addObject("genres", genres);
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addProperty(
        @RequestBody @ModelAttribute("property") AddIntellectualPropertyDto property,
        @RequestParam("file") MultipartFile file,
        HttpServletRequest request,
        BindingResult result
    ) throws IOException {
        if(result.hasErrors()) {
            return new ModelAndView("property");
        }
        property.setAuthor((UserDto) request.getSession().getAttribute("session"));
        property.getIntellectualPropertyDto().setContent(file.getBytes());
        propertyService.addProperty(property);
        return new ModelAndView("index");
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable("id") int id, HttpServletRequest request) {
        String login = ((UserDto) request.getSession().getAttribute("session")).getLogin();
        ShowIntellectualPropertyDetailsDto property = propertyService.getForDetails(
            id,
            login
        );
        BuyRequestDto buyRequestDto = new BuyRequestDto();
        buyRequestDto.setSender(login);
        buyRequestDto.setPropertyId(id);
        buyRequestDto.setSendingDate(LocalDateTime.now());
        ModelAndView modelAndView = new ModelAndView("details");
        modelAndView.addObject("session", ((UserDto) request.getSession().getAttribute("session")));
        modelAndView.addObject("item", property);
        modelAndView.addObject("requestDto", buyRequestDto);
        return modelAndView;
    }

    @PostMapping("/buy")
    public ModelAndView buy(@RequestBody @ModelAttribute("buyPropertyDto") BuyPropertyDto buyProperty) {
        accessBuyerProfileService.addProfile(buyProperty);
        return new ModelAndView("redirect:details/" + buyProperty.getPropertyId());
    }

    @GetMapping("/buy")
    public ModelAndView getBuyForm(
        @RequestParam double price, @RequestParam String login,
        @RequestParam int propertyId
    ) {
        ModelAndView modelAndView = new ModelAndView("buyPage");
        BuyFormDto formData = new BuyFormDto();
        BuyPropertyDto buyPropertyDto = new BuyPropertyDto();
        buyPropertyDto.setLogin(login)
            .setPropertyId(propertyId);
        formData.setLogin(login)
            .setPrice(price)
            .setPropertyId(propertyId);
        modelAndView.addObject("formData", formData);
        modelAndView.addObject("buyPropertyDto", buyPropertyDto);
        return modelAndView;
    }

    @GetMapping("/subscribe")
    public ModelAndView getSubscribeForm(
        @RequestParam String subscriberLogin,
        @RequestParam int propertyId
    ) {
        ModelAndView modelAndView = new ModelAndView("subscribePage");
        SubscribeDto subscribeDto = new SubscribeDto();
        subscribeDto.setSubscriberLogin(subscriberLogin)
            .setBloggerLogin(propertyService.getOwnerLoginByPropertyId(propertyId))
            .setPropertyId(propertyId);
        modelAndView.addObject("subscribeDto", subscribeDto);
        return modelAndView;
    }
}
