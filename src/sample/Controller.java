package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;

public class Controller {

    public void onRegistreButton(javafx.event.ActionEvent actionEvent) {
        try {
            Stage planillaStage = new Stage();
            AnchorPane root = FXMLLoader.load(getClass().getResource("Registro.fxml"));
            Scene scene = new Scene(root);
            planillaStage.setScene(scene);
            planillaStage.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error");
        }

    }

    public void onBuscarButton(javafx.event.ActionEvent actionEvent) {
        try {
            Stage planillaStage = new Stage();
            AnchorPane root = FXMLLoader.load(getClass().getResource("Buscar.fxml"));
            Scene scene = new Scene(root);

            planillaStage.setScene(scene);
            planillaStage.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error");
        }

    }
}
