package Vista;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.GridPane;

public class VentanaClienteJuridico extends GridPane {

    public VentanaClienteJuridico(){

        agregarEntrada("NIT", new TextField(), "ingrese el NIT del cliente", 0);
        this.setPadding(new Insets(1));

        this.setHgap(10);
        this.setVgap(10);

    }

    public void agregarEntrada(String etiqueta, TextInputControl campo, String indicacion, int fila) {
        Label subtitulo = new Label(etiqueta);
        campo.setId(etiqueta);
        campo.setPromptText(indicacion);
        this.setConstraints(subtitulo, 0, fila);
        this.setConstraints(campo, 1, fila);
        this.getChildren().addAll(subtitulo, campo);
    }

}
