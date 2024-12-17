package me.dovias.vtech.java.ld1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.application.Application;

public class EntryPoint {
    private static ApplicationState state;

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("application");
        EntityManager manager = factory.createEntityManager();

        state = new ApplicationState(manager);

        Application.launch(FXApplication.class);
        factory.close();

    }

    public static ApplicationState getApplicationState() {
        return EntryPoint.state;
    }
}
