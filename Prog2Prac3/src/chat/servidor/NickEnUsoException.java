/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat.servidor;

/**
 *
 * @author javie
 */
class NickEnUsoException extends Exception {

    public NickEnUsoException(){

        System.out.println("El nick seleccionado ya está en uso");

    }//()    
    
    public NickEnUsoException(String mensaje){

        System.out.println(mensaje);

    }//()
    
}//class
