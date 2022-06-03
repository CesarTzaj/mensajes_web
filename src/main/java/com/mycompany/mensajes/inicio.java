/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Gabriel
 */

    
public class inicio {
    public static void main(String[] args){
        
       Conexion con= new Conexion();
       
       try( Connection cnx= con.get_connection()){
             System.out.println("conexion exitosa");
       }catch(SQLException r){
           System.out.println(r);
       }
       
        Scanner sc = new Scanner(System.in);
        
        int option=0;
        do{
            System.out.println("----------------");
            System.out.println("Aplicacion  de mensajes");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensaje");
            System.out.println("3. Eliminar mensaje");
            System.out.println("4. Editar mensaje");
            System.out.println("5. Salir");
            //ingreso de option
            option = sc.nextInt();
            
            switch(option){
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.listarMensaje();
                    break;
                case 3:
                    MensajeService.borrarMensaje();
                    
                    break;
                case 4:
                    MensajeService.actulizarMensaje();
                    break;    
                default:
                    break;
            }
            
        }while(option != 5);
        Conexion conexion =new Conexion();
        try(Connection cnx = conexion.get_connection()){
            
        }catch(Exception e){
            System.out.println(e);            
    }
}
}

   