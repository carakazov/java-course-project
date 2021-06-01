package project.controller;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.dto.BuyRequestDto;
import project.dto.ChangeOwnershipDto;
import project.dto.RequestResultDto;
import project.dto.UserDto;
import project.service.BuyRequestService;
import project.service.PropertyService;

@RestController
@Data
@RequiredArgsConstructor
public class BuyRequestController {
    private final BuyRequestService buyRequestService;
    private final PropertyService propertyService;

    @PostMapping("/send")
    public ModelAndView sendRequest(@RequestBody @ModelAttribute("requestDto") BuyRequestDto buyRequestDto) {
        buyRequestService.addRequest(buyRequestDto);
        return new ModelAndView("redirect:/property/details/" + buyRequestDto.getPropertyId());
    }

    @GetMapping("/requestList")
    public ModelAndView getAllRequest(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("receivedRequests");
        RequestResultDto result = new RequestResultDto();
        modelAndView.addObject("result", result);
        modelAndView.addObject("list", buyRequestService.getAllRequests(
            ((UserDto) request.getSession().getAttribute("session")).getLogin()
        ));
        return modelAndView;
    }

    @PostMapping("/request")
    public ModelAndView changeOwnership(
        @RequestParam(name = "propertyId") int propertyId,
        @RequestParam(name = "buyerLogin") String buyerLogin,
        @RequestParam(name = "requestId") int requestId,
        @ModelAttribute("result") RequestResultDto result
    ) {
        buyRequestService.changeRequestStatus(requestId, result.isResult());
        if(result.isResult()) {
            propertyService.changeOwnership(
                new ChangeOwnershipDto(
                    propertyId,
                    buyerLogin
                )
            );
        }
        return new ModelAndView("redirect:/requestList");
    }
}
