package Vista;

import javafx.scene.Scene;
import javafx.geometry.Insets;
import java.util.Date;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Modelo.Transaccion;
import Modelo.Cliente;
import Modelo.Detalle;

public class FacturaTransaccion extends Stage {
	FacturaTransaccion(Transaccion transaccion) {
		VBox panel = new VBox(15);
		Date fecha = transaccion.getFecha();
		int[] f = { fecha.getYear(), fecha.getMonth(), fecha.getDate(), fecha.getHours(), fecha.getMinutes() };
		Label etiquetaFecha = new Label((f[0] + 1900) + "/" + (f[1] + 1) + "/" + (f[2] + 1) + " " + f[3] + ":" + f[4]);
		Cliente cliente = transaccion.getCliente();
		Label etiquetaCliente = new Label(cliente.getNombre());
		Label etiquetaId = new Label(cliente.getId() + "");
		Label etiquetaDir = new Label(cliente.getDireccion().toString());
		Label columnas = new Label("Producto               Cantidad             Subtotal");
		Label separador = new Label("___________________________________________________");

		panel.getChildren().addAll(etiquetaFecha, etiquetaCliente, etiquetaId, etiquetaDir, columnas, separador);
		panel.setPadding(new Insets(10));

		for (Detalle detalle : transaccion.getDetalles()) {
			panel.getChildren().add(new Label(detalle.getProducto().getNombre() + "           " + detalle.getCantidad()
					+ "           " + detalle.getSubtotal()));
		}

		Scene escena = new Scene(panel, 300, 400);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setScene(escena);
	}
}
