package ruiz.victor.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="juego")
public class Juego {
	
	private int id;
	private String nombre;
	private TipoJuego tipojuego;
	
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
	@ManyToOne
	@JoinColumn(name="tipojuegos")
	public TipoJuego getTipojuego() {
		return tipojuego;
	}
	public void setTipojuego(TipoJuego tipojuego) {
		this.tipojuego = tipojuego;
	}

	
}
