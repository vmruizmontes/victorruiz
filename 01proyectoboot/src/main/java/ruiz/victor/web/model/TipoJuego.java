package ruiz.victor.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipojuego")
public class TipoJuego {
	
	private int id;
	private String nombre;
	private int numerojugadores;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumerojugadores() {
		return numerojugadores;
	}
	public void setNumerojugadores(int numerojugadores) {
		this.numerojugadores = numerojugadores;
	}
	

}
