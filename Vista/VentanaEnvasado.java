package Vista;


import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.scene.control.TextInputControl;


public class VentanaEnvasado extends GridPane{
	VentanaEnvasado(){
		
		agregarEntrada("Fecha de envasado", new TextField(), "ingrese la fecha de envasado", 0);
		
		agregarEntrada("Peso de envase", new TextField(), "ingrese wl peso del envase", 1);
		
		ComboBox<String> paises = new ComboBox<>();
		paises.getItems().addAll("Colombia", "Argentina", "Chile", "Ecuador","Perú");
		agregarEntrada("pais de origen", paises, "seleccione el pais de origen", 2);
		
		this.setPadding(new Insets(3));
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
	
	public void agregarEntrada(String etiqueta, ComboBox<String> campo, String indicacion, int fila) {
		Label subtitulo = new Label(etiqueta);
		campo.setPromptText(indicacion);
		this.setConstraints(subtitulo, 0, fila);
		this.setConstraints(campo, 1, fila);
		this.getChildren().addAll(subtitulo, campo);
	}
}
