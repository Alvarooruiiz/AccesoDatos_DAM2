import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class ExploradorDeArchivos {
    private JPanel panel1;
    private JComboBox comboBox1;
    private JButton buscarButton;
    private JButton cancelarButton;
    private JScrollPane lista1;
    private JScrollPane lista2;




    public class FileExplorerApp {


        private static void createAndShowGUI() {
            // Crear un JFrame
            JFrame frame = new JFrame("Explorador de Archivos");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Crear un JPanel para mostrar el nombre del archivo seleccionado
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Archivo seleccionado: ");
            JTextField textField = new JTextField(20);
            panel.add(label);
            panel.add(textField);

            // Crear un botón para abrir el explorador de archivos
            JButton openButton = new JButton("Abrir Archivo");
            openButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();

                    // Mostrar el cuadro de diálogo de selección de archivo
                    int returnValue = fileChooser.showOpenDialog(null);

                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        textField.setText(selectedFile.getName());
                    } else {
                        textField.setText("Ningún archivo seleccionado.");
                    }
                }
            });

            // Agregar componentes al JFrame
            frame.add(panel, BorderLayout.CENTER);
            frame.add(openButton, BorderLayout.SOUTH);

            // Centrar la ventana en la pantalla
            frame.setLocationRelativeTo(null);

            // Hacer visible la ventana
            frame.setVisible(true);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FileExplorerApp.createAndShowGUI();
        });
    }
}
