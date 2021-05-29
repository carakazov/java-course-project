package project.dao;

import java.util.List;

import project.model.Genre;
import project.model.GenreTypeEnum;

public interface GenreDao {
    List<Genre> getGenres(List<GenreTypeEnum> genreEnums);
}
