package edu.actividad1.poo2.actividad3_poo2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PrincipalController {

    @FXML
    private Label lblBienvenida;


    public void usuarioBienvenida(String usuario){
        lblBienvenida.setText("Bienvenido " + usuario);
    }

}
