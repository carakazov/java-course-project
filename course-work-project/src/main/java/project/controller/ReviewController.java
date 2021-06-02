package project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.dto.AddReviewDto;
import project.dto.ShowReviewDetails;
import project.dto.UserDto;
import project.service.ReviewService;

@RestController
@RequiredArgsConstructor
@Data
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/review/{id}")
    public ModelAndView reviewForm(
        @PathVariable("id") int id,
        HttpServletRequest request
    ) {
        AddReviewDto reviewDto = new AddReviewDto()
            .setAuthorLogin(((UserDto) request.getSession().getAttribute("session")).getLogin())
            .setPropertyId(id);
        ModelAndView modelAndView = new ModelAndView("review");
        modelAndView.addObject("review", reviewDto);
        return modelAndView;
    }

    @PostMapping("/review")
    public ModelAndView addReview(
        @RequestBody @ModelAttribute("review") @Valid AddReviewDto reviewDto,
        BindingResult result
    ) {
        if(result.hasErrors()) {
            return new ModelAndView("review");
        }
        reviewService.addReview(reviewDto);
        return new ModelAndView("redirect:property/details/" + reviewDto.getPropertyId());
    }

    @GetMapping("/list/{id}")
    public ModelAndView reviewList(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("reviewList");
        modelAndView.addObject("list", reviewService.getAllReviewsOfComposition(id));
        return modelAndView;
    }

    @GetMapping("/review/details/{id}")
    public ModelAndView reviewDetails(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("reviewDetails");
        ShowReviewDetails details = reviewService.getReviewDetails(id);
        modelAndView.addObject("details", details);
        return modelAndView;
    }
}
