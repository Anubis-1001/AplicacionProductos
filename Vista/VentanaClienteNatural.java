package Vista;

import Modelo.PersonaNatural;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.GridPane;

public class VentanaClienteNatural extends GridPane {

	public VentanaClienteNatural() {

		Label fechaNacimiento = new Label("Fecha de nacimiento");
		TextField fechaNacimientoCampo = new TextField();
		fechaNacimientoCampo.setPromptText("Ingrese su fecha de nacimiento");
		fechaNacimientoCampo.setId("Fecha de nacimiento");
		this.setHgap(10);
		this.setVgap(10);
		this.setConstraints(fechaNacimiento, 0, 0);
		this.setConstraints(fechaNacimientoCampo, 1, 0);
		this.getChildren().addAll(fechaNacimiento, fechaNacimientoCampo);
		agregarEntrada("E-Mail", new TextField(), "Ingrese el e-mail del cliente", 1, "");
		this.setPadding(new Insets(1));
	}

	public VentanaClienteNatural(PersonaNatural cliente) {

		Label fechaNacimiento = new Label("Fecha de nacimiento");
		TextField fechaNacimientoCampo = new TextField();
		fechaNacimientoCampo.setPromptText("Ingrese su fecha de nacimiento");
		fechaNacimientoCampo.setId("Fecha de nacimiento");
		fechaNacimientoCampo.setText(cliente.getFechaNacimiento().toLocaleString());
		this.setHgap(10);
		this.setVgap(10);
		this.setConstraints(fechaNacimiento, 0, 0);
		this.setConstraints(fechaNacimientoCampo, 1, 0);
		this.getChildren().addAll(fechaNacimiento, fechaNacimientoCampo);
		agregarEntrada("E-Mail", new TextField(), "Ingrese el e-mail del cliente", 1, cliente.getEmail());
		this.setPadding(new Insets(1));
	}

	public void agregarEntrada(String etiqueta, TextInputControl campo, String indicacion, int fila,
			String textoInicial) {
		Label subtitulo = new Label(etiqueta);
		campo.setId(etiqueta);
		campo.setPromptText(indicacion);
		campo.setText(textoInicial);
		this.setConstraints(subtitulo, 0, fila);
		this.setConstraints(campo, 1, fila);
		this.getChildren().addAll(subtitulo, campo);
	}
}
