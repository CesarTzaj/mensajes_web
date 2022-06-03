/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes;

import java.util.Scanner;

    
public class MensajeService {
    public static void crearMensaje(){
    Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        
        System.out.println("Tu Nombre");
        String nombre = sc.nextLine();
        
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAuthor_mensaje(nombre);
        MensajeDAO.crearMensajeDB(registro);
    }
    public static void listarMensaje(){
    MensajeDAO.leerMensajesDB();
    }
    public static void borrarMensaje(){
    Scanner sc= new Scanner(System.in);
        System.out.println("Indica el ID del mensaje a borrar");
        int id_mensaje= sc.nextInt();
        //MensajeDAO.borrarMensajeDB(id_mensaje);
        MensajeDAO.borrarMensajeDB(id_mensaje);
    }
    public static void actulizarMensaje(){
    Scanner sc= new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        
        System.out.println("Tu Nombre");
        String nombre = sc.nextLine();
        
        System.out.println("el ID ");
        int id = sc.nextInt();
        Mensajes actulizacion = new Mensajes();
        
        actulizacion.setMensaje(mensaje);
        actulizacion.setAuthor_mensaje(nombre);
        actulizacion.setId_mensaje(id);
        MensajeDAO.actulizarMensaje(actulizacion);
    }
}

    

