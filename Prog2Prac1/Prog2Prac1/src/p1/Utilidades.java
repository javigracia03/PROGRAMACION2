package p1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.ArrayList;

//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
public class Utilidades {

	//.........................................................................
	//.........................................................................
	public static int leerEntero (String mensaje) {

		int v = Integer.parseInt( JOptionPane.showInputDialog(mensaje) );

		return v;
	} // ()

	//.........................................................................
	//.........................................................................
	public static double leerReal (String mensaje) {

		return  Double.parseDouble( JOptionPane.showInputDialog(mensaje) );
	} // ()

	//.........................................................................
	//.........................................................................
	public static void muestraMensaje (String mensaje) {

		JOptionPane.showMessageDialog(null, mensaje);
	} // ()

	//.........................................................................
	//.........................................................................
	public static double[] leerArrayDeReales (String mensaje) {

		// leo un texto
		String loLeido = JOptionPane.showInputDialog(mensaje) ;

		// la siguiente funcion hace la transformacion
		return textoAArrayDouble(loLeido);

	} // ()

	//.........................................................................
	//.........................................................................
	public static double[] textoAArrayDouble (String texto) {

		// de texto paso a vector de double
		ArrayList<Double> almacen = textoAArrayListDouble(texto);

		// de vector de double paso a array de double
		// (los copio del vector al array resultado)
		double[] resultado = new double[almacen.size()];

		for (int i=0; i<=resultado.length-1; i++) {
			resultado[i] = almacen.get(i);
		}

		return resultado;
	} // ()

	//.........................................................................
	//.........................................................................
	public static ArrayList<Double> textoAArrayListDouble (String texto) {

		// el Scanner me sacara los numeros de uno en uno con .nextDouble()
		// el separador enteros/decimanes sera el punto (como en US)
		Scanner troceador = new Scanner (texto).useLocale(java.util.Locale.US);

		ArrayList<Double> resultado = new ArrayList<Double> ();

		double x;

		// saco los numeros del string, mientras haya
		while ( troceador.hasNextDouble() ) {
			x = troceador.nextDouble();
			resultado.add(x);
		}

		return resultado;
	} // ()

	//.........................................................................
	//.........................................................................
	public static void muestraArrayList (String mensaje, ArrayList<?> vec) {

		StringBuffer texto = new StringBuffer (mensaje + "\n");

		for (Object o : vec) {
			texto.append(o + ", ");
		}

		System.out.println (texto);

		JOptionPane.showMessageDialog(null, texto.toString());
	} // ()

	//.........................................................................
	//.........................................................................
	// de 1 linea -> sacamos 1 vector
	public static ArrayList<ArrayList<Double>> textoAArrayListArrayListDouble (String texto) {
		Scanner troceador = new Scanner (texto);
		troceador.useLocale(java.util.Locale.US);
		troceador.useDelimiter("\n");

		ArrayList<ArrayList<Double>> res = new ArrayList<ArrayList<Double>>();

		String s;
		while ( troceador.hasNext()) {
			// saco una linea de texto
			s = troceador.next ();
			ArrayList<Double> vd = Utilidades.textoAArrayListDouble(s);
			res.add(vd);
		}

		return res;
	} // ()

	//.........................................................................
	//.........................................................................
	// lee todo el fichero
	public static String leeFichero (String nombre) 
		throws FileNotFoundException, IOException {

		FileReader f = new FileReader (nombre);
		StringBuilder sb = new StringBuilder();

		int car;
		while (  (car = f.read ()) > 0 ) {
			sb.append((char) car);
		}

		f.close();
		return sb.toString();
	} // ()

	//.........................................................................
	//.........................................................................
	// datos en una linea
	public static ArrayList<Double> ficheroAArrayListDouble (String nombre)
		throws FileNotFoundException, IOException {

		return Utilidades.textoAArrayListDouble(Utilidades.leeFichero(nombre));
	} // ()

	//.........................................................................
	//.........................................................................
	// datos en lineas (1 linea -> 1 vector)
	public static ArrayList<ArrayList<Double>> ficheroAArrayListArrayListDouble (String nombre)
		throws FileNotFoundException, IOException {

		return Utilidades.textoAArrayListArrayListDouble(Utilidades.leeFichero(nombre));
	} // ()

	//.........................................................................
	//.........................................................................
	public static void escribeEnNuevoFichero (String nombre, String texto) throws IOException {
		FileWriter f = new FileWriter (nombre);
		f.write(texto);
		f.close();
	} // ()


	//.........................................................................
	//.........................................................................
	// de 1 columna -> sacamos 1 vector
	public static ArrayList<ArrayList<Double>> ficheroColumnasAArrayListArrayListDouble (String nombre) throws FileNotFoundException, IOException {

		ArrayList<ArrayList<Double>> vvd = Utilidades.textoAArrayListArrayListDouble(Utilidades.leeFichero(nombre));
		// en vvd tenemos 1 fila -> 1 vector

		int filas = vvd.size();
		int columnas = vvd.get(0).size();

		// System.out.println (" filas x columnas = " + filas + columnas );
		// System.out.println ("=================");

		ArrayList<ArrayList<Double>> res = new ArrayList<ArrayList<Double>> ();
		// el resultado tendra tantas filas como casillas(columnas) el primer vector de vvd (los demás serán iguales, esperemos)
		for (int f =0; f<=columnas-1; f++) {
			ArrayList<Double> nuevo = new ArrayList<Double> ();
			res.add(nuevo);
			for (int c=0; c<=filas-1; c++) {
				nuevo.add( vvd.get(c).get(f));
			} // for
		} // for

		return res;
	} // ()


} // class Utilidades
