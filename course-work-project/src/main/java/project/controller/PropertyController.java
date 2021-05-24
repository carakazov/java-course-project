package project.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import project.dto.AddIntellectualPropertyDto;
import project.dto.UserDto;
import project.model.GenreTypeEnum;
import project.service.PropertyService;

@RestController
@RequiredArgsConstructor
@Data
@RequestMapping("/property")
public class PropertyController {
    private final PropertyService propertyService;
    @Resource(name = "currentUserDto")
    private UserDto currentUserDto;

    @GetMapping
    public ModelAndView addForm(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("property");
        AddIntellectualPropertyDto property = new AddIntellectualPropertyDto();
        GenreTypeEnum[] genres = GenreTypeEnum.values();
        modelAndView.addObject("property", property);
        modelAndView.addObject("genres", genres);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addProperty(
        @RequestBody @ModelAttribute("property") @Valid AddIntellectualPropertyDto property,
        @RequestParam("file") MultipartFile file,
        HttpServletRequest request,
        BindingResult bindingResult
    ) throws IOException {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("property");
        }
        property.setAuthor((UserDto) request.getSession().getAttribute("session"));
        property.getIntellectualPropertyDto().setContent(file.getBytes());
        propertyService.addProperty(property);
        return new ModelAndView("redirect:/index");
    }

    @PostMapping("/fucking_test")
    public ModelAndView test(@RequestParam("file") MultipartFile file) {
        int b = 2 + 2;
        return new ModelAndView("redirect:");
    }
}