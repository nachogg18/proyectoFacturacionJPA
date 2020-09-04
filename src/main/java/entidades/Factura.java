package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "factura")
@Data
@Builder

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
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_cliente")
	private Cliente cliente;
	
	
	//@OneToMany(cascade = CascadeType.ALL,orphanRemoval=true)
	//private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
	
	@OneToMany(mappedBy="factura",cascade = CascadeType.ALL,orphanRemoval=true)
	@Builder.Default
	private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
	
	

}
