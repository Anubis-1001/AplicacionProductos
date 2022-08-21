package Vista;
import java.util.HashMap;
import Utilidades.Utilidades;
import Modelo.Producto;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class VentanaLecturaProducto extends Scene{
	
	private Button botonAgregar, botonActualizar, botonBorrar, botonAtras;
	private Scene scene;
	private String flag;
	private ListView<String> listaDispo = new ListView<>();
	
	public VentanaLecturaProducto(VBox panel, HashMap<String, Producto> listasProd, Stage ventana) {
		super(panel, 400, 500);
		for(String item: listasProd.keySet()) {
			listaDispo.getItems().add(item);
		}
		
		botonAtras = new Button("atras");
		botonAgregar = new Button("agregar");
		botonActualizar = new Button("actualizar");
		botonBorrar = new Button("borrar");
		
		botonAgregar.setOnAction(e->{
			VentanaProducto ventanaProd = new VentanaProducto();
			Producto prod = Utilidades.parseProducto(ventanaProd.display());
			listasProd.put(prod.getCodigo(), prod);
			listaDispo.getItems().add(listasProd.get(prod.getCodigo()).getCodigo());
		});
		
		botonAtras.setOnAction(e->{
			ventana.setScene(new VentanaPrincipal(new VBox(35), ventana));
		});
		
		//VBox panel = new VBox(10);
		panel.setPadding(new Insets(10));
		panel.getChildren().addAll(botonAtras, listaDispo, botonAgregar, botonActualizar, botonBorrar);
		
		//scene = new Scene(panel, 400,500);
		//this.setScene(scene);
	}
	
	/*public String display() {
		botonAgregar.setOnAction(e->{
			try {
				flag = "agregar";
			//	this.close();
			} catch (Exception e2) {
			}
		});
		
		botonActualizar.setOnAction(e->{
			try {
				flag = "actualizar";
				//this.close();
			} catch (Exception e2) {
			}
		});
		
		botonBorrar.setOnAction(e->{
			try {
				flag = "borrar";
				//this.close();
			} catch (Exception e2) {
			}
		});
		//this.showAndWait();
		return flag;
	}*/

	public void setListaDispo(HashMap<String, Producto> listasProd) {
		listaDispo= new ListView<>();
		for(String item: listasProd.keySet()) {
			listaDispo.getItems().add(item);
		}
	}
}
