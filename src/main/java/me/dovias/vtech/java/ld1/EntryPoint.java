package me.dovias.vtech.java.ld1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.application.Application;

public class EntryPoint {
    private static ApplicationContainer container;

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("application");
        EntityManager manager = factory.createEntityManager();

        EntryPoint.container = new ApplicationContainer(manager);

        Application.launch(FXApplication.class);
        factory.close();
    }

    public static ApplicationContainer getContainer() {
        return EntryPoint.container;
    }
}
