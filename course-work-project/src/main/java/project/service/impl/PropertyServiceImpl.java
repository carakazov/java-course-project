package project.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.BuyRequestDao;
import project.dao.GenreDao;
import project.dao.IntellectualPropertyDao;
import project.dao.PortfolioDao;
import project.dto.AddIntellectualPropertyDto;
import project.dto.ChangeOwnershipDto;
import project.dto.ShowIntellectualPropertyDetailsDto;
import project.dto.ShowIntellectualPropertyDto;
import project.model.*;
import project.service.PropertyService;
import project.service.UserService;
import project.support.mapper.IntellectualPropertyMapper;
import project.support.mapper.dto.AddIntellectualPropertyMappingDto;
import project.support.mapper.dto.ShowIntellectualPropertyMappingDto;
import project.support.mapper.dto.UserMappingDto;

@RequiredArgsConstructor
@Service
public class PropertyServiceImpl implements PropertyService {
    private final IntellectualPropertyDao propertyDao;
    private final GenreDao genreDao;
    private final UserService userService;
    private final IntellectualPropertyMapper propertyMapper;
    private final PortfolioDao portfolioDao;
    private final BuyRequestDao buyRequestDao;

    @Override
    @Transactional
    public void addProperty(AddIntellectualPropertyDto propertyDto) {
        User owner = userService.getUserByLogin(propertyDto.getAuthor().getLogin());
        List<Genre> genres = genreDao.getGenres(propertyDto.getIntellectualPropertyDto().getAttributes().getGenres());
        IntellectualProperty property =
            propertyMapper.fromAddDto(
                new AddIntellectualPropertyMappingDto(
                    propertyDto.getIntellectualPropertyDto(),
                    owner,
                    Collections.singletonList(owner),
                    genres
                ));
        propertyDao.addProperty(property);
    }

    @Override
    @Transactional
    public List<ShowIntellectualPropertyDto> getAllForIndex() {
        List<IntellectualProperty> property = propertyDao.getAll();
        List<ShowIntellectualPropertyMappingDto> mappingList = new ArrayList<>();
        property.forEach(item -> mappingList.add(showIntellectualPropertyMappingDto(item)));
        return propertyMapper.toShowDto(mappingList);
    }

    @Override
    @Transactional
    public ShowIntellectualPropertyDetailsDto getForDetails(int id, String login) {
        IntellectualProperty propertyEntity = propertyDao.getById(id);
        ShowIntellectualPropertyDto propertyDto = propertyMapper
            .toShowDto(showIntellectualPropertyMappingDto(propertyEntity));
        User user = userService.getUserByLogin(login);
        ShowIntellectualPropertyDetailsDto details = new ShowIntellectualPropertyDetailsDto();
        details.setProperty(propertyDto);
        details.setRequested(buyRequestDao.checkRequest(user, propertyEntity));
        if(!propertyEntity.getAccessType().equals(AccessTypeEnum.free)) {
            if(propertyEntity.getProfiles().stream().map(AccessBuyerProfile::getUser)
                .collect(Collectors.toList()).contains(user)) {
                details.setAvailable(true);
                AccessBuyerProfile profile = propertyEntity.getProfiles().stream().filter(
                    item -> item.getUser().equals(user)
                ).findFirst().get();
                details.setWatched(profile.getWatched())
                    .setForever(profile.getBoughtForever());
            } else {
                details.setAvailable(false)
                    .setForever(false)
                    .setWatched(false);
            }
        } else {
            details.setAvailable(true);
            details.setForever(true);
        }
        return details;
    }

    @Override
    public IntellectualProperty getById(int id) {
        return propertyDao.getById(id);
    }

    @Override
    @Transactional
    public String getOwnerLoginByPropertyId(int propertyId) {
        return propertyDao.getById(propertyId).getOwner().getLogin();
    }

    @Override
    @Transactional
    public List<IntellectualProperty> getAllPropertyOfUser(String login) {
        return userService.getUserByLogin(login).getOwnedProperty()
            .stream().filter(item -> item.getAccessType().equals(AccessTypeEnum.subscription))
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void changeOwnership(ChangeOwnershipDto changeOwnershipDto) {
        IntellectualProperty property = propertyDao.getById(changeOwnershipDto.getPropertyId());
        property.setOwner(userService.getUserByLogin(changeOwnershipDto.getNewOwnerLogin()));
        propertyDao.update(property);
    }

    private ShowIntellectualPropertyMappingDto showIntellectualPropertyMappingDto(IntellectualProperty property) {
        return new ShowIntellectualPropertyMappingDto(
            property,
            new UserMappingDto(
                property.getOwner(),
                portfolioDao.findPortfolioOfUser(property.getOwner())
            ),
            getMappingDtoFromAuthors(property.getAuthors())
        );
    }

    private List<UserMappingDto> getMappingDtoFromAuthors(List<User> authors) {
        return authors.stream()
            .map(item -> new UserMappingDto(
                item,
                portfolioDao.findPortfolioOfUser(item)
            ))
            .collect(Collectors.toList());
    }
}
