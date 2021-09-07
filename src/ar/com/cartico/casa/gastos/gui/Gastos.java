package ar.com.cartico.casa.gastos.gui;

import ar.com.cartico.casa.gastos.connector.Connector;
import ar.com.cartico.casa.gastos.repositories.implementation.CasaR;
import ar.com.cartico.casa.gastos.repositories.interfaz.I_CasaRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gastos extends Application {
    private I_CasaRepository cr;
        
    @Override
    public void start(Stage stage) throws Exception {
        cr = new CasaR(Connector.getConnection());
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Gastos Hogareños");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
