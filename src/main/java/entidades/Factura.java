package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "total")
	private int total;
	
	public Factura() {
		
	}

	public Factura(String fecha, int numero, int total) {
		super();
		this.fecha = fecha;
		this.numero = numero;
		this.total = total;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	

	
	
}
