
package p1;

public abstract class Senoidal
	implements Funcion
{
	protected double amplitud;
	protected double fase;
	protected double w;

	public Senoidal (double amplitud,  double w) {
		this (amplitud, w, 0.0);
	} // ()

	public Senoidal (double amplitud,  double w, double fase) {
		this.amplitud = amplitud;
		this.w = w;
		this.fase = fase;
	} // ()

	public double getAmplitud() {
		return amplitud;
	}

	public double getFase() {
		return fase;
	}

	public double getW() {
		return w;
	}

	public String aTexto () {
		return "" + this.amplitud + "senoidal(" + this.w + "x +" + this.fase+")";
	}

} // class
