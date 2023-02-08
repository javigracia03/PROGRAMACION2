
package echoTCP;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author Jordi
 */
public class ServidorMultiHilo {

	public static final int PUERTO = 1234;

	public static void main(String[] aArgs)
		throws java.io.IOException
	{

		ServerSocket socketServidor;
		Socket	socketconectado;
		String	linea;

		System.out.println("*****************************************************");
		System.out.println("Para contactar conmigo: ");
		System.out.println ("\n       "+InetAddress.getLocalHost().getHostAddress() +" " + PUERTO);
		System.out.println ("       "+InetAddress.getLocalHost().getHostName() +" " + PUERTO);
		System.out.println("*****************************************************");


		//
		// creo un socket de servidor
		//
		socketServidor = new ServerSocket (PUERTO);

		//
		// por siempre
		//
		while (true) {

			System.out.print("espero conexiones ... ");

			// accepto conexions: aquí espero
			socketconectado = socketServidor.accept ();

			//
			// cuando sigo: alguien se ha conectado
			//
			System.out.println("conexión establecida");

			//
			// creo un objeto que realizará el trabajo
			// con un thread propio
			//
			new HiloServidor (socketconectado);
			// una vez hecho, me vuelvo a esperar

		} // while true

	} // ()

} // class

