/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexander
 */
public class Conexion {

    Connection con;

    public Conexion() {
        try {
            //Driver
            String URI = "jdbc:mysql://localhost:3308/inventario?autoReconnect=true&useSSL=false";
            Class.forName("java.sql.DriverManager");
            con = (Connection) DriverManager.getConnection(URI, "root", "");
            System.out.println("Conexion realizada");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar por " + e.toString());
        }
    }

    public Connection getConnection() {
        return con;
    }
}
