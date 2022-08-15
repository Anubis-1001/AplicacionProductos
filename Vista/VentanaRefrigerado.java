package Vista;

import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;



//Crea el subformulario para los productos refrigerados
public class VentanaRefrigerado extends GridPane{
	public VentanaRefrigerado(){
		
		agregarEntrada("codigo aprobacion", new TextField(), "ingrese el codigo de aprobacion", 0);
		agregarEntrada("temperatura optima", new TextField(), "ingrese la temperatura recomendada ", 1);
		this.setPadding(new Insets(2));
		
		this.setHgap(10);
		this.setVgap(10);
		
		
	}
	
	public void agregarEntrada(String etiqueta, TextInputControl campo, String indicacion, int fila) {
		Label subtitulo = new Label(etiqueta);
		campo.setPromptText(indicacion);
		this.setConstraints(subtitulo, 0, fila);
		this.setConstraints(campo, 1, fila);
		this.getChildren().addAll(subtitulo, campo);
	}
}
