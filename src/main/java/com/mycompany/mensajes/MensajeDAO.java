/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class MensajeDAO {
    
    public static void crearMensajeDB(Mensajes mensaje){
    Conexion db_connect = new Conexion();
    try(Connection conexion = db_connect.get_connection()){
        PreparedStatement ps=null;
        try{
            String query="INSERT INTO mensaje (mensaje, author_mensjae) \n" +
"	VALUES (?, ?)";
            ps=conexion.prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setString(2, mensaje.getAuthor_mensaje());
            ps.executeUpdate();
            System.out.println("Mensaje creado");
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
    }catch(SQLException e){
        System.out.println(e);
    }
    }
    public static void leerMensajesDB(){
    
    Conexion db_connect = new Conexion();
    PreparedStatement ps=null;
    ResultSet rs=null;
    try(Connection conexion = db_connect.get_connection()){
        String query="SELECT * FROM mensaje ;";
        ps=conexion.prepareStatement(query);
        rs=ps.executeQuery();
        while(rs.next()){
            System.out.println("ID: "+rs.getInt("id_mensaje"));
            System.out.println("Mensaje: "+rs.getString("mensaje"));
            System.out.println("Author mensaje: "+rs.getString("author_mensjae"));
            System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
            System.out.println("");
        }
        
        
    }catch(SQLException e){
        System.out.println("NO se pudieron recuperar  los mensajes");
        System.out.println(e);
    }
    }
    public static void borrarMensajeDB( int id_mensaje){
    Conexion db_connect = new Conexion();
    try(Connection conexion = db_connect.get_connection()){
        PreparedStatement ps=null;
        try{
            String query="DELETE FROM mensaje WHERE id_mensaje = ?";
            ps=conexion.prepareStatement(query);
            ps.setInt(1, id_mensaje);
            ps.executeUpdate();
            System.out.println("el mensaje fue borrado");
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("No se pudo borrar el mensaje");
        }
        
    }catch(SQLException e){
        System.out.println(e);
    }
    }
    public static void actulizarMensaje( Mensajes mensaje){
    
        Conexion db_connect = new Conexion();
        
           try(Connection conexion= db_connect.get_connection()) {
               PreparedStatement ps=null; 
               try {
                   String query ="UPDATE mensaje SET mensaje =?, author_mensjae = ? WHERE id_mensaje= ?";
                   ps=conexion.prepareCall(query);
                   ps.setString(1, mensaje.getMensaje());
                   ps.setString(2, mensaje.getAuthor_mensaje());
                   ps.setInt(3, mensaje.getId_mensaje() );
                   ps.executeUpdate();
                   System.out.println("Acutilizacion completada");
                   
               } catch (Exception ex) {
                   System.out.println(ex);
                   System.out.println("No se pudo acutlizar");
               }
            
        } catch (Exception e) {
        }
        
        //UPDATE mensaje SET mensaje = "value1", author_mensjae = "value2" WHERE id_mensaje= '3';
    }
    
}

/* 

    public static void borrarMensaje(int id_mensaje, String autor) {
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection()) {
            PreparedStatement pst = null;
            if (id_mensaje != 0) {
                try {
                    String query = "DELETE FROM mensaje WHERE id_mensaje = ?";
                    pst = conexion.prepareStatement(query);
                    pst.setInt(1, id_mensaje);
                    int ncont = pst.executeUpdate();
                    System.out.println("Registro Eliminado" + ncont);
                } catch (SQLException e) {
                    System.out.println("Error Borrar Registro");
                    System.out.println(e.getCause());
                    System.out.println(e.getStackTrace());
                }

            } else if (autor != "") {
                System.out.println(autor);
                try {
                    String query = "DELETE FROM mensajes WHERE author_mensjae = "+"?";
                    pst = conexion.prepareStatement(query);
                    pst.setString(1, autor);
                    int ncont = pst.executeUpdate();
                    System.out.println("Registro Eliminado" + ncont);
                } catch (SQLException e) {
                    System.out.println("Error Borrar Registro");
                    System.out.println(e.getCause());
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());
                }

            }

        } catch (SQLException e) {
            System.out.println("Error Conexion para borrar");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
*/