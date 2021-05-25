package project.service.impl;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import project.dao.IntellectualPropertyDao;
import project.dto.ShowIntellectualPropertyDto;
import project.service.ModeratorService;
import project.support.mapper.IntellectualPropertyMapper;

@RequiredArgsConstructor
public class ModeratorServiceImpl implements ModeratorService {
    private final IntellectualPropertyDao propertyDao;
    private final IntellectualPropertyMapper mapper;

    @Override
    @Transactional
    public List<ShowIntellectualPropertyDto> getAllUnapproved() {
        return mapper.toShowDto(propertyDao.getAllUnapproved());
    }

    @Override
    public void approve(int propertyId) {
        propertyDao.approve(propertyId);
    }
}
