import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {


        JFrame frame = new JFrame("Pantalla de Gestion");
        frame.setContentPane(new crud().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.setPreferredSize(new Dimension(600,400));
        frame.pack();
        frame.setVisible(true);


        //Insertar

        //Leer
        //mC.leerUsuario();

        //Actualizar
        //mC.modificarUsuario(1, "Anita","ana@gmail.com",34);

        //Eliminar
        //mC.eliminarUsuario(1);
    }
}