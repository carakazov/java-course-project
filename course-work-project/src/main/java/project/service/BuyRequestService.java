package project.service;

import java.util.List;

import project.dto.BuyRequestDto;
import project.dto.ShowBuyRequestDto;

public interface BuyRequestService {
    void addRequest(BuyRequestDto requestDto);

    List<ShowBuyRequestDto> getAllRequests(String sellerLogin);

    void changeRequestStatus(int requestId, boolean result);
}
