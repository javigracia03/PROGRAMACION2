package servidorFicheros;

import java.io.*;
import java.net.*;
import util.Utilidades;

/**
 *
 * @author Jordi
 */
public class Cliente {

	/* 
	 * main INCOMPLETO ! Busca COMPLETAR y haz lo que dice
	 *
	 * (Hay varios COMPLETAR hasta COMPLETAR-ULTIMO )
	 */
	public static void main(String[] args) {

		String hostServidor = "localhost"; 

		String nombreRecurso = "/tmp/hola.txt";
                
                String nombreRecursoFinal = "D:/Users/javier/Desktop/nuevo.txt";

		int PUERTO = 1234;

		// saca el el nombre del servidor, el puerto y nombre del fichero de la linea de comandos
		if (args.length == 3) {
			hostServidor = args[0];
			PUERTO = Integer.parseInt(args[1]);
			nombreRecurso = args[2];
		}

		// empezamos
		Socket sock;

		try {
			sock = new Socket(hostServidor, PUERTO);
		} catch (IOException err) {
                    
                    System.out.println("No ha sido posible conectarse a " + hostServidor + " " + PUERTO + " " + err.getMessage());
			// COMPLETAR: informa que no hemos podido conectarnos a hostServidor PUERTO
			return;
		}

		//
		// ya estoy conectado
		//
		Utilidades.muestraMensajeC("ya estoy conectado con " + hostServidor + ":" + PUERTO);

		try {

			//
			// obtengo streams para leer y escribir a través del socket (en modo binario)
			//
			InputStream entrada = sock.getInputStream();
			OutputStream salida = sock.getOutputStream(); // COMPLETAR, cambia null por la obtención del OutputStream del socket
                        //System.out.println("hola");
			//
			// envio el mensaje
			//
			// COMPLETAR: construye la línea de solicitud GET <nombre de recurso> (ponlo en lugar de null)
			String solicitud = "GET" + " " + nombreRecurso ;
                        
                   

			Utilidades.muestraMensajeC("orden que envio >" + solicitud + "<"); // informo (localmente)

			// COMPLETAR: con IO.escribeLinea() envía la solicitud al servidor a través de salida
			IO.escribeLinea(solicitud, salida); // envío al servidor

			//
			// ahora, espero la respuesta
			// COMPLETAR: lee la respuesta del servidor y luego una línea vacía con IO.leeLinea()
			String respuesta = IO.leeLinea(entrada);
			String vacía = IO.leeLinea(entrada);

			Utilidades.muestraMensajeC("el servidor me ha respondido  >" + respuesta + "<");

			// troceo la respuesta, para ver qué hay
			String[] trozos = respuesta.split(" ");

			String codigoError = trozos[1]; // el codigo de error es la segunda palabra
                        
                        if(codigoError.equals("200")==false){
                            
                            System.out.println("Ha habido algun error");
                            return;
                        
                        }

			// COMPLETAR: si el string codigoError no es "200"
			// avisa de que ha habido problemas y termina con return.

			// ...

			// si continuamos todo está yendo bien
			Utilidades.muestraMensajeC("el servidor ha aceptado la solicitud");

			// intento abrir un fichero local para guardar lo que me envían (modo binario)
			try {
                            
                            //FileOutputStream fich = new FileOutputStream(nombreRecursoFinal);
                            FileOutputStream fich = new FileOutputStream(nombreRecurso);
                        
                        
                        
			// COMPLETAR: intenta abrir un fichero con FileOutputStream con el nombre guardado en nombreRecurso
			// captura la excepcion FileNotFoundException
			// para escribir, si se da,
			// "No puedo abrir el fichero para guardar. Terminamos \n"
			// y luego terminar

			// COMPLETAR-ULTIMO: copia con IO.copia los bytes que nos llegan de entrada al fichero fich
			int numBytes = IO.copia(entrada, fich); // cambia el 0 por la llamada a IO.copia

			// cierro los stream
			fich.close();
			entrada.close();
			salida.close();
			sock.close();
                        
			// POR FIN !
			Utilidades.muestraMensajeC("Recibidos " + numBytes + " bytes");
			Utilidades.muestraMensajeC(" *** FINAL FELIZ *** ");
			Utilidades.muestraMensajeG(" *** FINAL FELIZ *** ");
                        
                        
                        } catch (FileNotFoundException err){
                            System.out.println("No puedo abrir el fichero para guardar. Tenrminamos\n " +err.getMessage());
                            return;
                        }
		} catch (IOException ex) {
			Utilidades.muestraMensajeC ("se produjo un error de entrada/salida");
		} 
	} // ()
} // class

