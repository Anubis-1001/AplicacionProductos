package Vista;

import java.util.ArrayList;
import java.util.HashMap;

import Controlador.Main;
import Modelo.Cliente;
import Modelo.Detalle;
import Modelo.Transaccion;
import Modelo.Producto;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

//a traves de esta ventan se muestran los pasos para registrar una transaccion
public class VentanaRegistroTransaccion extends Stage {

	private Scene escenaProductos;
	private Scene escenaClientes;
	private Scene factura;
	private Cliente cliente;
	private ArrayList<Detalle> detalles = new ArrayList<>();
	private VBox panelFactura;
	private int totalFactura = 0;
	private Label etiquetaSubtotal, etiquetaIVA, etiquetaTotal;
	private final double IVA = 0.19;

	public VentanaRegistroTransaccion(HashMap<String, Producto> productos) {

		VBox panelRegistroCliente = new VBox(20);
		panelRegistroCliente.setPadding(new Insets(20));
		panelRegistroCliente.setAlignment(Pos.CENTER);

		TextField ingresoDeId = new TextField();

		ingresoDeId.setPromptText("Ingrese el id del cliente");

		Button botonSiguiente = new Button("Siguiente");

		Label indicacion = new Label("Ingrese el id del cliente");



		botonSiguiente.setOnAction(e -> {
			crearListaProductos(productos);
			cliente = Main.getClientela().get(ingresoDeId.getText());
			if (cliente != null) {
				crearFactura();
				this.setScene(factura);
			} else {
				Alerta mensajeAlerta = new Alerta("Cliente no encontrado");
				mensajeAlerta.show();
			}

		});

		panelRegistroCliente.getChildren().addAll(indicacion, ingresoDeId, botonSiguiente);

		escenaClientes = new Scene(panelRegistroCliente, 300, 200);

		this.initModality(Modality.APPLICATION_MODAL);
		this.setScene(escenaClientes);
	}

	public void crearFactura() {
		panelFactura = new VBox(10);
		Label tituloId = new Label("Id:         " + cliente.getId());
		Label tituloNombre = new Label("Nombre:         " + cliente.getNombre());
		Label columnas = new Label("Nombre            Cantidad          Subtotales");
		etiquetaSubtotal = new Label("                                 subtotal: ");
		etiquetaIVA = new Label("                                 IVA(19): ");
		etiquetaTotal = new Label("                                 Total: ");
		panelFactura.setPadding(new Insets(10));
		panelFactura.setAlignment(Pos.TOP_CENTER);

		Button botonAgregarCompra = new Button("Agregar compra");
		Button terminarTransaccion = new Button("Terminar transaccion");

		terminarTransaccion.setOnAction(e -> {
			Transaccion transaccionFinal = new Transaccion(detalles, cliente);
			Main.getTransacciones().put(transaccionFinal.getCodigo(), transaccionFinal);
			this.close();
		});

		panelFactura.getChildren().addAll(tituloId, tituloNombre, columnas, etiquetaSubtotal, etiquetaIVA,
				etiquetaTotal, botonAgregarCompra, terminarTransaccion);
		factura = new Scene(panelFactura, 400, 500);
		botonAgregarCompra.setOnAction(e -> {
			this.setScene(escenaProductos);
		});

	}

	public void crearListaProductos(HashMap<String, Producto> productos) {
		ListView<String> listaDisponibles = new ListView<>();
		VBox panel = new VBox(10);
		for (Producto prod : productos.values()) {
			listaDisponibles.getItems().add(prod.getCodigo() + ": " + prod.getNombre());
		}

		TextField cantidad = new TextField();
		cantidad.setPromptText("Ingrese la cantidad a comprar");
		cantidad.setMaxWidth(150);

		Button agregar = new Button("Aceptar");
		Button terminar = new Button("Terminar");

		escenaProductos = new Scene(panel, 400, 500);
		agregar.setOnAction(e -> {
			int cantidadIngresada = Integer.parseInt(cantidad.getText());
			int cantidadProd = Main.getInventario().get(listaDisponibles.getSelectionModel().getSelectedItem().split(":")[0]).getCantidadExistente();
			if (cantidadIngresada <=  cantidadProd && cantidadIngresada > 0) {
				Main.getInventario().get(listaDisponibles.getSelectionModel().getSelectedItem().split(":")[0]).setCantidadExistente(cantidadProd - cantidadIngresada);
				detalles.add(new Detalle(cantidadIngresada, Main.getInventario().get(listaDisponibles.getSelectionModel().getSelectedItem().split(":")[0])));
				Detalle detalleFactura = detalles.get(detalles.size() - 1);

				String nombre = detalleFactura.getProducto().getNombre();
				int subtotal = detalleFactura.getSubtotal();
				this.totalFactura += subtotal;
				panelFactura.getChildren().add(3,
						new Label(nombre + "                   " + cantidadIngresada + "        " + subtotal));
				etiquetaSubtotal.setText("                                 Subtotal: " + totalFactura);
				etiquetaIVA.setText("                                 IVA(19%): " + totalFactura * IVA);
				etiquetaTotal.setText("                                 Total: " + totalFactura * (IVA + 1));
				Alerta alerta = new Alerta( "Agregado " + nombre + " a la factura \nde venta (" + cantidadIngresada + " unidades)");
				alerta.show();
				cantidad.setText("");
			} else {
				Alerta mensajeAlerta = new Alerta("No hay suficientes productos para generar la venta");
				mensajeAlerta.show();
			}
			
		});

		terminar.setOnAction(e -> {
			this.setScene(factura);
		});
		panel.getChildren().addAll(listaDisponibles, cantidad, agregar, terminar);
		panel.setPadding(new Insets(10));
	}

}
