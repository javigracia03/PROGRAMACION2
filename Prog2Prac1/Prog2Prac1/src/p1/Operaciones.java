
package p1;

import java.util.ArrayList;

/**
 *
 * @author nadie
 */
public class Operaciones {

	//.........................................................................
	//.........................................................................
	public static Muestras tomarMuestras (Funcion f, double xMin, double xMax, double delta) {

		ArrayList<Double> indices = new ArrayList<Double> ();
		ArrayList<Double> muestras = new ArrayList<Double> ();

		for (double x=xMin; x<=xMax; x=x+delta) {
			indices.add(x);
			muestras.add ( f.valor(x));
		}

		Muestras res = new Muestras (indices, muestras);

		return res;
	} // ()

	//.........................................................................
	//.........................................................................
	public static double integral (Funcion f, double xMin, double xMax, double delta) {

		Muestras m = tomarMuestras (f, xMin, xMax, delta);

		return Operaciones.integral(m);
	} // ()

	//.........................................................................
	//.........................................................................
	public static double integral (Muestras m) {
		// COMPLETAR
                double sum = 0;
                for (int i=1; i<= m.talla()-1; i++){
                    double base = m.indice(i)-m.indice(i-1);
                    sum = sum + m.muestra(i)*base;
                
                }//for
		return sum;
	} // ()

	//.........................................................................
	// creamos un objeto senyal como sumatorio de cosenos
	// con las frecuencias y amplitudes recibidas
	//.........................................................................
	public static Senyal sintetizarSenyal (FrecuenciasAmplitudes fa) {
		// COMPLETAR
                ArrayList<Senoidal> cosenos = new ArrayList<Senoidal>(); //UTILIZO ARRAY DE SENOIDALES PARA PODER CREAR EL OBJETO DE TIPO SENYAL POSTERIORMENTE
                for (int i=0; i<=fa.talla()-1; i++){
                    double a = fa.getAmplitudEn(i);
                    double f = fa.getFrecuenciaEn(i);
                    Coseno cos = new Coseno(a,f);
                    cosenos.add(cos);
                }//for
                Senyal res = new Senyal(cosenos); 
		return res;
	} // ()

	//.........................................................................
	//.........................................................................
	public static FrecuenciasAmplitudes analizarMuestras (Muestras m) {
		// COMPLETAR
                ArrayList<Double> vFrec = new ArrayList();
                ArrayList<Double> vAmpl = new ArrayList();
                double periodo = m.periodo();
                double ts = m.indice(1) - m.indice(0);
                
                int x = m.talla();
                double talla = Double.parseDouble(String.valueOf(x));
                
                for (double k=1; k<= (talla)/2; k++){

                    vFrec.add(k);
                    Coseno c = new Coseno(1,k);
                    Muestras mc = Operaciones.tomarMuestras(c, 0, periodo, ts);
                    Muestras mp = m.multiplicar(mc);
                    double a = (2/periodo) * Operaciones.integral(mp);
                    vAmpl.add(a);
                }//for 
                
                FrecuenciasAmplitudes res = new FrecuenciasAmplitudes(vFrec,vAmpl);
                return res;
                

	} // ()

} //
