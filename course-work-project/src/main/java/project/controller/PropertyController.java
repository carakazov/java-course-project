package project.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import lombok.Data;
import lombok.RequiredArgsConstructor;
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
        property.setAuthor((UserDto) request.getSession().getAttribute("session"));
        modelAndView.addObject("property", property);
        modelAndView.addObject("genres", genres);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addProperty(
        @RequestBody @ModelAttribute("property") @Valid AddIntellectualPropertyDto property,
        @RequestParam("file") MultipartFile file
    ) throws IOException {
        property.getIntellectualPropertyDto().setContent(file.getBytes());
        propertyService.addProperty(property);
        return new ModelAndView("redirect:/index");
    }
}
