package p1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author Jordi
 */
public class Grafica
	extends JFrame {

	private Canvas lienzo;
	private Muestras losDatos = null;

	public Grafica() {
		super.setTitle("Gráfica");
		super.setBounds(30, 30, 800, 600);

		// -----------------------------------------------------------------
		lienzo = new Canvas() {

			private Rectangle  marc;
			private double anchoDatos;
			private double altoDatos;
			private int separacion = 60;

			@Override
			public void paint(Graphics g) {


				marc = new Rectangle (separacion, separacion, super.getWidth()-2*separacion, super.getHeight()-2*separacion);


				g.setColor(Color.RED);
				g.drawRect(marc.x, marc.y, marc.width, marc.height);

				if (losDatos == null) {
					return;
				}

				anchoDatos = losDatos.maxX() - losDatos.minX();
				altoDatos = losDatos.maxY() - losDatos.minY();

				// ticks para el eje Y
				double sup = Math.ceil(losDatos.maxY());
				double inf = Math.ceil(losDatos.minY());
				double paso = Math.ceil((sup-inf) / 10.0);
				//System.out.println ("sup="+sup +" inf="+inf + " paso="+paso);
				for (int i=0; i<9; i++) {
					g.setColor(Color.RED);
					//           x0      y0             x1         y1
					g.drawLine(marc.x, yAf(sup),            marc.x-5, yAf(sup));

					//g.drawLine(marc.x, separacion+i*marc.height/10, marc.x-5, separacion+i*marc.height/10);

					g.setColor(Color.BLACK);
					g.drawString(String.format("%.2f",sup) , marc.x-45, yAf(sup));
					sup -= paso;
				}

				// pintar los datos
				int c1;
				int f1;
				int c2;
				int f2;

				g.setColor(Color.BLUE);
				c1 = xAc(losDatos.indice(0));
				f1 = yAf(losDatos.muestra(0));
				for (int i = 1; i <= losDatos.talla() - 1; i++) {

					c2 = xAc(losDatos.indice(i));
					f2 = yAf(losDatos.muestra(i));

					g.setColor(Color.BLUE); // muestra como punto
					g.fillRect(c1-3,f1-3,6,6);

					g.setColor(Color.LIGHT_GRAY); // altura muestra
					g.drawLine(c1,f1,c1,yAf(0));

					// tick
					g.setColor(Color.RED); 
					g.drawLine(c1,marc.height+marc.y,c1,marc.height+marc.y+5);
					if ((i-1)%5==0) {
						g.drawLine(c1,marc.height+marc.y,c1,marc.height+marc.y+15);
						g.setColor(Color.BLACK);
						g.drawString(String.format("%.2f",losDatos.indice(i-1)), c1-8,marc.height+marc.y+22);
					}

					// linea continua entre muestras
					g.setColor(Color.MAGENTA);
					g.drawLine(c1, f1, c2, f2);

					// para despues
					c1 = c2;
					f1 = f2;
				} // for

				// ultimo tick
				g.setColor(Color.RED);
				g.drawLine(c1,marc.height+marc.y,c1,marc.height+marc.y+15);
				g.setColor(Color.BLACK);
				g.drawString(String.format("%.2f",losDatos.indice(losDatos.talla()-1)),c1-8,marc.height+marc.y+22);

				// la ultima muestra y su altura
				g.setColor(Color.BLUE);
				g.fillRect(c1-3,f1-3,6,6);
				g.setColor(Color.GRAY); // altura muestra
				g.drawLine(c1,f1,c1,yAf(0));

				// eje X (y=0)
				g.setColor(Color.BLACK);
				g.drawLine(marc.x-10, yAf(0), marc.width+marc.x+10, yAf(0)); // eje X en y==0
			} // paint

			private int xAc(double x) {
				return (int) Math.floor(marc.width * (x - losDatos.minX()) / (anchoDatos)) + separacion;

			}

			private int yAf(double y) {
				// para que este a la misma escala ejes X e Y
				// pero a lo mejor algunos puntos no se ven por que "se salen"
				return (int) Math.floor(marc.height * (losDatos.maxY() - y) / (altoDatos)) + separacion;

			}
		}; // new Canvas
		// -----------------------------------------------------------------

		super.add(lienzo);

		super.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				((JFrame) e.getSource()).dispose();
				System.exit (0);
			}
		});

		super.setVisible(true);
	} // constructor Grafica ()

	public void dibuja(Muestras datos) {
		losDatos = datos;
		lienzo.repaint();
	} // ()

	public void dibuja(Muestras datos, String titulo) {
		super.setTitle(titulo);
		this.dibuja(datos);
	}  // ()

} // class

