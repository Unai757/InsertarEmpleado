package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword())) {
            System.out.println("Conectado con suceso!");
            //Creamos el insert
            String sql = "INSERT INTO EMPLEADO (ID, NOMBRE, SALARIO) VALUES (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //Ponemos los datos del insert
            pstmt.setInt(1, 4);
            pstmt.setString(2, "Juanito");
            pstmt.setDouble(3, 2500);
            pstmt.executeUpdate();
            System.out.println("Se ha añadido al empleado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


