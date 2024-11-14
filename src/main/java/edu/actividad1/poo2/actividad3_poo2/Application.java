package edu.actividad1.poo2.actividad3_poo2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    Stage loginStage;

    @Override
    public void start(Stage stage) throws IOException {
        this.loginStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 250);
        stage.setTitle("Login");
        stage.setScene(scene);

        LoginController lc = fxmlLoader.getController();
        lc.setMain(this);

        stage.show();
    }

    public void cargarPrincipal(String usuario) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("principal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);

        PrincipalController pc = fxmlLoader.getController();
        pc.usuarioBienvenida(usuario);

        Stage principalStage = new Stage();
        principalStage.setTitle("Bienvenida");
        principalStage.setScene(scene);
        principalStage.show();
        loginStage.hide();

        // Manejar el evento de cierre del nuevo Stage
        principalStage.setOnCloseRequest(e -> {
            loginStage.show(); // Mostrar el Stage principal nuevamente
        });
    }

    public static void main(String[] args) {
        launch();
    }


}