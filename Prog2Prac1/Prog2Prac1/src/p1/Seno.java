package p1;

public class Seno
	extends Senoidal
{
	public Seno (double amplitud,  double w) {
		this (amplitud, w, 0.0);
	} // ()

	public Seno (double amplitud,  double w, double fase) {
		super (amplitud, w, fase);
	} // ()

	public double valor(double x) {
		return super.amplitud * Math.sin(x * super.w + super.fase);
	}

} // class
