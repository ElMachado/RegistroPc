package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Buscar {
    @FXML
    public Text nombreEncargadoOutText;
    @FXML
    public TextArea solucionText;
    @FXML
    TextArea diagnosticoText;
    String cadena;
    String nRegistrotk;
    String path = System.getProperty("user.home");
    @FXML
    private TextField nRegisroIntTex;
    private String nRegistro;
    private String nombreEncargado;
    private String diagnostico;
    private String solucion;

    public void buscar() throws IOException {
        String rArchivo = path + "/archivo.txt";
        nRegistro = nRegisroIntTex.getText();
        FileReader archivo = new FileReader(rArchivo);
        BufferedReader lectura = new BufferedReader(archivo);
        ArrayList<String> cadenaArrayList = new ArrayList<>();

        while ((cadena = lectura.readLine()) != null) {
            cadenaArrayList.add(cadena);
        }

        for (String s : cadenaArrayList) {
            String[] parts = s.split(";;");
            nRegistrotk = parts[0];
            nombreEncargado = parts[1];
            diagnostico = parts[2];
            solucion = parts[3];
            if (nRegistrotk.equals(nRegistro)) {
                nombreEncargadoOutText.setText(nombreEncargado);
                diagnosticoText.setText(diagnostico);
                solucionText.setText(solucion);
                break;
            }
            nRegistrotk = null;
            lectura.close();
        }
        if (nRegistrotk == null) {
            JOptionPane.showMessageDialog(null, "No se encontro registro");
        }
    }
}

