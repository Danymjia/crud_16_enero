import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.Option;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class crud {
    public JPanel mainPanel;
    private JTextField nombretxt;
    private JTextField correotxt;
    private JTextField edadtxt;
    private JButton ingresarBtn;
    private JButton eliminarBtn;
    private JButton actualizarBtn;
    private JButton leerBtn;

    public crud() {
        ingresarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                metodosCRUD mC = new metodosCRUD();

                mC.insertarUsuario(nombretxt.getText(),correotxt.getText(),Integer.valueOf(edadtxt.getText()));
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente" , "Acción realizada", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        leerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Ejemplo de JTable");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                String[] columnas = {"Nombre", "Correo", "Edad"};

                Object[][] datos = {
                        {"Juan Pérez", "juan@example.com", 30},
                        {"Ana López", "ana@example.com", 25},
                        {"Carlos García", "carlos@example.com", 35}
                };

                DefaultTableModel model = new DefaultTableModel(datos, columnas);

                JTable tabla = new JTable(model);

                JScrollPane scrollPane = new JScrollPane(tabla);

                frame.add(scrollPane);

                frame.setSize(600, 400);
                frame.setVisible(true);
            }
        });
        actualizarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    metodosCRUD mC = new metodosCRUD();
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del usuario"));
                    mC.modificarUsuario(id, nombretxt.getText(),correotxt.getText(),Integer.valueOf(edadtxt.getText()));
                    JOptionPane.showMessageDialog(null, "Datos Actualizados correctamente" , "Acción realizada", JOptionPane.INFORMATION_MESSAGE);
                }catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Ingrese el id del usuario");
                }
            }
        });
        eliminarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    metodosCRUD mC = new metodosCRUD();
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del usuario"));
                    mC.eliminarUsuario(id);
                    JOptionPane.showMessageDialog(null, "Datos Eliminados correctamente" , "Acción realizada", JOptionPane.INFORMATION_MESSAGE);
                }catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Ingrese el id del usuario");
                }
            }
        });
    }
}
