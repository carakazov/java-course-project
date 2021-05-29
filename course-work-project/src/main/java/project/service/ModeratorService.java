package project.service;

import java.util.List;

import project.dto.ShowIntellectualPropertyDto;

public interface ModeratorService {
    List<ShowIntellectualPropertyDto> getAllUnapproved();

    void approve(int propertyId);
}
