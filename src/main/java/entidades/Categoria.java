package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Entity
@Table(name = "categoria")
@Data
@Builder
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "denominacion")
	private String denominacion;
	
	@ManyToMany(mappedBy = "categorias")
	@Default
	private List<Articulo> articulos = new ArrayList<Articulo>();
	
	
}
