package project.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import project.dao.AccessBuyerProfileDao;
import project.model.AccessBuyerProfile;
import project.model.IntellectualProperty;
import project.model.User;

@Data
@RequiredArgsConstructor
public class AccessBuyerProfileDaoImpl implements AccessBuyerProfileDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void addForeverAccessAccount(User user, IntellectualProperty property) {
        manager.merge(
            new AccessBuyerProfile()
                .setUser(user)
                .setProperty(property)
                .setBoughtForever(true)
                .setWatched(false)
        );
    }

    @Override
    public void addTemporalAccessAccount(User user, IntellectualProperty property) {
        manager.merge(
            new AccessBuyerProfile()
                .setUser(user)
                .setProperty(property)
                .setBoughtForever(false)
                .setWatched(false)
        );
    }
}
