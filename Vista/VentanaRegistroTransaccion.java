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



//a traves de sta ventan se muestran los pasos para registrar una transaccion
public class VentanaRegistroTransaccion extends Stage{
	
	private Scene escenaProductos;
	private Scene escenaClientes;
	private Scene factura;
	private Cliente cliente;
	private ArrayList<Detalle> detalles = new ArrayList<>();
	private VBox panelFactura;
	private int totalFactura=0;
	private Label etiquetaSubtotal, etiquetaIVA, etiquetaTotal;
	private final double IVA = 0.19;
	
	public VentanaRegistroTransaccion(HashMap<String, Producto> productos) {
		
		VBox panelRegistroCliente = new VBox(20);
		panelRegistroCliente.setPadding(new Insets(20));
		panelRegistroCliente.setAlignment(Pos.CENTER);
		
		TextField ingresoDeId = new TextField();
		
		ingresoDeId.setPromptText("ingrese el id del cliente");
		
		Button botonSiguiente = new Button("siguiente");
		
		Label indicacion = new Label("ingrese el id del cliente");
		
		
		crearListaProductos(productos);
		
		
		botonSiguiente.setOnAction(e->{
			cliente = Main.getClientela().get(ingresoDeId.getText());
			if(cliente != null) {
				//FacturaTransaccion factura = new FacturaTransaccion(new VBox(10), cliente, true);
				crearFactura();
				this.setScene(factura);
			}
			else {
				Alerta mensajeAlerta = new Alerta("cliente no encontrado");
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
		Label tituloId = new Label("id:         "+ cliente.getId());
		Label tituloNombre = new Label("Nombre:         "+ cliente.getNombre());
		Label columnas = new Label("Nombre            Cantidad          Subtotales");
		etiquetaSubtotal = new Label("                                 subtotal: ");
		etiquetaIVA = new Label("                                 IVA(19): ");
		etiquetaTotal = new Label("                                 Total: ");
		panelFactura.setPadding(new Insets(10));
		panelFactura.setAlignment(Pos.TOP_CENTER);
		
		Button botonAgregarCompra = new Button("agregar compra");
		
		Button terminarTransaccion = new Button("terminar transaccion");
		
		terminarTransaccion.setOnAction(e->{
			Transaccion transaccionFinal = new Transaccion(detalles, cliente);
			Main.getTransacciones().put(transaccionFinal.getCodigo(), transaccionFinal);
			
			this.close();
		});
		
		panelFactura.getChildren().addAll(tituloId, tituloNombre, columnas, etiquetaSubtotal, etiquetaIVA, etiquetaTotal, botonAgregarCompra, terminarTransaccion);
		factura = new Scene(panelFactura, 400, 500);
		botonAgregarCompra.setOnAction(e->{
			this.setScene(escenaProductos);
		});
		
		
	}
	
	public void crearListaProductos(HashMap<String, Producto> productos) {
		ListView<String> listaDisponibles = new ListView<>();
		VBox panel = new VBox(10);
		for(Producto prod: productos.values()) {
			listaDisponibles.getItems().add(prod.getCodigo()+": "+prod.getNombre());
		}
		
		
		TextField cantidad = new TextField();
		cantidad.setPromptText("ingrese la cantidad a comprar");
		cantidad.setMaxWidth(150);
		
		
		Button agregar = new Button("aceptar"); 
		Button terminar = new Button("terminar");
		
		
		escenaProductos = new Scene(panel, 400, 500);
		agregar.setOnAction(e->{
			detalles.add(new Detalle(Integer.parseInt(cantidad.getText()),
				Main.getInventario().get(listaDisponibles.getSelectionModel().getSelectedItem().split(":")[0])));
			Detalle detalleFactura = detalles.get(detalles.size()-1);
			
			String nombre = detalleFactura.getProducto().getNombre();
			int cantidadProd = detalleFactura.getCantidad();
			int subtotal = detalleFactura.getSubtotal();
			this.totalFactura+=subtotal;
			panelFactura.getChildren().add(3, new Label(nombre+"                   "+cantidadProd+"        "+subtotal));
			etiquetaSubtotal.setText("                                 Subtotal: "+totalFactura);
			etiquetaIVA.setText("                                 IVA(19%): "+totalFactura*IVA);
			etiquetaTotal.setText("                                 Total: "+totalFactura*(IVA+1));
			Alerta alerta = new Alerta("agregado "+nombre+" a la factura \nde venta ("+cantidadProd+" unidades)");
			alerta.show();
			cantidad.setText("");
		});
		
		terminar.setOnAction(e->{
			this.setScene(factura);
		});
		panel.getChildren().addAll(listaDisponibles, cantidad, agregar, terminar);
		panel.setPadding(new Insets(10));
	}
	
}
