
package servidorFicheros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Utilidades;

/**
 *
 * @author Jordi
 */
public class HiloServidor
	implements Runnable
{
	
	// socket donde estamos conectados
	private Socket elSocket;

	// stream para leer (recibir)
	private InputStream entrada;
	// stream para escribir (enviar)
	private OutputStream salida;


	//......................................................................
	//......................................................................
	public HiloServidor (Socket con)
		throws java.io.IOException
	{

		// guarda el socket (que me envía ServidorMultiHilo (en while true) )
		this.elSocket = con;

		// obtén streams para  entrada (recepción) y salida (envío)
		this.entrada = con.getInputStream();
		this.salida = con.getOutputStream();


		//
		// crea un trhead para ejecute esta clase
		// y arráncalo
		//
		Thread th = new Thread (this);
		th.start (); // ahora hay un nuevo thread en run()

	} // ()
	
	//......................................................................
	//......................................................................
	public void run ()
	{

            try {
                // COMPLETAR
                String linea = IO.leeLinea(this.entrada);
                System.out.println(linea);
                
                String[] trozos = linea.split(" ");
                
                if(trozos.length != 2){
                    
                    IO.escribeLinea("HTTP/1.1 400 Bad Request : la solicitud no tiene 2 palabras", this.salida);
                    IO.escribeLinea("", this.salida);
                    entrada.close();
                    salida.close();
                    elSocket.close();
                            
                }// if
                else if("GET".equals(trozos[0]) == false){
                    
                    IO.escribeLinea("HTTP/1.1 400 Bad Request : la solicitud no es GET", this.salida);
                    entrada.close();
                    salida.close();
                    elSocket.close();
                }//else if
                else{
                    
                    try{
                    FileInputStream fich = new FileInputStream(trozos[1]);
                    IO.escribeLinea("HTTP/1.1 200 OK", this.salida);
                    IO.escribeLinea("",this.salida);
                    int numBytes = IO.copia(fich, this.salida);
                    entrada.close();
                    salida.close();
                    elSocket.close();
                    
                    }
                    catch(FileNotFoundException err){
                        System.out.println("HTTP/1.1 404 Not Found : no he econtrado el recurso" + err.getMessage());
                            entrada.close();
                            salida.close();
                            elSocket.close();
                    }
                }//else
                
                
                //Utilidades.muestraMensajeG("HiloServidor.run(): estoy incompleto");
            } // ()
            catch (IOException err) {
                System.out.println("Se ha producido un error" + err.getMessage());
            }


	}

} // class

