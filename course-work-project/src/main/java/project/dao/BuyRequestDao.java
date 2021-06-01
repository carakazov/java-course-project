package project.dao;

import java.util.List;

import project.model.BuyRequest;
import project.model.IntellectualProperty;
import project.model.User;

public interface BuyRequestDao {
    void addRequest(BuyRequest request);

    boolean checkRequest(User buyer, IntellectualProperty property);

    List<BuyRequest> getAllReceivedRequests(User seller);

    void update(BuyRequest request);

    BuyRequest getById(int id);
}
