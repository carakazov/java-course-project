package project.dao;

import java.util.List;

import project.model.IntellectualProperty;

public interface IntellectualPropertyDao {
        IntellectualProperty addProperty(IntellectualProperty intellectualProperty);

        List<IntellectualProperty> getAll();
}
