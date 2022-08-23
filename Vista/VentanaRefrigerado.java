package Vista;

import javafx.scene.layout.GridPane;
import Modelo.Refrigerado;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

//Crea el subformulario para los productos refrigerados
public class VentanaRefrigerado extends GridPane {
	public VentanaRefrigerado() {

		agregarEntrada("Codigo aprobacion", new TextField(), "Ingrese el codigo de aprobacion", 0, "");
		agregarEntrada("Temperatura optima", new TextField(), "Ingrese la temperatura recomendada ", 1, "");
		this.setPadding(new Insets(2));

		this.setHgap(10);
		this.setVgap(10);
	}

	public VentanaRefrigerado(Refrigerado producto) {

		agregarEntrada("Codigo aprobacion", new TextField(), "Ingrese el codigo de aprobacion", 0,
				producto.getCodigoControl());
		agregarEntrada("Temperatura optima", new TextField(), "Ingrese la temperatura recomendada ", 1,
				Integer.toString(producto.getTemperaturaOptima()));
		this.setPadding(new Insets(2));

		this.setHgap(10);
		this.setVgap(10);
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
