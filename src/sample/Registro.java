package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Registro {

    String numeroRegisro;
    String nombreEncargado;
    String diagnosticoPc;
    String solucionPc;
    String cadena;
    String nRegistroSplit;
    String path = System.getProperty("user.home");
    @FXML
    private TextField numeroRegistroText;
    @FXML
    private TextField nombreEncargadoInText;
    @FXML
    private TextArea diagnosticoInTxt;
    @FXML
    private TextArea solucionInText;

    public void Guardar() throws IOException {
        String rArchivo = path + "/archivo.txt";
        numeroRegisro = numeroRegistroText.getText();
        nombreEncargado = nombreEncargadoInText.getText();
        diagnosticoPc = diagnosticoInTxt.getText();
        solucionPc = solucionInText.getText();


        File archivo = new File(rArchivo);
        BufferedWriter escritura;

        if (!archivo.exists()) {
            archivo.createNewFile();
            escritura = new BufferedWriter(new FileWriter(archivo, true));
            escritura.write("numeroRegistro" + ";;" + "nombreEncargado" + ";;" + "diagnosticoPc" + ";;" + "solucionPc" + "\n");
            escritura.close();
        }


        FileReader archivoLeer = new FileReader(rArchivo);
        BufferedReader lectura = new BufferedReader(archivoLeer);
        ArrayList<String> cadenaArrayList = new ArrayList<>();


        while ((cadena = lectura.readLine()) != null) {
            cadenaArrayList.add(cadena);
        }
        for (String s : cadenaArrayList) {
            String[] parts = s.split(";;");
            nRegistroSplit = parts[0];
            if (nRegistroSplit.equals(numeroRegistroText.getText())) {
                JOptionPane.showMessageDialog(null, "El numero de registro ya ha sido ingresado.");
                break;

            }

        }

        if (!nRegistroSplit.equals(numeroRegistroText.getText())) {
            if (archivo.exists()) {
                escritura = new BufferedWriter(new FileWriter(archivo, true));
                escritura.write(numeroRegisro + ";;" + nombreEncargado + ";;" + diagnosticoPc + ";;" + solucionPc + ";;" + "\n");
                JOptionPane.showMessageDialog(null, "Se ha guardado el registro correctamente.");
            } else {
                escritura = new BufferedWriter(new FileWriter(archivo, true));
                escritura.write(numeroRegisro + ";;" + nombreEncargado + ";;" + diagnosticoPc + ";;" + solucionPc + ";;" + "\n");
                JOptionPane.showMessageDialog(null, "Se ha guardado el registro correctamente.");
            }
            escritura.close();
        }


    }
}



