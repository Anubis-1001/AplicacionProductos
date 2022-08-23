package Vista;

import java.util.HashMap;

import Modelo.Cliente;
import Utilidades.Utilidades;
import Modelo.Producto;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VentanaClientela extends Scene {

	private Button botonAgregar, botonActualizar, botonBorrar, botonAtras;
	private ListView<String> listaDispo = new ListView<>();

	public VentanaClientela(VBox panel, HashMap<String, Cliente> listasCliente, Stage ventana) {
		super(panel, 400, 500);
		for (String item : listasCliente.keySet()) {
			listaDispo.getItems().add(item);
		}

		botonAtras = new Button("Atras");
		botonAgregar = new Button("Agregar");
		botonActualizar = new Button("Actualizar");
		botonBorrar = new Button("Borrar");

		botonAgregar.setOnAction(e -> {
			VentanaIngresoClientes ventanaClientes = new VentanaIngresoClientes(new Cliente());
			Cliente cliente = Utilidades.parseCliente(ventanaClientes.display());
			listasCliente.put((cliente.getId()), cliente);
			listaDispo.getItems().add(String.valueOf(listasCliente.get(cliente.getId()).getId()));
		});

		botonActualizar.setOnAction(e -> {
			if (listaDispo.getSelectionModel().getSelectedItem() != null) {
				VentanaIngresoClientes ventanaClientes = new VentanaIngresoClientes(
						listasCliente.get(listaDispo.getSelectionModel().getSelectedItem()));
				Cliente cliente = Utilidades.parseCliente(ventanaClientes.display());

				if (cliente.getId() == listaDispo.getSelectionModel().getSelectedItem()) {
					listasCliente.put((cliente.getId()), cliente);
				} else {
					listasCliente.remove(listaDispo.getSelectionModel().getSelectedItem());
					listasCliente.put((cliente.getId()), cliente);
				}

				listaDispo.getItems().add(String.valueOf(listasCliente.get(cliente.getId()).getId()));
				for (Cliente client : listasCliente.values()) {
					listaDispo.getItems().add(client.getId());
				}
			} else {
				Alerta mensajeAlerta = new Alerta("No se ha seleccionado ningun cliente");
				mensajeAlerta.show();
			}
			listaDispo.getItems().clear();


		});

		botonBorrar.setOnAction(e -> {
			if (listaDispo.getSelectionModel().getSelectedItem() != null) {
				listasCliente.remove(listaDispo.getSelectionModel().getSelectedItem());
			}
			listaDispo.getItems().clear();
			for (Cliente cliente : listasCliente.values()) {
				listaDispo.getItems().add(cliente.getId());
			}

		});

		botonAtras.setOnAction(e -> {
			ventana.setScene(new VentanaPrincipal(new VBox(35), ventana));
		});

		panel.setPadding(new Insets(10));
		panel.getChildren().addAll(botonAtras, listaDispo, botonAgregar, botonActualizar, botonBorrar);

	}

	public void setListaDispo(HashMap<String, Cliente> listasCliente) {
		listaDispo = new ListView<>();
		for (String item : listasCliente.keySet()) {
			listaDispo.getItems().add(item);
		}

	}
}
