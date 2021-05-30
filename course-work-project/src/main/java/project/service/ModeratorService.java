package project.service;

import java.util.List;

import project.dto.ShowIntellectualPropertyDto;

public interface ModeratorService {
    List<ShowIntellectualPropertyDto> getAllUnchecked();

    void approve(int propertyId);

    void decline(int propertyId);
}

