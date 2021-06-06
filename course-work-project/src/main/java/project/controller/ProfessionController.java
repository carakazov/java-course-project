package project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import project.service.ProfessionService;

@RestController
@RequiredArgsConstructor
public class ProfessionController {
    private final ProfessionService professionService;

    @GetMapping("/professions")
    public ModelAndView modelAndView() {
        ModelAndView modelAndView = new ModelAndView("professionList");
        modelAndView.addObject("list", professionService.getListOfTitles());
        return modelAndView;
    }
}
