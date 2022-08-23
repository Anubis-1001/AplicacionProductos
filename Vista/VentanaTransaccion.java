package Vista;

import java.util.HashMap;
import Modelo.Producto;
import Modelo.Transaccion;
import Controlador.Main;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VentanaTransaccion extends Scene {

	// muestra una lista con todas las transacciones
	public VentanaTransaccion(VBox panel, Stage ventana, HashMap<String, Producto> productos) {
		super(panel, 500, 700);

		ListView<String> registroTransacciones = new ListView<>();
		for (Transaccion transaccion : Main.getTransacciones().values()) {
			registroTransacciones.getItems().add(transaccion.getCodigo());
		}

		Button agregar = new Button("Registrar venta");
		Button atras = new Button("Atras");

		VentanaRegistroTransaccion registro = new VentanaRegistroTransaccion(productos);

		agregar.setOnAction(e -> {
			registro.showAndWait();
			registroTransacciones.getItems().clear();
			for (Transaccion transaccion : Main.getTransacciones().values()) {
				registroTransacciones.getItems().add(transaccion.getCodigo());
			}
		});

		atras.setOnAction(e -> {
			ventana.setScene(new VentanaPrincipal(new VBox(35), ventana));
		});

		Button ver = new Button("Ver registro");

		ver.setOnAction(e -> {
			Transaccion transaccionSelect = Main.getTransacciones().get(registroTransacciones.getSelectionModel().getSelectedItem());
			FacturaTransaccion factura = new FacturaTransaccion(transaccionSelect);
			factura.show();
		});

		panel.getChildren().addAll(atras, registroTransacciones, ver, agregar);
		panel.setPadding(new Insets(10));
	}

}
