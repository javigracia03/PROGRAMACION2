/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat.participante;

import java.io.IOException;
import java.io.InputStream;
import util.IO;
import util.Utilidades;

/**
 *
 * @author javie
 */
class Escuchador implements Runnable {
    
    
    private InputStream entrada;
    private boolean seguir = true;
    
    public Escuchador(InputStream entrada){
        this.entrada = entrada;
        Thread th2 = new Thread();
        th2.start();
    }//()

    public void run(){
        
      try{  
        while(seguir){
        
            String linea = recibeMensaje();
            Utilidades.muestraMensajeC(linea);//mostrarlo
        }//while
        
      } catch (IOException err){
          System.out.println("Ha habido un error: " + err.getMessage());
          Participante.acabar();
      }//try-catch   
    
    }//()
    
    private String recibeMensaje() throws IOException{  
        
        return IO.leeLinea(this.entrada);
    } 
    public void parar(){
    
        seguir = false;
    }//()
}//class
