
package p1;

import java.util.ArrayList;

/**
 *
 * @author yo
 */
public class Muestras {

	private ArrayList<Double> losIndices; // x
	private ArrayList<Double> lasMuestras; // y = f(x)

	private double muestraMenor; // para no buscarla cada vez
	private double muestraMayor; // para no buscarla cada vez

	//.........................................................................
	public Muestras (ArrayList<Double> indices, ArrayList<Double> muestras) {

		// el tamaño ha de ser el mismo
		if ( indices.size() !=  muestras.size() ) {
			throw new Error ("indices y muestras son de distinto tamaño");
		}

		// los indices han de estar ordenados <
		double a = indices.get(0);
		for (double b : indices) {
			if (a > b) {
				throw new Error ("los indices no estan ordenados de menor a mayor");
			}
			a = b;
		} // for

		// todo correcto:
		losIndices = indices;
		lasMuestras = muestras;

		// busco ahora la menor y la mayor muestra y las guardo
		muestraMenor = java.util.Collections.min(lasMuestras);
		muestraMayor = java.util.Collections.max(lasMuestras);

	} // ()

	//.........................................................................
	public double periodo () {
		return losIndices.get(losIndices.size()-1) - losIndices.get(0);
	}

	//.........................................................................
	public double indice(int i) {
		return losIndices.get(i);
	}

	//.........................................................................
	public double muestra(int i) {
		return lasMuestras.get(i);
	}

	//.........................................................................
	public int talla () {
		return losIndices.size();
	}

	// ............................................................
	// mis muestras + otras -> nuevas
	//  (mismos indices en mis muestras y en otras)
	public Muestras multiplicar(Muestras otras) {
            ArrayList<Double> nuevas = new ArrayList<Double>();
            for (int i=0; i<= this.talla()-1; i++){
                
                nuevas.add(i,this.lasMuestras.get(i)* otras.lasMuestras.get(i));
            }//for
            Muestras res = new Muestras(this.losIndices,nuevas);
		
		return res;
	} // ()

	//.........................................................................
	// para sumar o para multiplicar
	// comprobamos que mis indices coinciden con el
	// de los otros
	private boolean mismosIndices (Muestras otras)  {
		// comprobar que hay el mismo numero
		if (this.talla() != otras.talla())  {
			return false;
		}
		// comprobar que los indices mios y de otras coinciden
		for (int i=0; i<=this.talla()-1; i++) {
			double d = this.indice(i) / otras.indice(i);
			// si son iguales la divisón debería dar 1
			if ( d < 0.95 || d>1.05) {
				return false;
			}
		} // for
		return true;
	} //()


	//.........................................................................
	public double minX () {
		// asumimos que los losIndices estan ordenados <
		return losIndices.get(0);
	}

	//.........................................................................
	public double maxX () {
		// asumimos que los losIndices estan ordenados <
		return losIndices.get(losIndices.size()-1);
	}

	//.........................................................................
	public double minY () {
		return muestraMenor;
	}

	//.........................................................................
	public double maxY () {
		return muestraMayor;
	}

	//.........................................................................
	public String aTexto () {
		StringBuilder texto = new StringBuilder ();

		// escrito en columnas
		for (int i=0; i<=this.talla()-1; i++) {
			texto.append(this.indice(i)).append(" ").append(this.muestra(i)).append("\n");
		}

		return texto.toString();
	} // ()

} // class