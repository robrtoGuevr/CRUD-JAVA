package com.unab.conexion;

import java.sql.*;

public class Conexion {
    private Connection conexion;
    public Conexion(){
        try {
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/lab?useTimezone=true&serverTimezone=UTC","root","root");
            System.out.println("Conexion existosa");
        } catch (Exception e) {
            System.out.println("Error en la conexion "+e);
        }
    }
    public Connection retornarConexion(){
        return conexion;
    }
}