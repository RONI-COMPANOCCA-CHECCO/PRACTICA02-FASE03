package paquete;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    private Conexion() {
    }

    private static Connection conexion;
    private static Conexion instancia;
    private static final String URL = "jdbc:mysql://localhost/bd_fp2_23b";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // método para conectar a la base de datos
    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            return conexion;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return conexion;
    }

    // método para cerrar la conexión
    public void cerrarConexion() throws SQLException {
        try {
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        } finally {
            conexion.close();
        }
    }

    // patrón singleton
    public static Conexion getInstance() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }
}
