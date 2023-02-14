package p1;

public class Coseno
	extends Senoidal
{
	public Coseno (double amplitud,  double w) {
		this (amplitud, w, 0.0);
	} // ()

	public Coseno (double amplitud,  double w, double fase) {
		super (amplitud, w, fase);
	} // ()

	public double valor(double t) {
		// COMPLETAR
                return super.amplitud * Math.cos(t * super.w + super.fase);
		
	}

} // class
