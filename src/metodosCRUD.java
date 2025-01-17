import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class metodosCRUD {

    //Metodo para insertar usuarios
    public void insertarUsuario(String nombre, String correo, int edad){

        String query = "INSERT INTO usuarios (nombre, correo, edad) VALUES (?, ?, ?)";
        try(Connection con = conexion.getConnection();
        PreparedStatement ps = con.prepareStatement(query))
        {
            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setInt(3, edad);
            ps.executeUpdate();
            System.out.println("Ingresado correctamente");

        }catch(SQLException e){
            e.printStackTrace();
    }}

    //Metodo para leer usuarios
    public DefaultTableModel leerUsuario() {
        String query = "SELECT * FROM usuarios";
        try (Connection con = conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
             ResultSet rs = ps.executeQuery();

             List<Object[]> datosList = new ArrayList<>();
             String[] columnas = {"Nombre", "Correo", "Edad"};

             while (rs.next()) {
                 String nombre = rs.getString("nombre");
                 String correo = rs.getString("correo");
                 int edad = rs.getInt("edad");

                 datosList.add(new Object[]{nombre, correo, edad});
             }

            Object[][] datos = new Object[datosList.size()][columnas.length];
            for (int i = 0; i < datosList.size(); i++) {
                datos[i] = datosList.get(i);
            }

            return new DefaultTableModel(datos, columnas);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //Metodo para actualizar usuarios

    public void modificarUsuario(int id, String nombre, String correo, int edad){

        String query = "UPDATE usuarios set nombre=?, correo=?, edad=? WHERE id=?";
        try(Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setInt(3, edad);
            ps.setInt(4, id);
            ps.executeUpdate();

            System.out.println("actualizado correctamente");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(int id){
        String query = "DELETE FROM usuarios WHERE id=?";
        try (Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("eliminado correctamente");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
