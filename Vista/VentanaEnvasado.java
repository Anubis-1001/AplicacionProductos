package Vista;


import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Modelo.Envasado;
import javafx.geometry.Insets;
import javafx.scene.control.TextInputControl;


//Crea el subformulario para los productos envasados
public class VentanaEnvasado extends GridPane{
	VentanaEnvasado(Envasado producto){
		

		
		
		agregarEntrada("Fecha de envasado", new TextField(), "dd/ MM/ yyyy", 0, "" + producto.getFechaEnvasado().toLocaleString() );
		agregarEntrada("Peso de envase", new TextField(), "ingrese el peso del envase", 1, Double.toString(producto.getPeso()));
		ComboBox<String> paises = new ComboBox<>();
		paises.getItems().addAll("Colombia", "Argentina", "Chile", "Ecuador","Perú");
		agregarEntrada("Pais de origen", paises, "seleccione el pais de origen", 2, producto.getPais());
		
		this.setPadding(new Insets(3));
		this.setHgap(10);
		this.setVgap(10);
	}
	
	VentanaEnvasado(){
		agregarEntrada("Fecha de envasado", new TextField(), "dd/ MM/ yyyy", 0,"");
		
		agregarEntrada("Peso de envase", new TextField(), "ingrese el peso del envase", 1, "");
		
		ComboBox<String> paises = new ComboBox<>();
		paises.getItems().addAll("Colombia", "Argentina", "Chile", "Ecuador","Perú");
		agregarEntrada("Pais de origen", paises, "seleccione el pais de origen", 2, null);
		
		this.setPadding(new Insets(3));
		this.setHgap(10);
		this.setVgap(10);
	}
	
	
	public void agregarEntrada(String etiqueta, TextInputControl campo, String indicacion, int fila, String textoInicial) {
		Label subtitulo = new Label(etiqueta);
		campo.setPromptText(indicacion);
		campo.setId(etiqueta);
		campo.setText(textoInicial);
		this.setConstraints(subtitulo, 0, fila);
		this.setConstraints(campo, 1, fila);
		this.getChildren().addAll(subtitulo, campo);
	}
	
	public void agregarEntrada(String etiqueta, ComboBox<String> campo, String indicacion, int fila, String pais) {
		Label subtitulo = new Label(etiqueta);
		campo.setPromptText(indicacion);
		campo.setId(etiqueta);
		if (pais != null) {
			campo.setValue(pais);	
		}
		this.setConstraints(subtitulo, 0, fila);
		this.setConstraints(campo, 1, fila);
		this.getChildren().addAll(subtitulo, campo);
	}
}
