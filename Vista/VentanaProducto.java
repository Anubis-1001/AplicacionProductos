package Vista;

import java.util.HashMap;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputControl;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class VentanaProducto extends Stage{
	private GridPane subFormulario;
	private HashMap<String, String> c;
	private Button crear;
	private Scene scene;
	private TextInputControl nombreCampo, idCampo, valorUCampo, descCampo, cantidadCampo;
	private ComboBox<String> listaTipos;
	
	
	//El constructor crea la ventana para crear un producto de cualquier tipo
	public VentanaProducto(){
		
		GridPane cuadricula = new GridPane();
		nombreCampo = new TextField();
		agregarEntrada("Nombre", nombreCampo, "ingrese su nombre", 0, cuadricula);
		
		
		idCampo = new TextField();
		agregarEntrada("codigo", idCampo, "ingrese el codigo del producto", 1, cuadricula);
		
		descCampo = new TextArea();
		agregarEntrada("Descripcion", descCampo, "ingrese una descripcion del producto", 2, cuadricula);
		
		valorUCampo = new TextField();
		agregarEntrada("Valor unitario", valorUCampo, "ingrese el valor por unidad", 3, cuadricula);
				
		cantidadCampo = new TextField();
		agregarEntrada("Cantidad diisponible", cantidadCampo, "ingrese la cantidad disponible", 4, cuadricula);
		
		c = new HashMap<String, String>();
		
		
		crear = new Button("Agregar");
		cuadricula.setConstraints(crear, 1,6);
		cuadricula.setHalignment(crear, HPos.CENTER);
		
		crear.setOnAction(e->{
			c.put("tipoProducto",listaTipos.getValue());
			c.put("nombre",nombreCampo.getText());
			c.put("id",idCampo.getText());
			c.put("valorUnitario",valorUCampo.getText());
			c.put("descripcion", descCampo.getText());
			c.put("cantidadDisponible",cantidadCampo.getText());
			
			for(Node node: subFormulario.getChildren()) {
				if(node instanceof TextInputControl) {
					TextInputControl entradaCampo = (TextInputControl)node;
					c.put(entradaCampo.getId(), entradaCampo.getText());
				}
				
				else if(node instanceof ComboBox){
					ComboBox<String> entradaCampo = (ComboBox<String>) node;
					c.put(entradaCampo.getId(), entradaCampo.getValue());
				}
			}
		
		this.close();
	});
		
		listaTipos = new ComboBox<>();
		listaTipos.getItems().addAll("Envasado", "Perecedero", "Refrigerado");
		listaTipos.setPromptText("seleccione el tipo de producto");
		cuadricula.setConstraints(listaTipos, 1, 5);
		
		listaTipos.setOnAction(e->{
			cuadricula.getChildren().remove(subFormulario);
			cuadricula.setConstraints(crear, 1, 7);
			subFormulario = new GridPane();
						
			if(listaTipos.getValue() == "Envasado") {	
				subFormulario = new VentanaEnvasado();
			}
			
			else if(listaTipos.getValue() == "Perecedero") {
				subFormulario = new VentanaPerecedero();				
			}
			
			else if(listaTipos.getValue() == "Refrigerado") {
				subFormulario = new VentanaRefrigerado();
			}
			
			cuadricula.setConstraints(subFormulario, 1, 6);
			cuadricula.getChildren().add(subFormulario);
			
		});
		
		
		cuadricula.setPadding(new Insets(10,10,10,10));
		cuadricula.setHgap(10);
		cuadricula.setVgap(10);
		
		cuadricula.getChildren().addAll(listaTipos, crear);
		
		scene = new Scene(cuadricula, 700, 500);
	}
	
	//Agrega una etiqueta y campo para escribir texto
	public void agregarEntrada(String etiqueta, TextInputControl campo, String indicacion, int fila, GridPane cuadricula) {
		Label subtitulo = new Label(etiqueta);
		campo.setPromptText(indicacion);
		cuadricula.setConstraints(subtitulo, 0, fila);
		cuadricula.setConstraints(campo, 1, fila);
		cuadricula.getChildren().addAll(subtitulo, campo);
	}
	
	//Muestra la ventana y devuelve un array con los datos del formulario
	//cuando se presiona en agregar
	
	public HashMap<String,String>  display() {
		this.setScene(scene);
		this.showAndWait();
		return this.c;
	}
}


