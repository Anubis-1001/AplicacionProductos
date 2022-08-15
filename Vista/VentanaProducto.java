package Vista;

import java.util.ArrayList;
import Modelo.Producto;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputControl;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class VentanaProducto extends Scene{
	private GridPane subFormulario;
	private ArrayList<String> c;
	private Button crear;
	private TextInputControl nombreCampo, idCampo, valorUCampo, descCampo, cantidadCampo;
	private ComboBox<String> listaTipos;
	
	
	//El constructor crea la ventana para crear un producto de cualquier tipo
	public VentanaProducto(GridPane cuadricula){
		super(cuadricula, 700, 500);
		
		nombreCampo = new TextField();
		agregarEntrada("Nombre", nombreCampo, "ingrese su nombre", 0, cuadricula);
		
		
		idCampo = new TextField();
		agregarEntrada("Id", idCampo, "ingrese su id", 1, cuadricula);
		
		descCampo = new TextArea();
		agregarEntrada("Descripcion", descCampo, "ingrese una descripcion del producto", 2, cuadricula);
		
		valorUCampo = new TextField();
		agregarEntrada("Valor unitario", valorUCampo, "ingrese el valor por unidad", 3, cuadricula);
				
		cantidadCampo = new TextField();
		agregarEntrada("Cantidad diisponible", cantidadCampo, "ingrese la cantidad disponible", 4, cuadricula);
		
		c = new ArrayList<>();
		
		
		crear = new Button("Agregar");
		cuadricula.setConstraints(crear, 1,6);
		cuadricula.setHalignment(crear, HPos.CENTER);
		
		
		
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
	public ArrayList<String> display(){
		Stage window = new Stage();
		crear.setOnAction(e->{
			try {
				//agrega los valores del formulario al arraylist de strings
				//es normal que lance excepciones, ya que no todos los elementos del
				//formulario son campos para poner texto, algunos son etiquetas
				c.add(listaTipos.getValue());
				c.add(nombreCampo.getText());
				c.add(idCampo.getText());
				c.add(valorUCampo.getText());
				c.add(descCampo.getText());
				c.add(cantidadCampo.getText());
				

				for(Node node: subFormulario.getChildren()) {
					try {
						c.add(((TextInputControl) node).getText());
					}
					catch(Exception excp) {
						System.out.println(excp);
					}
					try {
						c.add(((ComboBox<String>) node).getValue());
					}
					catch(Exception excp) {
						System.out.println(excp);
					}
				}
			}
		
			catch(Exception excp) {
				System.out.println(excp);
			}
			
			window.close();
		});
		
		
		window.setScene(this);
		window.showAndWait();
		return this.c;
		
	}
}
