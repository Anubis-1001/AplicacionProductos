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
    private Scene scene;
    private String flag;
    private ListView<String> listaDispo = new ListView<>();

    public VentanaClientela(VBox panel, HashMap<String, Cliente> listasCliente, Stage ventana) {
        super(panel, 400, 500);
        for (String item : listasCliente.keySet()) {
            listaDispo.getItems().add(item);
        }

        botonAtras = new Button("atras");
        botonAgregar = new Button("agregar");
        botonActualizar = new Button("actualizar");
        botonBorrar = new Button("borrar");

        botonAgregar.setOnAction(e->{
            VentanaIngresoClientes ventanaClientes = new VentanaIngresoClientes();
            Cliente cliente = Utilidades.parseCliente(ventanaClientes.display());
            listasCliente.put((cliente.getId()), cliente);
            listaDispo.getItems().add(String.valueOf(listasCliente.get(cliente.getId()).getId()));
        });

        botonAtras.setOnAction(e->{
            ventana.setScene(new VentanaPrincipal(new VBox(35), ventana));
        });

        //VBox panel = new VBox(10);
        panel.setPadding(new Insets(10));
        panel.getChildren().addAll(botonAtras, listaDispo, botonAgregar, botonActualizar, botonBorrar);


    }

    public void setListaDispo(HashMap<String, Cliente> listasCliente) {
        listaDispo= new ListView<>();
        for(String item: listasCliente.keySet()) {
            listaDispo.getItems().add(item);
        }

    }
}
