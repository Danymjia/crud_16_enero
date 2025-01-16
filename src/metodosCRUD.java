import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public void leerUsuario(DefaultTableModel model){

        String query = "SELECT * FROM usuarios";
        try(Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String correo = rs.getString("correo");
                    int edad = rs.getInt("edad");

                    }

        }catch (Exception e){
            e.printStackTrace();
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
