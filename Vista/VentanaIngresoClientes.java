package Vista;

import Modelo.Cliente;
import Modelo.PersonaNatural;
import Modelo.PersonaJuridica;
import Modelo.Refrigerado;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.HashMap;

public class VentanaIngresoClientes extends Stage {

	private GridPane subFormulario;
	private HashMap<String, String> c;
	private Button crear;
	private Scene scene;
	private TextInputControl nombreCampo, idCampo, direccionCampo, telCampo;
	private ComboBox<String> listaTipos;

	public VentanaIngresoClientes(Cliente cliente) {

		GridPane cuadricula = new GridPane();
		nombreCampo = new TextField();
		agregarEntrada("Nombre", nombreCampo, "Ingrese su nombre", 0, cuadricula, cliente.getNombre());

		idCampo = new TextField();
		agregarEntrada("Id", idCampo, "Ingrese la identificación del cliente", 1, cuadricula, cliente.getId());

		telCampo = new TextArea();
		agregarEntrada("Teléfono", telCampo, "Ingrese el teléfono del cliente", 2, cuadricula, cliente.getTelefono());

		direccionCampo = new TextField();
		agregarEntrada("Dirección", direccionCampo, "Ingrese la dirección del cliente", 3, cuadricula,
				cliente.getDireccion());

		c = new HashMap<String, String>();
		crear = new Button("Agregar");
		cuadricula.setConstraints(crear, 1, 7);
		cuadricula.setHalignment(crear, HPos.CENTER);

		listaTipos = new ComboBox<>();
		listaTipos.getItems().addAll("Natural", "Juridico");
		cuadricula.setConstraints(listaTipos, 1, 5);

		if (cliente instanceof PersonaNatural) {
			listaTipos.setValue("Natural");
			subFormulario = new VentanaClienteNatural((PersonaNatural) cliente);
			cuadricula.setConstraints(subFormulario, 1, 6);
			cuadricula.getChildren().add(subFormulario);
		} else {
			if (cliente instanceof PersonaJuridica) {
				listaTipos.setValue("Juridico");
				subFormulario = new VentanaClienteJuridico((PersonaJuridica) cliente);
				cuadricula.setConstraints(subFormulario, 1, 6);
				cuadricula.getChildren().add(subFormulario);
			} else {
				listaTipos.setPromptText("Seleccione el tipo de cliente");
			}

		}

		listaTipos.setOnAction(e -> {
			cuadricula.getChildren().remove(subFormulario);
			cuadricula.setConstraints(crear, 1, 7);
			subFormulario = new GridPane();

			if (listaTipos.getValue() == "Natural") {
				subFormulario = new VentanaClienteNatural();
			}

			else if (listaTipos.getValue() == "Juridico") {
				subFormulario = new VentanaClienteJuridico();
			}

			cuadricula.setConstraints(subFormulario, 1, 6);
			cuadricula.getChildren().add(subFormulario);

		});

		cuadricula.setPadding(new Insets(10, 10, 10, 10));
		cuadricula.setHgap(10);
		cuadricula.setVgap(10);

		cuadricula.getChildren().addAll(listaTipos, crear);

		scene = new Scene(cuadricula, 700, 500);

		this.setScene(scene);

		getInfo();
	}

	// Agrega una etiqueta y campo para escribir texto
	public void agregarEntrada(String etiqueta, TextInputControl campo, String indicacion, int fila,
			GridPane cuadricula, String textoInicial) {
		Label subtitulo = new Label(etiqueta);
		campo.setPromptText(indicacion);
		campo.setText(textoInicial);
		cuadricula.setConstraints(subtitulo, 0, fila);
		cuadricula.setConstraints(campo, 1, fila);
		cuadricula.getChildren().addAll(subtitulo, campo);
	}

	// Muestra la ventana y devuelve un array con los datos del formulario
	// cuando se presiona en agregar
	public void getInfo() {
		crear.setOnAction(e -> {
			try {
				// agrega los valores del formulario al arraylist de strings
				// es normal que lance excepciones, ya que no todos los elementos del
				// formulario son campos para poner texto, algunos son etiquetas
				c.put("tipoCliente", listaTipos.getValue());
				c.put("nombre", nombreCampo.getText());
				c.put("id", idCampo.getText());
				c.put("direccion", direccionCampo.getText());
				c.put("telefono", telCampo.getText());

				for (Node node : subFormulario.getChildren()) {
					try {
						TextInputControl entradaCampo = (TextInputControl) node;
						c.put(entradaCampo.getId(), entradaCampo.getText());
					} catch (Exception excp) {
						System.out.println(excp);
					}
					try {
						ComboBox<String> entradaCampo = (ComboBox<String>) node;
						c.put(entradaCampo.getId(), entradaCampo.getValue());
					} catch (Exception excp) {
						System.out.println(excp);
					}
				}
			}

			catch (Exception excp) {
				System.out.println(excp);
			}

			this.close();
		});
	}

	public HashMap<String, String> display() {
		this.setScene(scene);
		this.showAndWait();
		return this.c;
	}

}
