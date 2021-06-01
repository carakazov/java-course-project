package project.dao;

import java.util.List;

import project.model.IntellectualProperty;

public interface IntellectualPropertyDao {
    void addProperty(IntellectualProperty intellectualProperty);

    List<IntellectualProperty> getAll();

    List<IntellectualProperty> getAllUnchecked();

    void approve(int id);

    void decline(int id);

    IntellectualProperty getById(int id);

    void update(IntellectualProperty intellectualProperty);
}
