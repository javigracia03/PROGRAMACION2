/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chat.servidor;

import java.io.IOException;
import java.net.*;

/**
 *
 * @author javie
 */
public class ServidorMiniChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {    

String hostServidor = "localhost";

/*int PUERTO = 1234;

ServerSocket ss;
Socket s;


if(args.length == 3){

    hostServidor = args[0];
    PUERTO = Integer.parseInt(args[1]);
}//if
*/

int PUERTO = 1234;
ServerSocket ss;
Socket s;

ss = new ServerSocket(PUERTO);

GestorParticipantes elGestor = new GestorParticipantes();

System.out.println("IP: "+ InetAddress.getLocalHost().getHostAddress() + "PUERTO" + PUERTO);

while(true){

    s = ss.accept();
    ParticipanteProxy part_prox = new ParticipanteProxy(s, elGestor);

}//while
        // TODO code application logic here
    }//main
    
}// class
