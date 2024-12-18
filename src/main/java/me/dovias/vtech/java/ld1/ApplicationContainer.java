package me.dovias.vtech.java.ld1;

import jakarta.persistence.EntityManager;

import me.dovias.vtech.java.ld1.repository.UserRepository;
import me.dovias.vtech.java.ld1.service.UserCredentialsService;
import me.dovias.vtech.java.ld1.service.user.*;

public class ApplicationContainer {
    private final UserInformationService usersInformation;

    public ApplicationContainer(EntityManager manager) {
        this.usersInformation = new UserInformationService(new UserCredentialsService(), new UserRepository(manager));
    }

    public UserInformationService getUserInformation() {
        return this.usersInformation;
    }
}
