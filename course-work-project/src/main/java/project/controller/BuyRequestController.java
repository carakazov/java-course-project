package project.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import project.dto.BuyRequestDto;
import project.service.BuyRequestService;

@RestController
@Data
@RequiredArgsConstructor
public class BuyRequestController {
    private final BuyRequestService buyRequestService;

    @PostMapping("/send")
    public ModelAndView sendRequest(@RequestBody @ModelAttribute("requestDto") BuyRequestDto buyRequestDto) {
        return null;
    }
}
