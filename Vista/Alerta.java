package Vista;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class Alerta extends Stage{
	public Alerta(String mensaje) {
		VBox panel = new VBox(20);
		panel.setPadding(new Insets(10));
		panel.setAlignment(Pos.CENTER);
		
		Label msg = new Label(mensaje);
		
		Button aceptar = new Button("aceptar");
		
		aceptar.setOnAction(e->{
			this.close();
		});
		
		panel.getChildren().addAll(msg, aceptar);
		
		Scene escena = new Scene(panel, 210, 200);
		
		this.initModality(Modality.APPLICATION_MODAL);
		
		this.setScene(escena);
	}
}
