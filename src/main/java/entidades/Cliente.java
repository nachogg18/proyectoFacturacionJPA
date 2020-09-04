package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

import javax.persistence.OneToOne;

@Entity
@Table(name = "cliente")
@Data
@Builder
public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "dni", unique = true)
	private int dni;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_domicilio")
	
	private Domicilio domicilio;
	
	
	@OneToMany(mappedBy="cliente")
	@Default
	private List<Factura> facturas = new ArrayList<Factura>();
	
	
	
}
