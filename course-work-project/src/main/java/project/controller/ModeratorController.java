package project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import project.service.ModeratorService;

@RestController
@RequiredArgsConstructor
public class ModeratorController {
    private final ModeratorService moderatorService;

    @GetMapping("/content")
    public ModelAndView moderatorPage() {
        ModelAndView modelAndView = new ModelAndView("moderationlist");
        modelAndView.addObject("items", moderatorService.getAllUnchecked());
        return modelAndView;
    }

    @GetMapping("/approve/{id}")
    public ModelAndView approve(@PathVariable("id") int id) {
        moderatorService.approve(id);
        return new ModelAndView("redirect:/content");
    }

    @GetMapping("/decline/{id}")
    public ModelAndView decline(@PathVariable("id") int id) {
        moderatorService.decline(id);
        return new ModelAndView("redirect:/content");
    }
}
