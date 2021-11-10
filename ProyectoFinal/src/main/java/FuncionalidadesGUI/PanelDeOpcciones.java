/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncionalidadesGUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author baquiax
 */
public class PanelDeOpcciones {

    private String texto;
    private String path;
    private boolean existeArchivo;

    /**
     * Constructor con un path del archivo
     *
     * @param texto
     * @param path
     */
    public PanelDeOpcciones(String texto, String path) {
        this.path = path;
        this.existeArchivo = false;
    }

    /**
     * Consturctor por defecto
     */
    public PanelDeOpcciones() {
    }

    /**
     * Abre un archivo
     *
     * @return el texto del archivo seleccionado
     */
    public String abrirArchivo() {
        JFileChooser fileChooser = new JFileChooser();

        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            String datos = "";
            try (FileReader entrada = new FileReader(ruta)) {
                BufferedReader miBuffer = new BufferedReader(entrada);
                String linea = "";
                while (linea != null) {

                    linea = miBuffer.readLine();
                    if (linea != null) {
                        datos = datos + linea + "\n";
                    }
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            setTexto(datos);
            return "Archivo abierto exitosamente";
        } else {
            return "No se ha seleccionado ningún fichero";
        }
    }

    public void guardarArchivo() {
        JFileChooser guardar = new JFileChooser();
        guardar.showSaveDialog(null);
        guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        File archivo = guardar.getSelectedFile();
        FileWriter escribir;
        try {

            escribir = new FileWriter(archivo, true);
            //escribir.write(txtTexto.getText());
            escribir.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, ponga nombre al archivo");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, en la salida");
        }
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the existeArchivo
     */
    public boolean isExisteArchivo() {
        return existeArchivo;
    }

    /**
     * @param existeArchivo the existeArchivo to set
     */
    public void setExisteArchivo(boolean existeArchivo) {
        this.existeArchivo = existeArchivo;
    }
    
}
