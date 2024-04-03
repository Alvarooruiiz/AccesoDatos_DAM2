import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class ExploradorDeArchivos {
    private JComboBox<String> unidadComboBox;
    private JList<String> carpetaList;
    private JList<String> archivoList;
    private JButton limpiarButton;
    private JButton aceptarButton;
    private JPanel mainPanel;
    private JScrollPane carpetaScrollPane;
    private JScrollPane archivoScrollPane;

    public ExploradorDeArchivos() {
        // Llenar el JComboBox con las unidades de disco disponibles
        File[] unidades = File.listRoots();
        String[] nombresUnidades = new String[unidades.length];
        for (int i = 0; i < unidades.length; i++) {
            nombresUnidades[i] = unidades[i].getPath();
        }
        unidadComboBox.setModel(new DefaultComboBoxModel<>(nombresUnidades));

        unidadComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String unidadSeleccionada = (String) unidadComboBox.getSelectedItem();
                if (unidadSeleccionada != null) {
                    File unidad = new File(unidadSeleccionada);
                    if (unidad.exists() && unidad.isDirectory()) {
                        String[] nombresDirectorios = listarDirectorios(unidad);
                        carpetaList.setListData(nombresDirectorios);
                    }
                }
            }
        });

        carpetaScrollPane.setViewportView(carpetaList);
        archivoScrollPane.setViewportView(archivoList);

        carpetaList.addListSelectionListener(e -> {
            String carpetaSeleccionada = carpetaList.getSelectedValue();
            String unidadSeleccionada = (String) unidadComboBox.getSelectedItem();
            if (carpetaSeleccionada != null && unidadSeleccionada != null) {
                String rutaCarpeta = unidadSeleccionada + File.separator + carpetaSeleccionada;
                File carpeta = new File(rutaCarpeta);
                if (carpeta.exists() && carpeta.isDirectory()) {
                    String[] nombresArchivos = carpeta.list();
                    archivoList.setListData(nombresArchivos);
                }
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carpetaList.setListData(new String[]{});
                archivoList.setListData(new String[]{});
            }
        });

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String carpetaSeleccionada = carpetaList.getSelectedValue();
                String archivoSeleccionado = archivoList.getSelectedValue();
                String unidadSeleccionada = (String) unidadComboBox.getSelectedItem();

                if (carpetaSeleccionada != null && archivoSeleccionado != null && unidadSeleccionada != null) {
                    String rutaArchivo = unidadSeleccionada + File.separator +
                            carpetaSeleccionada + File.separator + archivoSeleccionado;
                    System.out.println("Archivo seleccionado: " + rutaArchivo);
                }
            }
        });
    }

    private String[] listarDirectorios(File directorio) {
        List<String> nombresDirectorios = new ArrayList<>();
        File[] subdirectorios = directorio.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        if (subdirectorios != null) {
            for (File subdirectorio : subdirectorios) {
                nombresDirectorios.add(subdirectorio.getName());
            }
        }

        return nombresDirectorios.toArray(new String[0]);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("File Explorer");
        ExploradorDeArchivos ea = new ExploradorDeArchivos();
        frame.setContentPane(ea.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setVisible(true);
    }
}
