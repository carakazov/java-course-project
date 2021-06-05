package project.dao;

import java.util.List;

import project.model.Profession;
import project.model.ProfessionEnum;


public interface ProfessionDao {
    List<Profession> getAll();

    Profession getByTitle(ProfessionEnum title);
}
