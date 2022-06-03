
package com.mycompany.mensajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    //jdbc:mysql://localhost:3306/prueba
    public Connection get_connection(){
    Connection conection =null;
    try{
        conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensaje","root","Cesar2539");

    }catch(SQLException e){
            System.out.println(e);
            }
    return conection;
}  
}
