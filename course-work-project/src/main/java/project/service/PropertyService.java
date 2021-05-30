package project.service;

import java.util.List;

import project.dto.AddIntellectualPropertyDto;
import project.dto.ShowIntellectualPropertyDetailsDto;
import project.dto.ShowIntellectualPropertyDto;

public interface PropertyService {
    void addProperty(AddIntellectualPropertyDto propertyDto);

    List<ShowIntellectualPropertyDto> getAllForIndex();

    ShowIntellectualPropertyDetailsDto getForDetails(int id, String login);

    ShowIntellectualPropertyDetailsDto getFreeComposition(int id);
}
