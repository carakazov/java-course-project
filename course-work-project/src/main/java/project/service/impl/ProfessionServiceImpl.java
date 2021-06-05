package project.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import project.dao.ProfessionDao;
import project.model.Profession;
import project.model.ProfessionEnum;
import project.service.ProfessionService;

@Data
@RequiredArgsConstructor
public class ProfessionServiceImpl implements ProfessionService {
    private final ProfessionDao professionDao;

    @Override
    public List<ProfessionEnum> getListOfTitles() {
        return professionDao.getAll()
            .stream()
            .map(Profession::getTitle)
            .collect(Collectors.toList());
    }
}
