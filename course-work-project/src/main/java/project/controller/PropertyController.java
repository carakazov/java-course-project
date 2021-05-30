package project.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import project.dto.AddIntellectualPropertyDto;
import project.dto.ShowIntellectualPropertyDetailsDto;
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
        ShowIntellectualPropertyDetailsDto property = propertyService.getForDetails(
            id,
            ((UserDto) request.getSession().getAttribute("session")).getLogin()
        );
        ModelAndView modelAndView = new ModelAndView("details");
        modelAndView.addObject("item", property);
        return modelAndView;
    }
}
