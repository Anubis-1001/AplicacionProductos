package Vista;

import java.util.ArrayList;


import Modelo.Producto;

import javafx.scene.text.TextAlignment;
import javafx.scene.layout.GridPane;

import javafx.scene.control.Button;
import javafx.scene.control.TextInputControl;

import javafx.geometry.HPos;
import javafx.geometry.Insets;

import javafx.geometry.VPos;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.control.TextArea;



import javafx.scene.Scene;


public class VentanaProducto {
	private Scene scene;
	private GridPane subFormulario;
	private GridPane cuadricula;
	public VentanaProducto(){
		cuadricula = new GridPane();
		
		/*Label nombre = new Label("Nombre");
		TextField nombreCampo = new TextField();
		nombreCampo.setPromptText("ingrese su nombre");
		cuadricula.setConstraints(nombre, 0,0);
		cuadricula.setConstraints(nombreCampo, 1,0);
		*/
		
		TextField nombreCampo = new TextField();
		agregarEntrada("Nombre", nombreCampo, "ingrese su nombre", 0);
		
		/*Label id = new Label("id");
		TextField idCampo = new TextField();
		idCampo.setPromptText("ingrese su id");
		cuadricula.setConstraints(id, 0,1);
		cuadricula.setConstraints(idCampo, 1,1);
		*/
		
		TextField idCampo = new TextField();
		agregarEntrada("Id", idCampo, "ingrese su id", 1);
		
		/*Label descripcion  = new Label("Descripcion");
		descripcion.setTextAlignment(TextAlignment.LEFT);
		cuadricula.setValignment(descripcion, VPos.TOP);
		
		TextArea descCampo = new TextArea();
		descCampo.setPromptText("ingrese una descripcion del producto");
		cuadricula.setConstraints(descripcion, 0,2);
		cuadricula.setConstraints(descCampo, 1,2);
		*/
		
		TextArea descCampo = new TextArea();
		agregarEntrada("desc", descCampo, "ingrese su nombre", 2);
		
		Label valorUnitario = new Label("valor por unidad");
		TextField valorUCampo = new TextField();
		valorUCampo.setPromptText("ingrese su id");
		cuadricula.setConstraints(valorUnitario, 0,3);
		cuadricula.setConstraints(valorUCampo, 1,3);
		
		Label cantidadExistente = new Label("cantidad existente");
		TextField cantidadCampo = new TextField();
		cantidadCampo.setPromptText("unidades disponibles");
		cuadricula.setConstraints(cantidadExistente, 0,4);
		cuadricula.setConstraints(cantidadCampo, 1,4);
		
		
		ArrayList<String> c = new ArrayList<>();
		c.add(nombreCampo.getText());
		c.add(idCampo.getText());
		c.add(valorUCampo.getText());
		c.add(descCampo.getText());
		c.add(cantidadCampo.getText());
		
		Button crear = new Button("Agregar");
		cuadricula.setConstraints(crear, 1,6);
		cuadricula.setHalignment(crear, HPos.CENTER);
		crear.setOnAction(e->{
			try {
				Producto.getProductosCreados().add(
						new Producto(c.get(0), Integer.parseInt(c.get(1)), Integer.parseInt(c.get(2)), c.get(3), Integer.parseInt(c.get(4))));
			}
			catch(Exception excp) {
				System.out.println(excp);
			}
		});
		
		ComboBox<String> listaTipos = new ComboBox<>();
		listaTipos.getItems().addAll("Envasado", "Perecedero", "Refrigerado");
		listaTipos.setPromptText("seleccione el tipo de producto");
		cuadricula.setConstraints(listaTipos, 1, 5);
		
		//GridPane subFormulario;
		
		listaTipos.setOnAction(e->{
			cuadricula.getChildren().remove(subFormulario);
			cuadricula.setConstraints(crear, 1, 7);
			subFormulario = new GridPane();
			
			
			
			
			if(listaTipos.getValue() == "Envasado") {
				
				subFormulario = new VentanaEnvasado();
				cuadricula.setConstraints(subFormulario, 1, 6);
				cuadricula.getChildren().add(subFormulario);
			}
			else if(listaTipos.getValue() == "Perecedero") {

				subFormulario = new VentanaPerecedero();
				cuadricula.setConstraints(subFormulario, 1, 6);
				cuadricula.getChildren().add(subFormulario);
				
			}
			else if(listaTipos.getValue() == "Refrigerado") {
				subFormulario = new VentanaRefrigerado();
				cuadricula.setConstraints(subFormulario, 1, 6);
				cuadricula.getChildren().add(subFormulario);
			}
			
		});
		
		
		
		
		
		
		cuadricula.setPadding(new Insets(10,10,10,10));
		cuadricula.setHgap(10);
		cuadricula.setVgap(10);
		
		
		//cuadricula.getChildren().addAll(listaTipos, nombre, nombreCampo, id, idCampo, descripcion, descCampo, valorUnitario, valorUCampo, cantidadExistente, cantidadCampo, crear);
		Scene scene = new Scene(cuadricula, 700, 500);
		
		this.scene = scene;
		
	}
	
	public void agregarEntrada(String etiqueta, TextInputControl campo, String indicacion, int fila) {
		Label subtitulo = new Label(etiqueta);
		campo.setPromptText(indicacion);
		cuadricula.setConstraints(subtitulo, 0, fila);
		cuadricula.setConstraints(campo, 1, fila);
		cuadricula.getChildren().addAll(subtitulo, campo);
	}
	
	public Scene getScene() {
		return this.scene;
	}
	
	
}
