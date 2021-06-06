package project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.dto.AddVacancyDto;
import project.dto.UserDto;
import project.model.ProfessionEnum;
import project.service.ProfessionService;
import project.service.VacancyService;

@Data
@RequiredArgsConstructor
@RestController
public class VacancyController {
    private final VacancyService vacancyService;
    private final ProfessionService professionService;

    @GetMapping("/vacancy")
    public ModelAndView addVacancyForm(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("vacancyPage");
        AddVacancyDto addVacancy = new AddVacancyDto();
        addVacancy.setEmployerLogin(((UserDto) request.getSession().getAttribute("session")).getLogin());
        modelAndView.addObject("professionList", professionService.getListOfTitles());
        modelAndView.addObject("vacancy", addVacancy);
        return modelAndView;
    }

    @PostMapping("/vacancy")
    public ModelAndView addVacancy(
        @RequestBody @ModelAttribute("vacancy") @Valid AddVacancyDto vacancy,
        BindingResult result
    ) {
        if(result.hasErrors()) {
            return new ModelAndView("vacancyPage");
        }
        vacancyService.addVacancy(vacancy);
        return new ModelAndView("redirect:users/" + vacancy.getEmployerLogin());
    }

    @GetMapping("/vacancy/find")
    public ModelAndView vacancyList(@RequestParam(name = "profession") ProfessionEnum profession) {
        ModelAndView modelAndView = new ModelAndView("vacancyList");
        modelAndView.addObject("list", vacancyService.getAllOfProfession(profession));
        return modelAndView;
    }

    @GetMapping("/vacancy/{id}")
    public ModelAndView vacancyDetails(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("vacancyDetails");
        modelAndView.addObject("item", vacancyService.getDetails(id));
        return modelAndView;
    }
}
