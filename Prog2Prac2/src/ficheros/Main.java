
package ficheros;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import util.Utilidades;

public class Main {

	public static void main (String[] args) {
            
           
            try {
                String nombre = Utilidades.leerTextoC("ESCRIBE TU NOMBRE");
                String nom_sal = Utilidades.leerTextoC("ESCRIBE EL NOMBRE DEL FICHERO DE SALIDA");
                FileWriter FW = new FileWriter("C:\\Users\\javie\\OneDrive - UPV\\UNI\\PROGRAMACIÓN 2\\PRACTICA 2\\Prog2Prac2\\PRUEBAS\\EJERCICIO NOMBRE\\" + nom_sal);
                PrintWriter salida = new PrintWriter(FW);
                salida.println(nombre);
                FW.close();
                salida.close(); 
                
            } // ()
            catch (FileNotFoundException err) {
                System.out.println( err.getMessage());
            }
            catch (IOException err) {
                System.out.println( err.getMessage());
            }

	}
} // class
