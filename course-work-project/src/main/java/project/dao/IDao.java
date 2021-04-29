package project.dao;

import java.util.List;

public interface IDao<T> {
    T create(T item);

    List<T> create(List<T> item);

    T read(Long id);

    List<T> read();

    T update(T item);

    List<T> update(List<T> item);

    void delete(Long id);

    void delete(T item);
}
