/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
package pruebasql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------

class Persona {

	private final String nombre;
	private final String apellidos;
	private final String dni;

	// nombre: Texto, apellidos: Texto, dni: Texto -> () ->
	public Persona(String n, String a, String d) {
		this.nombre = n;
		this.apellidos = a;
		this.dni = d;
	}

	// Texto <- () <-
	public String getNombre() {
		return this.nombre;
	}

	// Texto <- () <-
	public String getApellidos() {
		return this.apellidos;
	}

	// Texto <- () <-
	public String getDNI() {
		return this.dni;
	}
} // class

// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
class LogicaDelNegocio {

	private final Connection laConexion;

	// ---------------------------------------------------------------------
	// urlBD: Texto -> () ->
	// ---------------------------------------------------------------------
	public LogicaDelNegocio(String urlBD) throws SQLException {
		this.laConexion = DriverManager.getConnection(urlBD);

		assert this.laConexion != null;
	} // ()

	// ---------------------------------------------------------------------
	// dni: Texto -> () <-
	// Persona    <-
	// ---------------------------------------------------------------------
	public Persona getPersonaPorDNI(String dni) {
		try {
			assert this.hayConexion();
			String textoSQL = "select * from Persona where dni='" + dni + "';";

			Statement sentencia = this.laConexion.createStatement();

			ResultSet resultados = sentencia.executeQuery(textoSQL);
			if (resultados.next() == false) {
				return null;
			}

			return new Persona(resultados.getString("nombre"), resultados.getString("apellidos"), resultados.getString("dni"));

		} catch (SQLException ex) {
			return null;
		}

	} // ()

	// ---------------------------------------------------------------------
	// VoF <- () <- 
	// ---------------------------------------------------------------------
	private boolean hayConexion() {
		try {
			return this.laConexion.isClosed() == false;
		} catch (SQLException ex) {
			return false;
		}
	}

	// ---------------------------------------------------------------------
	//  () -> 
	// ---------------------------------------------------------------------
	public void cerrarConexion() {
		try {
			this.laConexion.close();
		} catch (SQLException ex) {
// ignoro porque, total, iba a cerrar
		}

	} // ()
} // class

// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
public class Pruebasql {

	// ---------------------------------------------------------------------
	// ---------------------------------------------------------------------
	public static void main(String[] args) {

		try {

			LogicaDelNegocio logica = new LogicaDelNegocio("jdbc:sqlite:C:/Users/javie/OneDrive - UPV/UNI/1º/PROGRAMACIÓN 2/PRCATICA 4/pruebasql/src/pruebasql/datos.bd");

			Persona p = logica.getPersonaPorDNI("20123456A");

			assert "Juan".equals(p.getNombre());

			System.out.println(" apellidos = " + p.getApellidos());

		} catch (SQLException ex) {
			System.out.println(" excepcion = " + ex.getMessage());
		}
	} // ()

} // class
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------

