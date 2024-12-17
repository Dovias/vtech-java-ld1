package me.dovias.vtech.java.ld1.repository;

import jakarta.persistence.EntityManager;

public class UserRepository {
    private EntityManager manager;

    public UserRepository(EntityManager manager) {
        this.manager = manager;
    }

}
