/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat.servidor;

import java.io.*;
import java.net.*;

/**
 *
 * @author javie
 */
class ParticipanteProxy  implements Runnable{

    public GestorParticipantes elGestor;
    private OutputStream salida;
    private InputStream entrada;
    private String nick;
    private boolean seguir = true;
    private Socket elSocket;

    public ParticipanteProxy(Socket con, GestorParticipantes ges) {
        try{
            this.elSocket = con;
            this.elGestor = ges;
            salida = con.getOutputStream();
            entrada = con.getInputStream();

            nick = recibeMensaje();

            try{

                this.elGestor.anyadeParticipante(this);
            } catch (NickEnUsoException ex){

                entregaMensaje("nick ya esta en uso");
                this.cerrar(null);
                return;
            }   //try-catch

                entregaMensaje("OK");
                Thread th1 = new Thread();
                th1.start();
        }catch(IOException err){

        this.cerrar("se retira" + this.nick);

        }// try-cath
    }//()

    public void run(){

        this.elGestor.difundeMensaje("se conecta" + this.nick);

        this.entregaMensaje(elGestor.listaParticipantes());
        while(this.seguir == true){

            String mensaje = recibeMensaje();

            if (mensaje.equals("SALIR")){
                cerrar("se retira" + this.nick);
            } else{
            elGestor.difundeMensaje(mensaje);
            }//if-else
        }//while
    }//run



    public void entregaMensaje(String mensaje){

        if(mensaje==null || mensaje.length()==0){

            return;
        }//if

        try{
            util.IO.escribeLinea(mensaje, this.salida);

        } catch(IOException ex){
            this.cerrar("chat> se retira por fallos en la conexion (entregaMensaje()):" + this.nick);
        }//try-catch
    }//()

    private String recibeMensaje(){

        try{
            return util.IO.leeLinea(this.entrada);
        } catch(IOException err){
            this.cerrar("chat> se retira por fallos en la conexion (recibeMensaje()):" + this.nick);
        }//try-catch
        return "";
    }//()

    private void cerrar(String mensaje){

        try{

        this.seguir=false;
        this.elGestor.eliminaParticipante(this);
            entrada.close();
            salida.close();
            elSocket.close();
        if ((mensaje.length())>0 && (mensaje!=null)){
            elGestor.difundeMensaje(mensaje);
            elGestor.difundeMensaje(elGestor.listaParticipantes());

        } //if
        } catch (IOException err){
            System.out.println("Se ha producido un error: "+ err.getMessage());
        }//try-catch
    }//()
    public String getNick(){

        return nick;
    }   //()

 
}
