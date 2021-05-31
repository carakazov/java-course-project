package project.service;

import java.util.List;

import project.dto.AddIntellectualPropertyDto;
import project.dto.ShowIntellectualPropertyDetailsDto;
import project.dto.ShowIntellectualPropertyDto;
import project.model.IntellectualProperty;

public interface PropertyService {
    void addProperty(AddIntellectualPropertyDto propertyDto);

    List<ShowIntellectualPropertyDto> getAllForIndex();

    ShowIntellectualPropertyDetailsDto getForDetails(int id, String login);

    IntellectualProperty getById(int id);

    String getOwnerLoginByPropertyId(int propertyId);

    List<IntellectualProperty> getAllPropertyOfUser(String login);
}
