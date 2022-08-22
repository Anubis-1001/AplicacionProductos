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
			VentanaProducto ventanaProd = new VentanaProducto(Utilidades.createBlankProduct()); //temp null
			Producto prod = Utilidades.parseProducto(ventanaProd.display());
			listasProd.put(prod.getCodigo(), prod);
			listaDispo.getItems().add(listasProd.get(prod.getCodigo()).getCodigo());
		});
		
		botonActualizar.setOnAction(e->{
			if (listaDispo.getSelectionModel().getSelectedItem() != null) {
				VentanaProducto ventanaProd = new VentanaProducto( listasProd.get(listaDispo.getSelectionModel().getSelectedItem()) );
				Producto prod = Utilidades.parseProducto(ventanaProd.display());
				// pregunta si el codigo actualizado es el mismo, si lo es, reemplaza el ya existente
				if (prod.getCodigo() == listaDispo.getSelectionModel().getSelectedItem()) {
					listasProd.put(prod.getCodigo(), prod);
				}
				else { // de lo contrario, borra el anterior y añade el nuevo.
					listasProd.remove(listaDispo.getSelectionModel().getSelectedItem());
					listasProd.put(prod.getCodigo(), prod);

				} // añade la nueva lista al list view.
				listaDispo.getItems().add(listasProd.get(prod.getCodigo()).getCodigo());
			}  
		});
		
		botonBorrar.setOnAction(e->{
			if (listaDispo.getSelectionModel().getSelectedItem() != null) {
				listasProd.remove(listaDispo.getSelectionModel().getSelectedItem());

			}
		});
		
		botonAtras.setOnAction(e->{
			ventana.setScene(new VentanaPrincipal(new VBox(35), ventana));
		});
		
		panel.setPadding(new Insets(10));
		panel.getChildren().addAll(botonAtras, listaDispo, botonAgregar, botonActualizar, botonBorrar);
	}
	


	public void setListaDispo(HashMap<String, Producto> listasProd) {
		listaDispo= new ListView<>();
		for(String item: listasProd.keySet()) {
			listaDispo.getItems().add(item);
		}
	}
}
