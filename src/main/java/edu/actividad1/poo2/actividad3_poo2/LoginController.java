package edu.actividad1.poo2.actividad3_poo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.Console;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController {

    @FXML
    private Button Ingresar;

    @FXML
    private Label lblContraseña;

    @FXML
    private Label lblIniciarSesion;

    @FXML
    private Label lblUsuario;

    @FXML
    private TextField txtFContraseña;

    @FXML
    private TextField txtFUsuario;

    // referencia al archivo de aplicacion para comunicacion
    Application app;

    public  void setMain(Application main){
        this.app = main;
    }

    @FXML
    public void clicIngresar(ActionEvent actionEvent) throws IOException{
        String usuario = txtFUsuario.getText();
        String contraseña = txtFContraseña.getText();
        boolean salida = false;

        if(usuario.isEmpty() || contraseña.isEmpty()) {
            alertError("Debe llenar los campos de Usuario y Contraseña.");
        }
        else
        {
            boolean salidaU = validarCorreo(usuario);
            boolean salidaP = validarContraseña(contraseña);

            salida = (salidaU && salidaP) ? true : false;

            if(salida){
                app.cargarPrincipal(usuario);
                limpiarCampos();
            }
            else {
                alertError("El correo debe ser valido y la constraseña debe tener una longitud de 8 caracteres, tiene que incluir 1 letra mayúscula, 1 letra minúscula y 1 número.");
            }
        }
    }


    private boolean validarCorreo(String correo){
        boolean salida = false;
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"; // Expresión regular para validar correos

        Pattern pattern = Pattern.compile(regex); // Compila el regex
        Matcher matcher = pattern.matcher(correo); // Crea un matcher para el email

        salida = matcher.matches() ? true : false; // Asignar el valor de salida
        //System.out.println(matcher.matches() ? "Correo electrónico válido." : "Correo electrónico inválido.");
        return salida;
    }

    private boolean validarContraseña(String contraseña){
        boolean salida = false;
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";

        Pattern pattern = Pattern.compile(regex); // Compila el regex
        Matcher matcher = pattern.matcher(contraseña); // Crea un matcher para la contraseña

        salida = matcher.matches() ? true : false;
        //System.out.println(matcher.matches() ? "La contraseña es válida." : "La contraseña es inválida.");
        return  salida;
    }


    private void alertError(String texto) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(texto);
        // Cargar el archivo CSS
        alert.getDialogPane().getStylesheets().add(getClass().getResource("Estilos.css").toExternalForm());
        alert.showAndWait();
    }

    public void limpiarCampos(){
        txtFContraseña.setText("");
        txtFUsuario.setText("");
    }
}
