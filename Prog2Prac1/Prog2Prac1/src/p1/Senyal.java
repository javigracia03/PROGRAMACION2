package p1;

import java.util.ArrayList;

// Senyal como suma de funciones (nosotros utilizaremos
// senoidales)
public class Senyal
	implements Funcion
{
	private ArrayList<Senoidal> funciones; // funciones seno o coseno, indistintamente

	public Senyal (Senoidal f1, Senoidal ... lista ) {
		this.funciones = new ArrayList<Senoidal> ();

		this.funciones.add(f1);
		for (Senoidal f : lista) {
			funciones.add (f);
		} // for
	} // ()

	//
	// recibe un vector de cualquier cosa que sea (herede de) Senoidal
	//ORIG OK public Senyal ( ArrayList<? extends Senoidal> lista)  {
        public Senyal ( ArrayList<Senoidal> lista)  {
		// me hago una  copia (en vez de asignar)
		this.funciones = new ArrayList<Senoidal> ();
		for (Senoidal f : lista) {
			funciones.add (f);
		} // for
	} // ()

	public double valor(double x) {
            double sum = 0;
            for (int i=0;i<= this.funciones.size()-1;i++){
                sum = sum + this.funciones.get(i).valor(x);
            
            }//for
		return sum;
	} //

	public Senoidal getFuncion (int n) {
		return funciones.get(n);
	} //

} // class
