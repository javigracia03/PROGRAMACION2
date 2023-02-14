package p1;

import java.util.ArrayList;

public class FrecuenciasAmplitudes {

	private Muestras frecuenciasAmplitudes;

	public FrecuenciasAmplitudes (ArrayList<Double> frecuencias, ArrayList<Double> amplitudes) {

		// delego en la clase Muestras, interpretando indices como frecuencias
		// y muestras como amplitudes
		this.frecuenciasAmplitudes = new Muestras(frecuencias, amplitudes);

	} // ()

	public int talla () {
		return this.frecuenciasAmplitudes.talla();
	}

	public double getFrecuenciaEn (int pos) {
		return this.frecuenciasAmplitudes.indice(pos);
	}

	public double getAmplitudEn (int pos) {
		return this.frecuenciasAmplitudes.muestra(pos);
	}

	public Muestras comoMuestras () {
		return (Muestras) this.frecuenciasAmplitudes;
		// no hace falta devolver una copia (para evitar
		// manipulaciones) porque Muestras es RO
	} // ()

} // class
