package me.dovias.vtech.java.ld1;

import jakarta.persistence.EntityManager;

import me.dovias.vtech.java.ld1.repository.UserRepository;

public class ApplicationState {
    private final UserRepository users;


    public ApplicationState(EntityManager manager) {
        this.users = new UserRepository(manager);
    }


    public UserRepository getUsers() {
        return this.users;
    }
}
