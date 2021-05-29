package project.dao.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.dao.GenreDao;
import project.model.Genre;
import project.model.GenreTypeEnum;

@Repository
@RequiredArgsConstructor
public class GenreDaoImpl implements GenreDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Genre> getGenres(List<GenreTypeEnum> genreEnums) {
        return genreEnums.stream()
            .map(this::findByTitle)
            .collect(Collectors.toList());
    }

    private Genre findByTitle(GenreTypeEnum title) {
        return (Genre) manager.createQuery("SELECT genre FROM genres genre WHERE genre.title = :title ")
            .setParameter("title", title)
            .getSingleResult();
    }
}
