package Vista;

import Modelo.PersonaJuridica;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.GridPane;

public class VentanaClienteJuridico extends GridPane {

	public VentanaClienteJuridico() {

		agregarEntrada("NIT", new TextField(), "Ingrese el NIT del cliente", 0, "");
		this.setPadding(new Insets(1));
		this.setHgap(10);
		this.setVgap(10);

	}

	public VentanaClienteJuridico(PersonaJuridica cliente) {

		agregarEntrada("NIT", new TextField(), "Ingrese el NIT del cliente", 0, Integer.toString(cliente.getNit()));
		this.setPadding(new Insets(1));
		this.setHgap(10);
		this.setVgap(10);

	}

	public void agregarEntrada(String etiqueta, TextInputControl campo, String indicacion, int fila,
			String textoInicial) {
		Label subtitulo = new Label(etiqueta);
		campo.setId(etiqueta);
		campo.setPromptText(indicacion);
		campo.setText(textoInicial);
		VentanaClienteJuridico.setConstraints(subtitulo, 0, fila);
		VentanaClienteJuridico.setConstraints(campo, 1, fila);
		this.getChildren().addAll(subtitulo, campo);
	}

}
