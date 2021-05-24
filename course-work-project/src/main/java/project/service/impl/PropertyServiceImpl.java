package project.service.impl;

import java.util.Collections;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.GenreDao;
import project.dao.IntellectualPropertyDao;
import project.dto.AddIntellectualPropertyDto;
import project.model.Genre;
import project.model.IntellectualProperty;
import project.model.User;
import project.service.PropertyService;
import project.service.UserService;
import project.support.mapper.IntellectualPropertyMapper;
import project.support.mapper.dto.AddIntellectualPropertyMappingDto;

@RequiredArgsConstructor
@Service
public class PropertyServiceImpl implements PropertyService {
    private final IntellectualPropertyDao propertyDao;
    private final GenreDao genreDao;
    private final UserService userService;
    private final IntellectualPropertyMapper addPropertyMapper;

    @Override
    @Transactional
    public void addProperty(AddIntellectualPropertyDto propertyDto) {
        User owner = userService.getUserByLogin(propertyDto.getAuthor().getLogin());
        List<Genre> genres = genreDao.getGenres(propertyDto.getIntellectualPropertyDto().getAttributes().getGenres());
        IntellectualProperty property =
            addPropertyMapper.fromAddDto(
                new AddIntellectualPropertyMappingDto(
                    propertyDto.getIntellectualPropertyDto(),
                    owner,
                    Collections.singletonList(owner),
                    genres
                ));
        propertyDao.addProperty(property);
    }
}
