package project.service;

import project.dto.RegistrationDto;
import project.model.User;

public interface RegistrationService {
    User addNewUser(RegistrationDto registrationDto);
}
