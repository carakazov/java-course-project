package project.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView addForm() {
        ModelAndView modelAndView = new ModelAndView("property");
        AddIntellectualPropertyDto property = new AddIntellectualPropertyDto();
        GenreTypeEnum[] genres = GenreTypeEnum.values();
        property.setAuthor(currentUserDto);
        modelAndView.addObject("property", property);
        modelAndView.addObject("genres", genres);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addProperty(@RequestBody @Valid AddIntellectualPropertyDto property) {
        propertyService.addProperty(property);
        return new ModelAndView("redirect:/index");
    }
}
