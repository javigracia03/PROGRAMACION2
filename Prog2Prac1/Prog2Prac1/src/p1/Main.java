
package p1;

//------------------------------------------------------------------------------

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static final double DOS_PI = 2.0 * Math.PI;

	public static void main (String[] args) throws IOException {
		pruebaSenyal();
		pruebaMultiplicar();
		pruebaSintetizar();
		pruebaAnalizar();
	}

	public static void pruebaSenyal () throws IOException {
            
            Coseno f1 = new Coseno(8,2,0);
            Coseno f2 = new Coseno(4,10,0);
            ArrayList<Senoidal> lista = new ArrayList<Senoidal>();
            lista.add(f1);
            lista.add(f2);
            Senyal s1 = new Senyal(lista);
            double periodo = DOS_PI;
            double ts = periodo/100;
            Muestras m = Operaciones.tomarMuestras(s1, 0.0,periodo, ts);
            
            Utilidades.escribeEnNuevoFichero("senyal.dat", m.aTexto());
            Grafica graf1 = new Grafica();
            graf1.dibuja(m,"prueba señal");
                 
	}

	public static void pruebaMultiplicar () throws IOException  {
            
            double periodo = DOS_PI;
            double ts = periodo/100;
            Coseno c1 = new Coseno (2.0, 2.0);
            Coseno c2 = new Coseno (1.0, 5.0);
            Muestras m1 = Operaciones.tomarMuestras (c1, 0.0, periodo, ts);
            Muestras m2 = Operaciones.tomarMuestras (c2, 0.0, periodo, ts);
            Muestras m3 = m1.multiplicar(m2);
            Utilidades.escribeEnNuevoFichero("senyal.dat", m3.aTexto());
            Grafica graf1 = new Grafica ();
            graf1.dibuja(m3, "prueba multiplicar");
        
	}

	public static void pruebaSintetizar () throws IOException {
            
            ArrayList<Double> frec = new ArrayList();
            ArrayList<Double> amp = new ArrayList();
            frec.add(1.0);
            frec.add(4.0);
            frec.add(5.0);
            amp.add(4.0);
            amp.add(2.0);
            amp.add(1.0);
            FrecuenciasAmplitudes fya = new FrecuenciasAmplitudes(frec,amp);
            Senyal seny1 = Operaciones.sintetizarSenyal(fya);
            
            double periodo = DOS_PI;
            double ts = periodo/100;
            Muestras m1 = Operaciones.tomarMuestras(seny1, 0, periodo, ts);
            Utilidades.escribeEnNuevoFichero("senyal.dat", m1.aTexto());
            Grafica graf1 = new Grafica ();
            graf1.dibuja(m1, "prueba sintetizar");
            
	} // main ()

	public static void pruebaAnalizar () throws IOException {
            
            Coseno c1 = new Coseno(8,3);
            Coseno c2 = new Coseno(4,5);
            Coseno c3 = new Coseno(3,8);
            Coseno c4 = new Coseno(7,10);
            ArrayList<Senoidal> list = new ArrayList();
            list.add(c1);
            list.add(c2);
            list.add(c3);
            list.add(c4);
            
            Senyal s1 = new Senyal(list);
            double periodo = DOS_PI;
            double ts = periodo/100;
            Muestras m1 = Operaciones.tomarMuestras(s1, 0, periodo, ts);
            Utilidades.escribeEnNuevoFichero("senyal.dat", m1.aTexto());
            Grafica g1 = new Grafica();
            g1.dibuja(m1,"prueba analizar 1");
            
            FrecuenciasAmplitudes fya = Operaciones.analizarMuestras(m1);
            Muestras m2 = fya.comoMuestras();
            Utilidades.escribeEnNuevoFichero("senyal1.dat", m2.aTexto());
            Grafica g2 = new Grafica();
            
            g2.dibuja(m2,"prueba frecuencias y amplitudes");
            
            Senyal s2 = Operaciones.sintetizarSenyal(fya);
            Muestras m3 = Operaciones.tomarMuestras(s2, 0, periodo, ts);
            Utilidades.escribeEnNuevoFichero("senyal2.dat", m3.aTexto());
            Grafica g3 = new Grafica();
            
            g3.dibuja(m3,"prueba analizar 2");            
            
	} // ()

} // class
