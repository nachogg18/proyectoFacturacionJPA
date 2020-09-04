package entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;



@Entity
@Table(name = "detalle_Factura")
@Data
@Builder
public class DetalleFactura implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column( name = "subtotal")
	private int subtotal;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_articulo")
	@Exclude
	@lombok.ToString.Exclude
	private Articulo articulo;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_factura")
	@Exclude
	@lombok.ToString.Exclude
	private Factura factura;
	
	
	
}
