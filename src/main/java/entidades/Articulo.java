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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Exclude;

@Entity
@Table(name = "articulo")
/*@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
*/
@Data
@Builder
public class Articulo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "denominacion")
	private String denominacion;
	
	@Column(name = "precio")
	private int precio;
	
	@OneToMany(mappedBy="articulo",cascade = CascadeType.PERSIST)
	@Default
	@Exclude
	@lombok.ToString.Exclude
	private List<DetalleFactura> detallesFacturas = new ArrayList<DetalleFactura>();

	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name="articulo_categoria",
			joinColumns=@JoinColumn(name="articulo_id"),
			inverseJoinColumns = @JoinColumn(name="categoria_id"))
	@Default
	@Exclude
	@lombok.ToString.Exclude
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	
	
	
	

}