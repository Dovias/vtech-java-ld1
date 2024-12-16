package me.dovias.vtech.java.ld1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

public class FXApplication extends Application {
    private static final URL MAIN_LAYOUT = FXApplication.class.getResource("/main.fxml");

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXApplication.MAIN_LAYOUT);

        VBox root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
