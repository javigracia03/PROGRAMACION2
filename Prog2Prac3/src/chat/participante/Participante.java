/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chat.participante;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import util.IO;
import util.Utilidades;

/**
 *
 * @author javie
 */
public class Participante {

    /**
     * @param args the command line arguments
     */

    private static Socket elSocket;
    private static String hostServidor;
    private static String nick;
    private static InputStream entrada;
    private static OutputStream salida;
    private static Escuchador miEscuchador;
    private static int puerto;


    
    private static void obtenerIpPuerto(){
        String linea= Utilidades.leerTextoG("dime localización del servidor(ip:Puerto)");
        try{

            String[] trozos= linea.split(":");
            hostServidor= trozos[0];
            puerto= Integer.parseInt(trozos[1]);
        } catch (Exception err){
            System.out.println("No he entendido ip:puerto-" + linea);
            acabar();
        }// try-catch
    }//()

    private static void abrirConexion(){

        try{
            Socket s = new Socket(hostServidor, puerto);
            entrada = s.getInputStream();
            salida = s.getOutputStream();
        } catch (IOException err){
            Utilidades.muestraMensajeG("Ha habido un error al abrirconexion() " + err.getMessage());
            acabar();
        }    

    }//()

    private static void IniciarSesion(){
        
        try{
            nick = Utilidades.leerTextoG("dime nick");
            enviaMensaje(nick);
            if (!IO.leeLinea(entrada).equals("OK")){
                acabar();
            }//if
        } catch (IOException err){
            Utilidades.muestraMensajeG("Ha habido un error al Iniciar Sesion " + err.getMessage());
            acabar();
        }    

    }//()

    private static void leerYEnviar(){

    String linea;

    do {
        linea = Utilidades.leerTextoG("¡Escribe un mensaje, " + nick + "!");
        if (linea!=null && linea.length()>0 && !linea.equals("SALIR")){

           enviaMensaje(linea);
        }//IF

    } while(linea!=null && !linea.equals("SALIR"));

    enviaMensaje("SALIR");
    
    }//()

    
    public static void main(String[] args) {


        obtenerIpPuerto();
        abrirConexion();
        IniciarSesion();



        leerYEnviar();
        acabar();
                
        // TODO code application logic here
    }

    public static void acabar() {
        if(elSocket ==null){
            System.exit(0);
        }//if

        try{

        miEscuchador.parar();
        entrada.close();
        salida.close();
        elSocket.close();
        elSocket = null;

        Utilidades.muestraMensajeC("*¡Hasta luego!");
        System.exit(0);
        } catch(Exception ex){

        }//try-catch
    }//()
    

    public static void enviaMensaje(String mensaje) {
        if (mensaje==null || mensaje.length()==0){
            return;
        }//if

        try {

            IO.escribeLinea(mensaje, salida);
        } catch (IOException ex) {
        acabar();
        }
            }//()


    
}
